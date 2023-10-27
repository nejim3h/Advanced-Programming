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
        List<Animal> animalsList = new ArrayList<>();
        animalsList.add(new Animal("Lion", "Mammals", "Roar"));
        animalsList.add(new Animal("Elephant", "Mammals", "Trumpet"));
        animalsList.add(new Animal("Giraffe", "Mammals", "Neck Stretch"));

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
                            admin.scheduleEvents();        //MISSING
                        }else if (adminChoice == 4) {
                            admin.setDiscounts();
                        }else if (adminChoice == 5) {
                            admin.setSpecialDeals();
                        }else if (adminChoice == 6) {
                            admin.viewVisitorStats();      //NOT WORKING
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
                // Visitor login and functionalities
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
                                visitor.exploreZoo();           //INCOMPLETE ADD SELECTING ANIMALS ATTRACTIONS FURTHER
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
                            }else if (visitorChoice2 == 7) {  //MISSING

                            }else if (visitorChoice2 == 8) {    //NOT PRINTING THE nAME
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
//APPLY DEAL TO ATTRACTION PURCHASE
//VISIT ATTRACTION WITH TICKET REDUCING EACH TIME
//VISITOR STATS
//SCHEDULE ANIMAL
//CREATE CONSTRUCTORS
//CREATE README
//DO MAVEN STUFF
