package Entities;

import java.util.ArrayList;

public class Furniture {

    String name, category, description, imageUrl;
    int xSize, zSize, ySize;
    double price;

    public ArrayList<Furniture> furnitureList = new ArrayList<Furniture>();

    public Furniture(String name, String category, String description, String imageUrl, int xSize, int ySize, int zSize, double price) {
        this.name = name;
        this.category = category;
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
}
