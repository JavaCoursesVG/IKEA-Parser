package Entities;

import java.beans.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Furniture {

    private String id, name, category, typeOfRoom, description, imageUrl, base64Image;
    private int xSize, zSize, ySize;
    private double price;
    public static ArrayList<Furniture> furnitureList = new ArrayList<Furniture>();

    public String getId() {
        return id;
    }
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

    public Furniture(String id, String name, String category, String typeOfRoom, String description, String imageUrl, String base64Image, int xSize, int ySize, int zSize, double price) {
        this.id = id;
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

        System.out.println(this.id + " " + this.name + " has been added to the furnitureList!");
        System.out.println("furnitureList has now " + furnitureList.size() + " objects.");

    }

    public static void listFurniture() {
        for (Furniture item : furnitureList) {
            System.out.println("\n" + item.name + " " + item.description);
        }
    }

    private static String getSqlFormat(Furniture item) {
        return "VALUES ('" + item.getId() + "', '" + item.getName() + "', '" + item.getCategory() + "', '" + item.getDescription() + "', '" + item.getTypeOfRoom() + "', '" + item.getImageUrl() + "', '" + item.getBase64Image() + "', '" + item.getPrice() + "', '" + item.getxSize() + "', '" + item.getySize() + "', '" + item.getzSize()+ "')";
    }

    public static void saveToFile() {
        StringBuilder outputStringBuffer = new StringBuilder();
        BufferedWriter out = null;

        for (Furniture item : furnitureList) {
            outputStringBuffer.append(item.getId()).append("|")
                            .append(item.getName()).append("|")
                            .append(item.getDescription()).append("|")
                            .append(item.getCategory()).append("|")
                            .append(item.getTypeOfRoom()).append("|")
                            .append(item.getImageUrl()).append("|")
                            .append(item.getPrice()).append("|")
                            .append(item.getxSize()).append("|")
                            .append(item.getySize()).append("|")
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

    public static void saveToDatabase() {
        Connection conn = null;

        try
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/bazaArcheo?useUnicode=yes&characterEncoding=UTF-8";
            Class.forName("com.mysql.jdbc.Driver").newInstance ();
            conn = DriverManager.getConnection (url, userName, password);
            System.out.println ("Database connection established");

            java.sql.Statement s = conn.createStatement();
            for(Furniture item : furnitureList) {
                System.out.println(getSqlFormat(item));
                s.executeUpdate("INSERT INTO furnitureItems (id, itemName, itemCategory, itemDescription, typeOfRoom, itemImageUrl, itemBase64Image, itemPrice, sizeX, sizeY, sizeZ)" + getSqlFormat(item));
            }

            s.close ();

        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server " + e.getMessage());
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                    System.out.println ("Database connection terminated");
                }
                catch (Exception e) { /* ignore close errors */ }
            }
        }

    }
}
