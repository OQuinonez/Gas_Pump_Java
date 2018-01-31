package com.company;
import java.util.Scanner;

public class Converting {
//    public Double price;
//    public Double gallons;
    public Integer typeOfGas;

    public Converting(Integer typeOfGas){
//        this.price = price;
//        this.gallons = gallons;
        this.typeOfGas = typeOfGas;
    }

    public double prePay(Double money, Integer typeOfGas){
        double gallons = 0.0;
        if (typeOfGas.equals(87)) {
            gallons = (money / 2.05);
            return gallons;
        }else if (typeOfGas.equals(89)){
            gallons = (money / 2.13);
            return gallons;
        }else if (typeOfGas.equals(93)){
            gallons = (money / 2.22);
            return gallons;
        }
        return gallons;
    }

    public double payAfter(Double gallons, Integer typeOfGas){
        double money = 0.0;
        if(typeOfGas.equals(87)){
            money = (gallons * 2.05);
            return money;
        }else if (typeOfGas.equals(89)){
            money = (gallons * 2.13);
            return money;
        }else if (typeOfGas.equals(93)){
            money = (gallons * 2.22);
            return money;
        }
        return money;
    }
}
