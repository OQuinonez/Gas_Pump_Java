package com.company;

import java.util.*;
import java.io.*;

public class Manager {



    //Manager can view Transactions
    public static void viewTransactions() throws FileNotFoundException {
        File file = new File("/home/basecamp/IdeaProjects/GasPump/src/com/company/transactions.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }

        input.close();
    }

    //Manager can view how many gallons are left in every gas tank
    public static void viewInventory() throws FileNotFoundException {
        File file = new File("/home/basecamp/IdeaProjects/GasPump/src/com/company/inventory.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();
    }

    //Manager can refill the tanks to 5000 if they are low
    public static void refillTanks() throws IOException {
        ArrayList<Converting> inventory = Main.loadInventoryInFile();
        inventory.get(0).gallons = 0.0;
        inventory.get(1).gallons = 0.0;
        inventory.get(2).gallons = 0.0;
        inventory.get(0).amountMoney = 5000.0;
        inventory.get(1).amountMoney = 5000.0;
        inventory.get(2).amountMoney = 5000.0;
        Main.saveInventoryInFile(inventory);
    }

    public static void viewIncome() throws IOException {
        ArrayList<Converting> inventory = Main.loadInventoryInFile();
        double totalIncome = Math.round(inventory.get(0).gallons + inventory.get(1).gallons + inventory.get(2).gallons);
        System.out.println("Store income: $" + totalIncome);

    }
}
