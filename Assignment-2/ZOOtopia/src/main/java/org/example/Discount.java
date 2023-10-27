package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Discount {
    private static int nextID = 1;
    private int id;
    private String code;
    private int percentage;
    private static List<Discount> discountsList = new ArrayList<>();

    public Discount(String code, int percentage) {
        this.id = nextID++;
        this.code = code;
        this.percentage = percentage;
    }

    public Discount() {
    }

    public static void addDiscountToList(Discount d1) {
        discountsList.add(d1);
    }

    public void addDiscount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Discount Code:");
        String code = scanner.nextLine();
        while (isCodeExists(code)) {
            System.out.println("Discount code already exists. Please enter a different code:");
            code = scanner.nextLine();
        }
        System.out.println("Enter Discount Percentage :");
        Integer amount = scanner.nextInt();
        scanner.nextLine();
        Discount newDiscount = new Discount(code, amount);
        discountsList.add(newDiscount);
        System.out.println("New discount added successfully.");
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
            System.out.println("Enter Discount percentage:");
            Integer perc = scanner.nextInt();
            scanner.nextLine();
            discount.code = code;
            discount.percentage = perc;
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

    public double getPercentage() {
        return this.percentage;
    }

    public static List<Discount> getDiscountsList() {
        return discountsList;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.code + " ("+this.percentage + "% )";
    }
}