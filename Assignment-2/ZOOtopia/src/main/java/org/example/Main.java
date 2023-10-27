package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Create objects of other classes
        Admin admin = new Admin("Admin", 30, "9999900000", "admin@gmail.com");
        Visitor visitor = new Visitor();
        Visitor visitor1 = new Visitor("John Doe", 30, "123-456-7890", "john", "johndoe", "123", 500.0, "Premium");
        Visitor.addVisitorToList(visitor1);
        List<Animal> animalsList = new ArrayList<>();
        Animal lion = new Animal("Lion", "Mammals", "Roar");
        Animal elephant = new Animal("Elephant", "Mammals", "Trumpet");
        Animal frog = new Animal("Frog", "Amphibians", "Ribbit");
        Animal salamander = new Animal("Salamander", "Amphibians", "Croak");
        Animal snake = new Animal("Snake", "Reptiles", "Hiss");
        Animal turtle = new Animal("Turtle", "Reptiles", "Squeak");
        Animal.addAnimalToList(lion);
        Animal.addAnimalToList(elephant);
        Animal.addAnimalToList(frog);
        Animal.addAnimalToList(salamander);
        Animal.addAnimalToList(snake);
        Animal.addAnimalToList(turtle);
        Discount d1 = new Discount("MINOR10",10);
        Discount d2 = new Discount("SENIOR10",20);
        Discount.addDiscountToList(d1);
        Discount.addDiscountToList(d2);
        Deal deal1 = new Deal(2,15);
        Deal deal2 = new Deal(3,30);
        Deal.addDealToList(deal1);
        Deal.addDealToList(deal2);


        while (isRunning) {
            System.out.println("======================");
            System.out.println("Welcome To ZOOtopia");
            System.out.println("======================");
            System.out.println();
            System.out.println("1. Enter as admin");
            System.out.println("2. Enter as visitor");
            System.out.println("3. View special deals");
            int userType = scanner.nextInt();
            scanner.nextLine();

            if (userType == 1) {
                // Admin login and functionalities
                System.out.println("Enter Admin Username:");
                String username = scanner.nextLine();
                System.out.println("Enter Admin Password:");
                String password = scanner.nextLine();

                if (admin.login(username,password)) {
                    System.out.println("Logged in as Admin.");
                    int adminChoice = 0;
                    while (isRunning) {
                        System.out.println();
                        System.out.println("1. Manage Attractions");
                        System.out.println("2. Manage Animals");
                        System.out.println("3. Schedule Events");
                        System.out.println("4. Set Discounts");
                        System.out.println("5. Set Special Deal");
                        System.out.println("6. View Visitor Stats");
                        System.out.println("7. View Feedback");
                        System.out.println("8. Exit");
                        adminChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (adminChoice == 1){
                            admin.manageAttractions();
                        }else if (adminChoice == 2) {
                            admin.manageAnimals();
                        }else if (adminChoice == 3) {
                            admin.scheduleEvents();
                        }else if (adminChoice == 4) {
                            admin.setDiscounts();
                        }else if (adminChoice == 5) {
                            admin.setSpecialDeals();
                        }else if (adminChoice == 6) {
                            admin.viewVisitorStats();
                        }else if (adminChoice == 7) {
                            admin.displayFeedback();
                        }else if (adminChoice == 8) {
                            System.out.println("Exiting...");
                            break;
                        }else {
                            System.out.println("Enter a valid option between 1-8");
                        }
                    }
                }
                else {
                    System.out.println("Invalid username or password.");
                }
            } else if (userType == 2) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                int visitorChoice = scanner.nextInt();
                scanner.nextLine();
                if (visitorChoice == 1) {
                    visitor.register();
                } else if (visitorChoice == 2) {
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password = scanner.nextLine();
                    if (visitor.login(email, password)) {
                        while (isRunning) {
                            System.out.println();
                            System.out.println("Visitor Menu:");
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Leave Feedback");
                            System.out.println("9. Log Out");
                            int visitorChoice2 = scanner.nextInt();
                            scanner.nextLine();
                            if (visitorChoice2 == 1){
                                visitor.exploreZoo();
                            }else if (visitorChoice2 == 2) {
                                visitor.buyMembership();
                            }else if (visitorChoice2 == 3) {
                                visitor.buyTicket(visitor);
                            }else if (visitorChoice2 == 4) {
                                visitor.viewDiscount();
                            }else if (visitorChoice2 == 5) {
                                visitor.printSpecialDeals();
                            }else if (visitorChoice2 == 6) {
                                visitor.visitAnimals();
                            }else if (visitorChoice2 == 7) {
                                visitor.visitAttraction();
                            }else if (visitorChoice2 == 8) {
                                visitor.leaveFeedback();
                            }else if (visitorChoice2 == 9) {
                                System.out.println("Exiting...");
                                break;
                            }else {
                                System.out.println("Enter a valid option between 1-8");
                            }
                        }
                    } else {
                        System.out.println("Invalid email or password.");
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            } else if (userType == 3) {
                visitor.printSpecialDeals();
            } else {
                System.out.println("Invalid user type. Please try again.");
            }
        }
    }
}