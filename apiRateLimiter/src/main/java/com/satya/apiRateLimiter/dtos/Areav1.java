package com.satya.apiRateLimiter.dtos;

public class Areav1 {

    private String shape;
    private Double area;


    public Areav1(String shape , Double area){
        this.shape=shape;
        this.area=area;
    }

    public String getShape(){
        return this.shape;
    }

    public Double getArea(){
        return this.area;
    }
}
