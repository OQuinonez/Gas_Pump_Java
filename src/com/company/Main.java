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

    public static String whatTypeGas(Integer type) {
        String gastype = "";
        if (type.equals(87)) {
            gastype = "Regular";
        } else if (type.equals(89)) {
            gastype = "Mid-Grade";
        } else if (type.equals(93)) {
            gastype = "Premium";
        }
        return gastype;
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

        Converting Regular = new Converting(RegularList[0], Double.parseDouble(RegularList[1]), Double.parseDouble(RegularList[2]));
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
        writer.write("Number, Amount-of-Money, Gallons" + "\n");
        writer.write(inventory.get(0).typeOfGas + ", " + inventory.get(0).gallons + ", " + inventory.get(0).amountMoney + "\n");
        writer.write(inventory.get(1).typeOfGas + ", " + inventory.get(1).gallons + ", " + inventory.get(1).amountMoney + "\n");
        writer.write(inventory.get(2).typeOfGas + ", " + inventory.get(2).gallons + ", " + inventory.get(2).amountMoney);
        writer.close();
    }

    public static void updateTransactions(String gastype, double printGallons, double printCost) throws IOException {
        FileWriter writer = new FileWriter("/home/basecamp/IdeaProjects/GasPump/src/com/company/transactions.txt", true);
        writer.write("\n" + gastype + ", " + printGallons + ", " + printCost);
        writer.close();
    }

    public static void updatingInventory(String gasType, Double money, Double gallons) throws IOException {
        ArrayList<Converting> inventory = loadInventoryInFile();
        if (gasType.equals("Regular")) {
            inventory.get(0).gallons += gallons;
            inventory.get(0).amountMoney -= money;
        } else if (gasType.equals("Mid-Grade")) {
            inventory.get(1).gallons += gallons;
            inventory.get(1).amountMoney -= money;
        } else if (gasType.equals("Premium")) {
            inventory.get(2).gallons += gallons;
            inventory.get(2).amountMoney -= money;
        }
        saveInventoryInFile(inventory);
    }

    public static void displayCustomerInfo(String gasType, Double gallons, Double money) {
        System.out.println("Type of Gas Pumped: " + gasType);
        System.out.println("Total Gallons: " + gallons);
        System.out.println("Total Paid: " + money);
    }


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("If you are the manager, please type in your password \nIf you are a customer, press 1.  ");
        String MorC = scan.nextLine();
        if (MorC.equals("Everest1953")) {
            System.out.println("1 - View Gas Tank\n2 - View Refill Gas Tanks\n3 - Store Income\n4 - View Transactions\n5 - Exit");
            String choice = scan.next();
            if (choice.equals("1")) {
                Manager.viewInventory();
            } else if (choice.equals("2")) {
                Manager.refillTanks();
            } else if (choice.equals("3")) {
                Manager.viewIncome();
            } else if (choice.equals("4")) {
                Manager.viewTransactions();
            } else if (choice.equals("5")) {
                System.exit(0);
            }
        }else if (MorC.equals("1")){
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

                    displayCustomerInfo(gasType, totalGals, money);

                    updateTransactions(gasType, totalGals, money);

                    updatingInventory(gasType, totalGals, money);
                } else if (paymentType.equals(2)) {
                    String gasType = whatTypeGas(type);
                    System.out.println("How many gallons would you like? ");
                    Double gallons = scan.nextDouble();
                    Converting displayMoney = new Converting(gasType, gallons, 0.0);
                    Double totalMoney = displayMoney.payAfter(gallons, type);

                    displayCustomerInfo(gasType, gallons, totalMoney);

                    updateTransactions(gasType, gallons, totalMoney);

                    updatingInventory(gasType, gallons, totalMoney);
                }
            }
        }
    }