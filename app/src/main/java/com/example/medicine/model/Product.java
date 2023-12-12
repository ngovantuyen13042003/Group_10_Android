package com.example.medicine.object;
import android.text.BoringLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private float vote;
    private String image;
    private int quantity;
    private int categoryId;
    private Integer[] ids;

    private boolean isChecked;

    public  Product(int id, String  name, String description, double price, String image, int categoryId){}
    public Product(JSONObject o) throws JSONException{
        if(o.has("id")){
            id= o.getInt("id");
        }
        if(o.has("name")){
            name= o.getString("name");
        }
        if(o.has("description")){
            description=o.getString("description");
        }
        if(o.has("price")){
            price= o.getDouble("price");
        }
        if(o.has("image")){
            image=o.getString("image");
        }
        if(o.has("categoryId")){
            categoryId = o.getInt("categoryId");
        }
    }

    public Product(int id, String name, double price, String description, float vote, String image, int quantity, int categoryId, Integer[] ids) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.vote = vote;
        this.image = image;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.ids = ids;
    }
    public Product(String name, double price, String description,String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }
    public Product(String name, double price,String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }



    public boolean isChecked() {
        return isChecked;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    public  static Product getProductId(ArrayList<Product> productlist,int productId){
        for (Product product : productlist){
            if (product.getId() == productId){
                return product;
            }
        }
        return null;
    }
}
