import Entities.Furniture;
import utils.httpParser;

public class IKEAParser {

    public static void main(String args[])
    {
        httpParser parser = new httpParser();
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/20649/", "Biurka", "Pokoj");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/16239/", "Fotele", "Pokoj");

        Furniture.saveToFile();
    }
}
