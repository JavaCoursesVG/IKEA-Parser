import utils.httpParser;

public class IKEAParser {

    public static void main(String args[])
    {
        //Furniture furnitureItem = new Furniture("Krzesło ogrodowe", "Krzesła", "Duże krzesło z wygodnym oparciem z naturalnego bambusa.", "http://www.ikea.com/pl/pl/images/products/garpen-krzeso-z-podokietnikami__0137585_PE296214_S4.JPG", 110, 80, 65, 199.99);

        httpParser parser = new httpParser();
        parser.parseUrl("http://www.ikea.com/pl/pl/catalog/products/40209795/");
        parser.parseUrl("http://www.ikea.com/pl/pl/catalog/products/S79894662/");
        parser.parseUrl("http://www.ikea.com/pl/pl/catalog/products/S09903189/");
        parser.parseUrl("http://www.ikea.com/pl/pl/catalog/products/70210801/");
    }
}
