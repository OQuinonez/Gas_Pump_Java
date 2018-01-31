package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void greetings() {
        System.out.println("Hello!  Welcome to the O Gas Station");
        System.out.println("We have three types of Gas: ");
        System.out.println("87  Regular\n89  Mid-Grade\n93  Premium");
    }

    public static void payType(){
        System.out.println("How would you like to pay? ");
        System.out.println("1.\t Prepay");
        System.out.println("2.\tPay After");
    }

    public static void paying(Integer type, Integer payment, Double money){
        if (payment.equals(1)) {
            Converting moneyToGallons = new Converting(type);
            System.out.println(moneyToGallons.prePay(money, type));
        }else if (payment.equals(2)){
            Converting gallonsToMoney = new Converting(type);
            System.out.println(gallonsToMoney.payAfter(money, type));
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/home/basecamp/IdeaProjects/GasPump/src/com/company/inventory.txt");

        Scanner input = new Scanner(file);


        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }


//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        greetings();
//        System.out.println("Which one would you like?   (Please Choose a Number)");
//        Integer type = scan.nextInt();
//        payType();
//        Integer paymentType = scan.nextInt();
//        if (paymentType.equals(1)) {
//            System.out.println("How much would you like to put? ");
//            Double money = scan.nextDouble();
//            paying(type, paymentType, money);
//        }
//        else if (paymentType.equals(2)){
//            System.out.println("How many gallons would you like? ");
//            Double gallons = scan.nextDouble();
//            paying(type, paymentType, gallons);
//        }
//    }
}
