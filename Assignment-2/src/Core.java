import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;

    // Create objects of other classes
    Admin admin = new Admin("Admin", 30, "9999900000", "admin@gmail.com");
    Visitor visitor = new Visitor();

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
                System.out.println();
                System.out.println("1. Manage Attractions");
                System.out.println("2. Manage Animals");
                System.out.println("3. Schedule Events");
                System.out.println("4. Set Discounts");
                System.out.println("5. Set Special Deal");
                System.out.println("6. View Visitor Stats");
                System.out.println("7. View Feedback");
                System.out.println("8. Exit");
                int adminChoice = scanner.nextInt();
                scanner.nextLine();
                
                if (adminChoice == 1){
                    admin.manageAttractions(); 
                }else if (adminChoice == 2) {
                    admin.manageAnimals();
                }else if (adminChoice == 3) {
                    admin.scheduleEvents();        // Start Coding from here !
                }else if (adminChoice == 4) {
                    admin.setDiscounts();
                }else if (adminChoice == 5) {
                    admin.setSpecialDeals();
                }else if (adminChoice == 6) {
                    admin.viewVisitorStats();
                }else if (adminChoice == 7) {
                    admin.viewFeedback();
                }else if (adminChoice == 8) {
                    System.out.println("Exiting...");
                    break;
                }else {
                    System.out.println("Enter a valid option between 1-8");
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
                    int visitorMenuChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (visitorMenuChoice) {
                        case 1:
                            System.out.println("Explore the Zoo:");
                            System.out.println("1. View Attractions");
                            System.out.println("2. View Animals");
                            System.out.println("3. Exit");
                            int exploreChoice = scanner.nextInt();
                            scanner.nextLine();
                            while (exploreChoice != 3) {
                                if (exploreChoice == 1) {
                                    System.out.println("Attractions in the Zoo:");
                                    System.out.println("1. Jungle Safari");
                                    System.out.println("2. Botanical Garden");
                                    System.out.println("3. Dinosaur Show");
                                    int attractionChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (attractionChoice == 1) {
                                        System.out.println("ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!");
                                    } else {
                                        System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                                    }
                                } else if (exploreChoice == 2) {
                                    System.out.println("Animals in the Zoo:");
                                    System.out.println("1. Lion");
                                    System.out.println("2. Elephant");
                                    int animalChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    if (animalChoice == 1) {
                                        System.out.println("The Lion is a mammal that belongs to the cat family.");
                                    } else {
                                        System.out.println("The Elephant is a mammal that is known for its large size and long trunk.");
                                    }
                                } else {
                                    System.out.println("Invalid choice.");
                                }
                                System.out.println("Explore the Zoo:");
                                System.out.println("1. View Attractions");
                                System.out.println("2. View Animals");
                                System.out.println("3. Exit");
                                exploreChoice = scanner.nextInt();
                                scanner.nextLine();
                            }
                            break;
                        case 2:
                            System.out.println("Buy Membership:");
                            System.out.println("1. Basic Membership (₹20)");
                            System.out.println("2. Premium Membership (₹50)");
                            int membershipChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (membershipChoice == 1) {
                                System.out.println("Apply Discount Code: None");
                                System.out.println("Basic Membership purchased successfully. Your balance is now ₹80.");
                            } else if (membershipChoice == 2) {
                                System.out.println("Apply Discount Code: None");
                                System.out.println("Premium Membership purchased successfully. Your balance is now ₹50.");
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 3:
                            System.out.println("Buy Tickets:");
                            System.out.println("Select an Attraction to Buy a Ticket:");
                            System.out.println("1. Jungle Safari (₹10)");
                            System.out.println("2. Botanical Garden (₹15)");
                            System.out.println("3. Dinosaur Show (₹12)");
                            int ticketChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (ticketChoice == 1) {
                                System.out.println("The ticket for Jungle Safari was purchased successfully. Your balance is now ₹70.");
                            } else if (ticketChoice == 2) {
                                System.out.println("The ticket for Botanical Garden was purchased successfully. Your balance is now ₹85.");
                            } else if (ticketChoice == 3) {
                                System.out.println("The ticket for Dinosaur Show was purchased successfully. Your balance is now ₹88.");
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 4:
                            System.out.println("View Discounts:");
                            System.out.println("1. Minor (10% discount) - MINOR10");
                            System.out.println("2. Senior Citizen (20% discount) - SENIOR20");
                            break;
                        case 5:
                            System.out.println("Special Deals:");
                            System.out.println("1. Buy 2 tickets and get 15% off");
                            System.out.println("2. Buy 3 tickets and get 30% off");
                            break;
                        case 6:
                            System.out.println("Visit Animals:");
                            System.out.println("Select an Animal to Visit:");
                            System.out.println("1. Lion");
                            System.out.println("2. Elephant");
                            int animalVisitChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (animalVisitChoice == 1) {
                                System.out.println("You have visited the Lion.");
                            } else if (animalVisitChoice == 2) {
                                System.out.println("You have visited the Elephant.");
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 7:
                            System.out.println("Visit Attractions:");
                            System.out.println("Select an Attraction to Visit:");
                            System.out.println("1. Jungle Safari");
                            System.out.println("2. Botanical Garden");
                            System.out.println("3. Dinosaur Show");
                            int attractionVisitChoice = scanner.nextInt();
                            scanner.nextLine();
                            if (attractionVisitChoice == 1) {
                                System.out.println("1 Ticket Used.");
                                System.out.println("Thank you for visiting Jungle Safari. Hope you enjoyed the attraction.");
                            } else if (attractionVisitChoice == 2) {
                                System.out.println("1 Ticket Used.");
                                System.out.println("Thank you for visiting Botanical Garden. Hope you enjoyed the attraction.");
                            } else if (attractionVisitChoice == 3) {
                                System.out.println("1 Ticket Used.");
                                System.out.println("Thank you for visiting Dinosaur Show. Hope you enjoyed the attraction.");
                            } else {
                                System.out.println("Invalid choice.");
                            }
                            break;
                        case 8:
                            System.out.println("Leave Feedback:");
                            System.out.println("Enter your feedback (max 200 characters):");
                            String feedbackText = scanner.nextLine();
                            System.out.println("Thank you for your feedback.");
                            break;
                        case 9:
                            System.out.println("Logged out.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } else {
                    System.out.println("Invalid email or password.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } else if (userType == 3) {
            System.out.println("Special Deals:");
            System.out.println("1. Buy 2 tickets and get 15% off");
            System.out.println("2. Buy 3 tickets and get 30% off");
        } else {
            System.out.println("Invalid user type. Please try again.");
            }
        }
    }
}