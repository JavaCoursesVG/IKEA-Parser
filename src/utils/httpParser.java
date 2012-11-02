package utils;

import Entities.Furniture;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class httpParser {

    String documentUrl;
    Document htmlDocument;



    public void crawlCategory(String categoryUrl, String category, String typeOfRoom) {
        ArrayList<String> itemList = new ArrayList<String>();

        try {
            this.htmlDocument = Jsoup.connect(categoryUrl).get();

            Element productList = htmlDocument.getElementById("productLists");
            org.jsoup.select.Elements productsUrls = productList.getElementsByClass("productLink");
            for (Element link : productsUrls) {
                itemList.add(matchItemId(link.attr("href")));
            }

            for(String url : itemList) {
                parseFurnitureItem(url, category, typeOfRoom);
            }

        } catch (IOException e) {
            System.err.println("Wystąpił problem z dostępem do podanego adresu URL kategorii.");
            e.printStackTrace();
        }
    }

    private String matchItemId (String url) {
        Pattern itemOnProductList = Pattern.compile("/pl/pl/catalog/products/(.*?)/");
        Matcher itemMatcher = itemOnProductList.matcher(url);
        if(itemMatcher.find()) {
            return itemMatcher.group(0).substring(24,itemMatcher.group(0).length() - 1);
        } else {
            return null;
        }
    }

    public void parseFurnitureItem(String url, String category, String typeOfRoom) {
        this.documentUrl = "http://www.ikea.com/pl/pl/catalog/products/" + url + "/";
        String itemName, itemDescription, itemImageUrl, itemBase64Image;
        int xItemSize, zItemSize, yItemSize;
        double itemPrice;

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
            itemBase64Image = imageToBase64(itemImageUrl);

            //Get size parameters
            xItemSize = parseSize("x");
            yItemSize = parseSize("y");
            zItemSize = parseSize("z");

            Furniture furnitureItem = new Furniture(itemName, category, typeOfRoom, itemDescription, itemImageUrl, itemBase64Image, xItemSize, yItemSize, zItemSize, itemPrice);


        } catch (IOException e) {
            System.err.println("Wystąpił problem z dostępem do podanego adresu URL.");
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

    private String imageToBase64(String imageUrl) {
        String encodedImage = null;
        try{
            //Open a URL Stream
            URL url = new URL(imageUrl);
            InputStream in = url.openStream();
            BufferedImage image = ImageIO.read(in);
            in.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            encodedImage = Base64.encode(baos.toByteArray());

        } catch(Exception e) {
            e.printStackTrace();
        }
        return encodedImage;
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

}
