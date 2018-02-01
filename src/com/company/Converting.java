package com.company;
import java.util.Scanner;

public class Converting {
    public Double amountMoney;
    public Double gallons;
    public String typeOfGas;

    public Converting(String typeOfGas, Double gallons, Double amountMoney){
        this.amountMoney = amountMoney;
        this.gallons = gallons;
        this.typeOfGas = typeOfGas;
    }

    public double prePay(Double money, Integer typeOfGas){
        double gallons = 0.0;
        if (typeOfGas.equals(87)) {
            gallons = (money / 2.05);
        }else if (typeOfGas.equals(89)){
            gallons = (money / 2.13);
        }else if (typeOfGas.equals(93)){
            gallons = (money / 2.22);
        }
        return Math.round(gallons);
    }

    public double payAfter(Double gallons, Integer typeOfGas){
        double money = 0.0;
        if(typeOfGas.equals(87)){
            money = (gallons * 2.05);
        }else if (typeOfGas.equals(89)){
            money = (gallons * 2.13);
        }else if (typeOfGas.equals(93)){
            money = (gallons * 2.22);
        }
        return Math.round(money);
    }
}
