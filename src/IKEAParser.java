import Entities.Furniture;
import utils.httpParser;

public class IKEAParser {

    public static void main(String args[])
    {
        httpParser parser = new httpParser();

        //Szafy
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bedroom/19053/?priceFilter=true&minprice=89&maxprice=5380", "wardrobes", "bedroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/19053/?priceFilter=true&minprice=89&maxprice=5380", "wardrobes", "room");

        //chairs
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/dining/10724/?priceFilter=true&minprice=89&maxprice=5380", "chairs", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/dining/20864/?priceFilter=true&minprice=89&maxprice=5380", "chairs", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/dining/22659/?priceFilter=true&minprice=89&maxprice=5380", "chairs", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/20652/?priceFilter=true&minprice=89&maxprice=5380", "chairs", "office");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/swivel_chairs/?priceFilter=true&minprice=89&maxprice=5380", "chairs", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/20652/?priceFilter=true&minprice=89&maxprice=5380", "chairs", "room");

        //Stoły i fotele
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/dining/21825/?priceFilter=true&minprice=89&maxprice=5380", "tables", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/dining/20862/?priceFilter=true&minprice=89&maxprice=5380", "tables", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/20649/?priceFilter=true&minprice=89&maxprice=5380", "tables", "office");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/20649/?priceFilter=true&minprice=89&maxprice=5380", "tables", "room");


        //Sofy i fotele
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/10661/?priceFilter=true&minprice=89&maxprice=5380", "sofas", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/10662/?priceFilter=true&minprice=89&maxprice=5380", "sofas", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/10663/?priceFilter=true&minprice=89&maxprice=5380", "sofas", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/16238/?priceFilter=true&minprice=89&maxprice=5380", "sofas", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/16239/?priceFilter=true&minprice=89&maxprice=5380", "sofas", "room");

        //łóżka
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bedroom/19039/?priceFilter=true&minprice=89&maxprice=5380", "beds", "bedroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bedroom/16284/?priceFilter=true&minprice=89&maxprice=5380", "beds", "bedroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/childrens_ikea/18755/?priceFilter=true&minprice=89&maxprice=5380", "beds", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/16285/?priceFilter=true&minprice=89&maxprice=5380", "beds", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/19039/?priceFilter=true&minprice=89&maxprice=5380", "beds", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/19037/?priceFilter=true&minprice=89&maxprice=5380", "beds", "room");

        //AGD
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/20810/?priceFilter=true&minprice=89&maxprice=5380", "agd", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/20822/?priceFilter=true&minprice=89&maxprice=5380", "agd", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/20825/?priceFilter=true&minprice=89&maxprice=5380", "agd", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/20826/?priceFilter=true&minprice=89&maxprice=5380", "agd", "bathroom");

        //Komody
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bedroom/10451/?priceFilter=true&minprice=89&maxprice=5380", "dresser", "bedroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/10711/?priceFilter=true&minprice=89&maxprice=5380", "dresser", "office");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/youth_room/10451/?priceFilter=true&minprice=89&maxprice=5380", "dresser", "room");

        //Szafki
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bedroom/20656-2/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "bedroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/childrens_ikea/18835-2/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/living_room/10475/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "room");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/10385/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "office");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/10384/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "office");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/workspaces/10382/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "office");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bathroom/20500/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "bathroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bathroom/20806/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "bathroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/bathroom/20719/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "bathroom");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/10794/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/12313/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/12316/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/12315/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "kitchen");
        parser.crawlCategory("http://www.ikea.com/pl/pl/catalog/categories/departments/kitchen/22957/?priceFilter=true&minprice=89&maxprice=5380", "cabinet", "kitchen");

        Furniture.saveToFile();
    }
}
