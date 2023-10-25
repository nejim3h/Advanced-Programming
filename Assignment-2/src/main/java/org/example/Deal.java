package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deal {
    private static int nextID = 1;
    private int id;
    private int ticketCount;
    private double discountPercentage;
    private static List<Deal> dealsList = new ArrayList<>(); // Make it static

    public Deal(int ticketCount, double discountPercentage) {
        this.id = nextID++;
        this.ticketCount = ticketCount;
        this.discountPercentage = discountPercentage;
    }

    public Deal() {
    }

    public void addDeal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of tickets applicable for deal: ");
        int ticket = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter discount percentage: ");
        double percentage = scanner.nextDouble();
        scanner.nextLine();
        Deal newDeal = new Deal(ticket, percentage);
        dealsList.add(newDeal);
        System.out.println("New special deal added successfully.\n");
    }

    public void removeDeal() {
        printDeals();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the deal to remove: ");
        int dealID = scanner.nextInt();
        Deal dealToRemove = null;
        for (Deal deal : dealsList) {
            if (deal.getID() == dealID) {
                dealToRemove = deal;
                break;
            }
        }
        if (dealToRemove != null) {
            dealsList.remove(dealToRemove);
            System.out.println("Deal removed successfully.");
        } else {
            System.out.println("Invalid deal ID.");
        }
    }

    public void printDeals() {
        if (dealsList.isEmpty()) {
            System.out.println("No special deals available.");
        } else {
            System.out.println("List of all deals:");
            for (Deal deal : dealsList) {
                System.out.println(deal); // Using the toString() method
            }
        }
    }

    public int getID() {
        return this.id;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Buy %d tickets to avail Discount Percentage of : %.2f%%", this.id, this.ticketCount, this.discountPercentage);
    }

    public List<Deal> getDealsList() {
        return dealsList;
    }
}

