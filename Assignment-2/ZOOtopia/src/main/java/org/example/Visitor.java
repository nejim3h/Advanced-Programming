package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Visitor extends User {
    private double balance;
    private String membershipType;
    private static Map<String, String> accounts = new HashMap<>();

    public Visitor(String name, int age, String phone, String email, String username, String password, double balance, String membershipType) {
        super(name, age, phone, email, username, password);
        this.balance = balance;
        this.membershipType = membershipType;
    }

    private Discount appliedDiscount;

    public Visitor() {
    }

    public void buyMembership() {
        System.out.println(getBalance());
        System.out.println("Buy Membership :");
        System.out.println("1. Basic Membership (Rs. 20)");
        System.out.println("2. Buy Premium Membership (Rs. 80)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        double membershipPrice = 0;
        String membershipTypeToBuy = "";

        if (choice == 1 && getMembershipType().isEmpty()) {
            membershipPrice = 20;
            membershipTypeToBuy = "Basic";
        } else if (choice == 2 && !getMembershipType().equals("Premium")) {
            membershipPrice = 80;
            membershipTypeToBuy = "Premium";
        } else {
            System.out.println("Invalid choice / You are already a " + getMembershipType() + " member");
            return;
        }

        System.out.println("Do you have a discount coupon? (Yes/No)");
        String hasCoupon = scanner.nextLine();

        if (hasCoupon.equalsIgnoreCase("Yes")) {
            System.out.println("Enter the discount code:");
            String discountCode = scanner.nextLine();
            for (Discount discount : Discount.getDiscountsList()) {
                if (discount.getCode().equals(discountCode)) {
                    appliedDiscount = discount;
                    break;
                }
            }

            if (appliedDiscount != null) {
                double discountAmount = (membershipPrice * appliedDiscount.getPercentage()) / 100;
                double finalPrice = membershipPrice - discountAmount;

                if (finalPrice <= getBalance()) {
                    this.balance -= finalPrice;
                    this.membershipType = membershipTypeToBuy;
                    System.out.println(membershipTypeToBuy + " Membership bought successfully with a " +
                            appliedDiscount.getPercentage() + "% discount.");
                } else {
                    System.out.println("Insufficient balance after applying the discount.");
                }
            } else {
                System.out.println("Invalid discount code or the discount does not apply to the selected membership.");
            }
        } else {
            if (this.balance >= membershipPrice) {
                this.balance -= membershipPrice;
                this.membershipType = membershipTypeToBuy;
                System.out.println(membershipTypeToBuy + " Membership bought successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }
    }


    public int countTotalVisitors() {
        int totalVisitors = 0;
        for (String email : accounts.keySet()) {
            String password = accounts.get(email);
            Visitor visitor = new Visitor();
            if (visitor.login(email, password) && !visitor.getMembershipType().isEmpty()) {
                totalVisitors++;
            }
        }
        return totalVisitors;
    }

    public double countTotalBalance() {
        double totalBalance = 0;
        for (String email : accounts.keySet()) {
            String password = accounts.get(email);
            Visitor visitor = new Visitor();
            if (visitor.login(email, password)) {
                totalBalance += visitor.getBalance();
            }
        }
        return totalBalance;
    }



    public void buyTicket(Visitor v) {
        Ticket ticket = new Ticket();
        ticket.purchase(Attraction.getAttractionsList(),v);
    }

    public void printSpecialDeals() {
        Deal deal = new Deal();
        deal.printDeals();
    }

    public void viewDiscount() {
        Discount discount = new Discount();
        discount.printDiscountsList();
    }

    public void exploreZoo() {
        int choice = 0;
        while(choice!=3){
            System.out.println("1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                Attraction attraction = new Attraction();
                attraction.printActiveAttractions();
            } else if (choice == 2) {
                Animal animal = new Animal();
                animal.printAnimalNamesWithType();
            } else if (choice == 3) {
                System.out.println("Exiting...");

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void visitAttraction() {
        Attraction a = new Attraction();
        Scanner scanner = new Scanner(System.in);
        if(getMembershipType() != "Premium") {
            a.visitEvent();
        }else{
            a.visitEventForPremiumUser();
        }
    }

    public void visitAnimals() {
        if (getMembershipType() != "") {
            Animal.visitAnimal();
        } else {
            System.out.println("Purchase a membership to visit Animals");
        }
    }


    public void leaveFeedback() {
        Feedback feedback = new Feedback(this, "");
        feedback.addFeedback(this);
    }

    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = 0;
        boolean isAgeValid = false;
        while (!isAgeValid) {
            try {
                age = scanner.nextInt();
                scanner.nextLine();
                if (age <= 0) {
                    throw new IllegalArgumentException("Age must be greater than 0.");
                }
                isAgeValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid age.");
                scanner.nextLine();
            }
        }
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        if (accounts.containsKey(email)) {
            System.out.println("Account with this email already exists. Please use a different email.");
            return;
        }
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Wallet Balance: ");
        double balance = 0;
        boolean isBalanceValid = false;
        while (!isBalanceValid) {
            try {
                balance = scanner.nextDouble();
                scanner.nextLine();
                setBalance(balance);
                if (balance < 0) {
                    throw new IllegalArgumentException("Balance cannot be negative.");
                }
                isBalanceValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid balance.");
                scanner.nextLine();
            }
        }
        String membershipType = "";
        Visitor newVisitor = new Visitor(name, age, phone, email, username, password, balance, membershipType);
        accounts.put(email, password);
        try {
            System.out.println("Registration successful.");
        } catch (Exception e) {
            System.out.println("Registration failed. Please try again later.");
        }
    }


    @Override
    public boolean login(String enteredUsername, String enteredPassword) {
        if (accounts.containsKey(enteredUsername) && accounts.get(enteredUsername).equals(enteredPassword)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Login failed. Please try again.");
            return false;
        }
    }

    public static void addVisitorToList(Visitor visitor) {
        String x = (String) visitor.getEmail();
        String y = (String) visitor.getPassword();
        accounts.put(x,y);
    }

    public void setBalance(double price){
        this.balance = price;
    }

    public Object getEmail() {
        return null;
    }

    public Object getPassword() {
        return null;
    }

    public String getName() {
        return this.name;
    }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
    public String getMembershipType() {
        return this.membershipType;
    }
    public double getBalance() {
        return this.balance;
    }
}

