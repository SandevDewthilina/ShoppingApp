package com.javapoint.shoppingapp;


public class Category {

    private String id, name;
    private int imageResource;

    public Category() {
    }

    public Category(String id, String name, int imageResource) {
        this.id = id;
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
