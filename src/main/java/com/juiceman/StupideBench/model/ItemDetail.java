package com.juiceman.StupideBench.model;

public class ItemDetail {

    public  double weight;
    public  String weight_units;
    public  double model_num;
    public  String manufacturer;
    public  String color;

    public ItemDetail(double weight, String weight_units, double model_num, String manufacturer, String color){

        this.weight = weight;
        this.weight_units = weight_units;
        this.model_num = model_num;
        this.manufacturer = manufacturer;
        this.color = color;

    }

    @Override
    public String toString(){
        return this.manufacturer+" "+this.color;
    }
}
