package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class httpParser {

    String documentUrl;
    Document htmlDocument;

    String itemName, itemDescription, itemImageUrl;
    int xItemSize, zItemSize, yItemSize;
    double itemPrice;

    public void parseUrl(String url) {
        this.documentUrl = url;

        try {

            this.htmlDocument = Jsoup.connect(documentUrl).get();

            //Get main item name
            itemName = htmlDocument.getElementById("productTypeProdInfo").ownText() + " " + htmlDocument.getElementById("name").text();

            //Item description, that is combination of sales arguments and good to know section.
            itemDescription = getDescription();

            //Parse price to match double
            itemPrice = parsePrice();

            //Get imageUrl (image size 3)
            itemImageUrl = getImageUrl(3);

            //Get size parameters
            xItemSize = parseSize("x");
            yItemSize = parseSize("y");
            zItemSize = parseSize("z");

            System.out.print(getElementInfo());

        } catch (IOException e) {
            System.err.println("Wystąpił błąd z otwarciem podanego adresu URL.");
            e.printStackTrace();
        }

    }

    private String getDescription() {
        return htmlDocument.getElementById("salesArg").ownText() + " " + htmlDocument.getElementById("goodToKnow").ownText();
    }

    private String getImageUrl(int size) {
        Element imageNode = htmlDocument.getElementById("productImg");
        return "http://www.ikea.com" + imageNode.attr("src").replaceAll("S4.JPG", "S" + size + ".JPG");

    }

    private double parsePrice() {
        int priceLength = htmlDocument.getElementById("price1").text().length();

        if (priceLength > 5) {
            String priceValue = htmlDocument.getElementById("price1").text().substring(0, priceLength - 4);
            priceValue = priceValue.replaceAll(",", ".").replaceAll(" ", "");

            return Double.parseDouble(priceValue);
        } else {
            System.err.println("Błędna cena przedmiotu (zbyt krótka)");

            return -1;
        }
    }

    private int parseSize(String dimension) {
        String metricNode = htmlDocument.getElementById("metric").ownText();

        if (dimension.equals("x")) {
            Pattern xPattern = Pattern.compile("Szerokość: (.*?) cm");
            Matcher xMatcher = xPattern.matcher(metricNode);
            if (xMatcher.find()) {
                String xTempSize = xMatcher.group(0).substring(11);
                xTempSize = xTempSize.substring(0, xTempSize.length() - 3);
                return (int) Double.parseDouble(xTempSize);
            } else {
                return 70;
            }
        } else if (dimension.equals("y")) {
            Pattern yPattern = Pattern.compile("Długość: (.*?) cm");
            Matcher yMatcher = yPattern.matcher(metricNode);
            if (yMatcher.find()) {
                String yTempSize = yMatcher.group(0).substring(9);
                yTempSize = yTempSize.substring(0, yTempSize.length() - 3);
                return (int) Double.parseDouble(yTempSize);
            } else {
                yPattern = Pattern.compile("Głębokość: (.*?) cm");
                yMatcher = yPattern.matcher(metricNode);
                if (yMatcher.find()) {
                    String yTempSize = yMatcher.group(0).substring(11);
                    yTempSize = yTempSize.substring(0, yTempSize.length() - 3);
                    return (int) Double.parseDouble(yTempSize);
                } else {
                    return 70;
                }
            }
        } else if (dimension.equals("z")) {
            Pattern zPattern = Pattern.compile("Wysokość: (.*?) cm");
            Matcher zMatcher = zPattern.matcher(metricNode);
            if (zMatcher.find()) {
                String zTempSize = zMatcher.group(0).substring(10);
                zTempSize = zTempSize.substring(0, zTempSize.length() - 3);
                return (int) Double.parseDouble(zTempSize);
            } else {
                return 70;
            }
        } else {
            System.err.println("Podano błędną płaszczyznę (dostępne x/y/z)");
            return -1;
        }
    }

    private String getElementInfo() {
        return this.itemName + "\n" + this.itemDescription + "\n" + this.itemImageUrl + "\nx: " + this.xItemSize + " y: " + this.yItemSize + " z: " + this.zItemSize + "\n\n";
    }
}
