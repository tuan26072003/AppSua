package com.example.food.Domain;

import java.io.Serializable;

public class FoodDomain  implements Serializable {
    private  String title;
    private String pic;
    private  String description;
    private Double fee;
    private int numberaIncart;

    public FoodDomain(String pep_piza_, String pizza1, String pizaaa, double v) {
    }

    public String getTitle() {
        return title;
    }

    public FoodDomain(String title, String pic, String description, Double fee, int numberaIncart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.fee = fee;
        this.numberaIncart = numberaIncart;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberaIncart() {
        return numberaIncart;
    }

    public void setNumberaIncart(int numberaIncart) {
        this.numberaIncart = numberaIncart;
    }
}
