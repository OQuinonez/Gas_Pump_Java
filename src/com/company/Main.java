package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void greetings() {
        System.out.println("Hello!  Welcome to the O Gas Station");
        System.out.println("We have three types of Gas: ");
        System.out.println("87  Regular\n89  Mid-Grade\n93  Premium");
    }

    public static void payType() {
        System.out.println("How would you like to pay? ");
        System.out.println("1.\t Prepay");
        System.out.println("2.\tPay After");
    }

    public static String whatTypeGas(Integer type){
        String gastype = "";
        if (type.equals(87)) {
            gastype = "Regular";
        } else if (type.equals(89)) {
            gastype = "Mid-Grade";
        } else if (type.equals(92)) {
            gastype = "Premium";
        }return gastype;
    }

    public static ArrayList<Converting> loadInventoryInFile() throws IOException {
        BufferedReader br = null;
        FileReader fr = null;

        fr = new FileReader("/home/basecamp/IdeaProjects/GasPump/src/com/company/inventory.txt");
        br = new BufferedReader(fr);

        String Line = "";
        br.readLine().toString().split(", ");
        String[] RegularList = br.readLine().toString().split(", ");
        String[] MidList = br.readLine().toString().split(", ");
        String[] PremiumList = br.readLine().toString().split(", ");


        Converting Regular =  new Converting(RegularList[0], Double.parseDouble(RegularList[1]), Double.parseDouble(RegularList[2]) );
        Converting MidGrade = new Converting(MidList[0], Double.parseDouble(MidList[1]), Double.parseDouble(MidList[2]));
        Converting Premium = new Converting(PremiumList[0], Double.parseDouble(PremiumList[1]), Double.parseDouble(PremiumList[2]));

        return new ArrayList<Converting>() {
            {
                add(Regular);
                add(MidGrade);
                add(Premium);
            }
        };
//        Scanner input = new Scanner(file);
//        input.nextLine();
//        while (input.hasNextLine()) {
//            String type = input.nextLine();
//            System.out.println(type);
//        }
//        input.close();
    }

    public static void saveInventoryInFile(ArrayList<Converting> inventory) throws IOException {
        FileWriter writer = new FileWriter("/home/basecamp/IdeaProjects/GasPump/src/com/company/inventory.txt");
        writer.write(inventory.get(0).typeOfGas + "," + inventory.get(0).amountMoney + "," +  inventory.get(0).gallons );
        writer.write(inventory.get(1).typeOfGas + "," + inventory.get(1).amountMoney + "," + inventory.get(1).gallons);
        writer.write(inventory.get(2).typeOfGas + "," + inventory.get(2).amountMoney + "," + inventory.get(2).gallons);
    }

    public static void updateTransactions(String gastype, double printGallons, double printCost) throws IOException {
        FileWriter writer = new FileWriter("/home/basecamp/IdeaProjects/GasPump/src/com/company/transactions.txt",true);
        writer.write("\n" + gastype + ", " + printGallons + ", " + printCost);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        greetings();
        System.out.println("Which one would you like?   (Please Choose a Number)");
        Integer type = scan.nextInt();
        payType();
        Integer paymentType = scan.nextInt();

        if (paymentType.equals(1)) {
            String gasType = whatTypeGas(type);
            System.out.println("How much would you like to put? ");
            Double money = scan.nextDouble();
            Converting displayGallons = new Converting(gasType, 0.0, money);
            Double totalGals = displayGallons.prePay(money, type);

            System.out.println("Type of Gas Pumped: " + gasType);
            System.out.println("Total Gallons: " + totalGals);
            System.out.println("Total Paid: " + money);
        }
        else if (paymentType.equals(2)){
            String gasType = whatTypeGas(type);
            System.out.println("How many gallons would you like? ");
            Double gallons = scan.nextDouble();
            payType();

//            paying(type, paymentType, gallons);
        }
    }
}
