package Entities;

import java.util.ArrayList;

public class Furniture {

    String name, category, typeOfRoom, description, imageUrl;
    int xSize, zSize, ySize;
    double price;

    public static ArrayList<Furniture> furnitureList = new ArrayList<Furniture>();

    public Furniture(String name, String category, String typeOfRoom, String description, String imageUrl, int xSize, int ySize, int zSize, double price) {
        this.name = name;
        this.category = category;
        this.typeOfRoom = typeOfRoom;
        this.description = description;
        this.imageUrl = imageUrl;
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        this.price = price;

        furnitureList.add(this);

        System.out.println(this.name + " has been added to the furnitureList!");
        System.out.println("furnitureList has now " + furnitureList.size() + " objects.");

    }

    public static void listFurniture() {
        for (Furniture item : furnitureList) {
            System.out.println("\n" +item.name + " " + item.description);
        }
    }
}
