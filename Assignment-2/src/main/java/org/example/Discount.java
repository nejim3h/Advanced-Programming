package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Discount {
    private static int nextID = 1;
    private int id;
    private String code;
    private String type;
    private double amount;
    private List<Discount> discountsList = new ArrayList<>();

    public Discount(String code, String type, double amount) {
        this.id = nextID++;
        this.code = code;
        this.type = type;
        this.amount = amount;
    }

    public Discount() {
    }

    public void addDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Discount Code:");
        String code = scanner.nextLine();
        while (isCodeExists(code)) {
            System.out.println("Discount code already exists. Please enter a different code:");
            code = scanner.nextLine();
        }
        System.out.println("Enter Discount Type (Percentage or Amount):");
        String type = scanner.nextLine();
        while (!isValidType(type)) {
            System.out.println("Invalid type. Please enter Percentage or Amount:");
            type = scanner.nextLine();
        }
        System.out.println("Enter Discount Amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Discount newDiscount = new Discount(code, type, amount);
        discountsList.add(newDiscount);
        System.out.println("New discount added successfully.");
        scanner.close();
    }

    public void modifyDiscount() {
        printDiscountsList();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Discount ID:");
            int discountID = scanner.nextInt();
            scanner.nextLine();
            Discount discount = getDiscountByID(discountID);
            if (discount == null) {
                System.out.println("Invalid discount ID.");
                return;
            }
            System.out.println("Enter Discount Code:");
            String code = scanner.nextLine();
            while (isCodeExists(code) && !code.equals(discount.getCode())) {
                System.out.println("Discount code already exists. Please enter a different code:");
                code = scanner.nextLine();
            }
            System.out.println("Enter Discount Type (Percentage or Amount):");
            String type = scanner.nextLine();
            while (!isValidType(type)) {
                System.out.println("Invalid type. Please enter Percentage or Amount:");
                type = scanner.nextLine();
            }
            System.out.println("Enter Discount Amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            discount.code = code;
            discount.type = type;
            discount.amount = amount;
            System.out.println("Discount details updated successfully.");
        } finally {
            scanner.close();
        }
    }

    public void removeDiscount() {
        printDiscountsList();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Discount ID:");
            int discountID = scanner.nextInt();
            scanner.nextLine();
            Discount discount = getDiscountByID(discountID);
            if (discount == null) {
                System.out.println("Invalid discount ID.");
                return;
            }
            discountsList.remove(discount);
            System.out.println("Discount removed successfully.");
        } finally {
            scanner.close();
        }
    }

    private boolean isValidType(String type) {
        return type.equals("Percentage") || type.equals("Amount");
    }

    private boolean isCodeExists(String code) {
        for (Discount discount : discountsList) {
            if (discount.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    private Discount getDiscountByID(int discountID) {
        for (Discount discount : discountsList) {
            if (discount.getID() == discountID) {
                return discount;
            }
        }
        return null;
    }

    public void printDiscountsList() {
        System.out.println("List of all discounts:");
        for (Discount discount : discountsList) {
            System.out.println(discount.toString());
        }
    }

    public int getID() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public List<Discount> getDiscountsList() {
        return discountsList;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.code + " (" + this.type + " - " + this.amount + ")";
    }
}