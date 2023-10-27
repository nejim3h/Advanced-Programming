package org.example;

import java.util.Scanner;

public class Admin extends User {
    private final String username;
    private final String password;

    Scanner scanner = new Scanner(System.in);

    public Admin(String name, int age, String phoneNumber, String email) {
        super(name, age, phoneNumber, email);
        this.username = getUsername();
        this.password = getPassword();
    }

    public final String getUsername() {
        return "admin";
    }

    public final String getPassword() {
        return "admin123";
    }

    public void manageAttractions() {
        Attraction attraction = new Attraction();
        int AttractionsChoice=0;
        while(AttractionsChoice!=5){
            System.out.println("1. Add Attractions");
            System.out.println("2. View Attractions");
            System.out.println("3. Modify Attractions");
            System.out.println("4. Remove Attractions");
            System.out.println("5. Exit");
            AttractionsChoice = scanner.nextInt();
            scanner.nextLine();
            if (AttractionsChoice == 1){
                attraction.addAttraction();
            }else if (AttractionsChoice == 2) {
                attraction.printAllAttraction();
            }else if (AttractionsChoice == 3) {
                attraction.printAllAttraction();
                System.out.println("Enter Attraction ID:");
                Integer attractionIDToModify = scanner.nextInt();
                attraction.modifyAttraction(attractionIDToModify);
            }else if (AttractionsChoice == 4) {
                attraction.printAllAttraction();
                attraction.removeAttraction();
            }else if (AttractionsChoice == 5){
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Invalid choice.");
                break;
            }
        }
    }

    public void scheduleEvents() {
        Attraction attraction = new Attraction();
        int choice=0;
        while(choice!=3){
            System.out.println("1. Schedule Event");
            System.out.println("2. Modify Event");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1){
                attraction.scheduleEvent();
            }else if (choice == 2) {
                attraction.modifyEvent();
            }else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Invalid choice.");
                break;
            }
        }
    }


    public void manageAnimals() {
        Animal animal = new Animal();
        int AnimalsChoice=0;
        while(AnimalsChoice!=4){
            System.out.println("1. Add Animals");
            System.out.println("2. Update Animal Details");
            System.out.println("3. Remove Animals");
            System.out.println("4. Exit");
            AnimalsChoice = scanner.nextInt();
            scanner.nextLine();
            if (AnimalsChoice == 1){
                animal.addAnimal();
            }else if (AnimalsChoice == 2) {
                animal.updateAnimalDetails();
            }else if (AnimalsChoice == 3) {
                animal.removeAnimal();
            }else if (AnimalsChoice == 4){
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Invalid choice.");
                break;
            }
        }
    }

    public void setDiscounts() {
        Discount discount = new Discount();
        int discountChoice=0;
        while(discountChoice!=4){
            System.out.println("Set Discounts:");
            System.out.println("1. Add Discount");
            System.out.println("2. Modify Discount");
            System.out.println("3. Remove Discount");
            System.out.println("4. Exit");
            discountChoice = scanner.nextInt();
            scanner.nextLine();
            if (discountChoice == 1){
                discount.addDiscount();
            }else if (discountChoice == 2) {
                discount.modifyDiscount();
            }else if (discountChoice == 3) {
                discount.removeDiscount();
            }else if (discountChoice == 4){
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Invalid choice.");
                break;
            }
        }
    }

    public void setSpecialDeals() {
        Deal deal = new Deal();
        int dealChoice=0;
        while(dealChoice!=3){
            System.out.println("Set Special Deals:");
            System.out.println("1. Add Special Deal");
            System.out.println("2. Remove Special Deal");
            System.out.println("3. Exit");
            dealChoice = scanner.nextInt();
            scanner.nextLine();
            if (dealChoice == 1){
                deal.addDeal();
            }else if (dealChoice == 2) {
                deal.removeDeal();
            }else if (dealChoice == 3){
                System.out.println("Exiting...");
                break;
            }else {
                System.out.println("Invalid choice.");
                break;
            }
        }
    }

    public void viewVisitorStats() {
        Statistics s = new Statistics();
        s.printStats();
    }

    public void displayFeedback() {
        Feedback feedback = new Feedback();
        feedback.viewFeedback();
    }

    @Override
    public void register() {
        // implementation
    }

    @Override
    public boolean login(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }
}
