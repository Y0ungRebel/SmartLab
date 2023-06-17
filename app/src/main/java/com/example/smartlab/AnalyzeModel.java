package com.example.smartlab;

public class AnalyzeModel {
    String id, name, description, price, category, time_result, preparation, bio;

    public AnalyzeModel(String id, String name, String description, String price, String category, String time_result, String preparation, String bio){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.time_result = time_result;
        this.preparation = preparation;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getTime_result() {
        return time_result;
    }

    public String getPreparation() {
        return preparation;
    }

    public String getBio() {
        return bio;
    }
}
