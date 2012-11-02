package Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Furniture {

    private String name, category, typeOfRoom, description, imageUrl, base64Image;
    private int xSize, zSize, ySize;
    private double price;
    public static ArrayList<Furniture> furnitureList = new ArrayList<Furniture>();

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getTypeOfRoom() {
        return typeOfRoom;
    }
    public String getDescription() {
        return description;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getBase64Image() {
        return base64Image;
    }

    public int getxSize() {
        return xSize;
    }
    public int getzSize() {
        return zSize;
    }
    public int getySize() {
        return ySize;
    }

    public double getPrice() {
        return price;
    }

    public Furniture(String name, String category, String typeOfRoom, String description, String imageUrl, String base64Image, int xSize, int ySize, int zSize, double price) {
        this.name = name;
        this.category = category;
        this.typeOfRoom = typeOfRoom;
        this.description = description;
        this.imageUrl = imageUrl;
        this.base64Image = base64Image;
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
            System.out.println("\n" + item.name + " " + item.description);
        }
    }

    public static void saveToFile() {
        StringBuilder outputStringBuffer = new StringBuilder();
        BufferedWriter out = null;

        for (Furniture item : furnitureList) {
            outputStringBuffer.append(item.getName()).append(" ")
                            .append(item.getDescription()).append(" ")
                            .append(item.getCategory()).append(" ")
                            .append(item.getTypeOfRoom()).append(" ")
                            .append(item.getImageUrl()).append(" ")
                            .append(item.getPrice()).append(" ")
                            .append(item.getxSize()).append(" ")
                            .append(item.getySize()).append(" ")
                            .append(item.getzSize()).append("\n");
        }

        try {
            out = new BufferedWriter(new FileWriter("data.txt"));
            out.write(outputStringBuffer.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

}
