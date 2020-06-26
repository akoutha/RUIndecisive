package com.example.ruindecisive.model;

public class Restaurant {
    public String name;
    public String type;
    public String imageString;

    public Restaurant(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }


}
