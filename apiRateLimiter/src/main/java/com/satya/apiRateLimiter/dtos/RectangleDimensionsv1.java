package com.satya.apiRateLimiter.dtos;

public class RectangleDimensionsv1 {

    private  Double length;
    private Double breadth;

    public RectangleDimensionsv1(Double length , Double breadth){
        this.breadth=breadth;
        this.length=length;
    }

    public Double getLength(){
        return this.length;
    }

    public Double getBreadth(){
        return this.breadth;
    }
}
