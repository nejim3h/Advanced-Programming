package org.example;

import java.util.*;

public class Attraction {
    private static int nextID = 1;
    private int ID;
    private String name;
    private String type;
    private double price;
    private int capacity;
    private boolean status;
    private static List<Attraction> attractionsList = new ArrayList<>();
    private List<Ticket> purchasedTickets = new ArrayList<>();
    public Attraction(String name, String type, double price, int capacity, boolean status) {
        this.ID = nextID++;
        this.name = name;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.status = status;
    }

    public Attraction() {
    }

    public void addAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Attraction Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Attraction Description : ");
        String type = scanner.nextLine();
        double price = 0.0;
        int capacity = 0;
        boolean status = true;
        Attraction newAttraction = new Attraction(name, type, price, capacity, status);
        attractionsList.add(newAttraction);
        System.out.println("Attraction added successfully.");
    }

    public void scheduleEvent() {
        Scanner scanner = new Scanner(System.in);
        printAttractionIdAndDescription();
        System.out.print("Enter the Attraction ID to schedule: ");
        int attractionId = scanner.nextInt();
        scanner.nextLine();
        Attraction attractionToModify = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == attractionId) {
                attractionToModify = attraction;
                break;
            }
        }
        if (attractionToModify == null) {
            System.out.println("Attraction not found.");
            return;
        }

        System.out.print("Enter Attraction Price: ");
        String priceString = scanner.nextLine();
        if (!priceString.isEmpty()) {
            try {
                double price = Double.parseDouble(priceString);
                if (price <= 0) {
                    throw new IllegalArgumentException("Price must be greater than 0.");
                }
                attractionToModify.setPrice(price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter Attraction Capacity: ");
        String capacityString = scanner.nextLine();
        if (!capacityString.isEmpty()) {
            try {
                int capacity = Integer.parseInt(capacityString);
                if (capacity <= 0) {
                    throw new IllegalArgumentException("Capacity must be greater than 0.");
                }
                attractionToModify.setCapacity(capacity);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid capacity.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Enter Attraction Status (active/inactive): ");
            String statusString = scanner.nextLine().toLowerCase();
            if (statusString.equals("active")) {
                attractionToModify.setStatus(true);
                break;
            } else if (statusString.equals("inactive")) {
                attractionToModify.setStatus(false);
                break;
            } else {
                System.out.println("Invalid input. Please enter 'active' or 'inactive'.");
            }
        }

        System.out.println("Attraction modified successfully.");
    }

    public void visitEvent() {
        Scanner scanner = new Scanner(System.in);
        printActiveAttractions();
        System.out.print("Enter the Attraction to visit (Enter ID) : ");
        int attractionId = scanner.nextInt();
        scanner.nextLine();
        Attraction attractionToVisit = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == attractionId) {
                attractionToVisit = attraction;
                break;
            }
        }
        if (attractionToVisit == null) {
            System.out.println("Attraction not found.");
            return;
        }
        Ticket ticketToRemove = null;
        for (Ticket ticket : purchasedTickets) {
            if (ticket.getSelectedAttraction().getID() == attractionId) {
                ticketToRemove = ticket;
                break;
            }
        }
        if (ticketToRemove != null) {
            purchasedTickets.remove(ticketToRemove);
            System.out.println("You are visiting " + attractionToVisit.getName());
        } else {
            System.out.println("You do not have a ticket for this attraction.");
        }
    }

    public void visitEventForPremiumUser(){
        Scanner scanner = new Scanner(System.in);
        printActiveAttractions();
        System.out.print("Enter the Attraction to visit (Enter ID) : ");
        int attractionId = scanner.nextInt();
        scanner.nextLine();
        Attraction attractionToVisit = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == attractionId) {
                attractionToVisit = attraction;
                break;
            }
        }
        if (attractionToVisit == null) {
            System.out.println("Attraction not found.");
            return;
        }
        System.out.println("Welcome, Premium user!");
        System.out.println("You are visiting " + attractionToVisit.getName());
    }

    public void modifyEvent() {
        Scanner scanner = new Scanner(System.in);
        printAllAttraction();
        System.out.print("Enter the Attraction ID to modify: ");
        int attractionId = scanner.nextInt();
        scanner.nextLine();
        Attraction attractionToModify = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == attractionId) {
                attractionToModify = attraction;
                break;
            }
        }
        if (attractionToModify == null) {
            System.out.println("Attraction not found.");
            return;
        }
        System.out.print("Enter new Attraction Price (press return/enter to keep current value): ");
        String priceString = scanner.nextLine();
        if (!priceString.isEmpty()) {
            try {
                double price = Double.parseDouble(priceString);
                if (price <= 0) {
                    throw new IllegalArgumentException("Price must be greater than 0.");
                }
                attractionToModify.setPrice(price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter new Attraction Capacity (press return/enter to keep current value): ");
        String capacityString = scanner.nextLine();
        if (!capacityString.isEmpty()) {
            try {
                int capacity = Integer.parseInt(capacityString);
                if (capacity <= 0) {
                    throw new IllegalArgumentException("Capacity must be greater than 0.");
                }
                attractionToModify.setCapacity(capacity);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid capacity.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter new Attraction Status (true/false): ");
        String statusString = scanner.nextLine();
        if (!statusString.isEmpty()) {
            boolean status = Boolean.parseBoolean(statusString);
            attractionToModify.setStatus(status);
        }
        System.out.println("Attraction modified successfully.");
    }


    public void modifyAttraction(int attractionID) {
        Scanner scanner = new Scanner(System.in);
        Attraction attractionToModify = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == attractionID) {
                attractionToModify = attraction;
                break;
            }
        }
        if (attractionToModify == null) {
            System.out.println("Attraction not found.");
            return;
        }
        System.out.print("Enter new Attraction Name (press return/enter to keep current value): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            attractionToModify.setName(name);
        }
        System.out.print("Enter new Attraction Description (press return/enter to keep the current value): ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            attractionToModify.setType(type);
        }
        System.out.println("Attraction name and type modified successfully.");
    }


    public void removeAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Attraction ID: ");
        int attractionID = scanner.nextInt();
        scanner.nextLine();
        Attraction attractionToRemove = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == attractionID) {
                attractionToRemove = attraction;
                break;
            }
        }
        if (attractionToRemove == null) {
            System.out.println("Attraction not found.");
            return;
        }
        attractionsList.remove(attractionToRemove);
        System.out.println("Attraction removed successfully.");
    }

    public static void printAllAttraction() {
        System.out.println("Attractions:");
        for (Attraction attraction : attractionsList) {
            System.out.println(attraction.toString());
        }
    }

    public static void printActiveAttractions(){
        System.out.println("Active Attractions:");
        for (Attraction attraction : attractionsList) {
            if (attraction.getStatus()) {
                System.out.println(attraction.toString());
                }
            }
    }

    public void printAttractionIdAndDescription() {
        System.out.println("Attractions (ID, Name, Description):");
        for (Attraction attraction : attractionsList) {
            System.out.print("ID: " + attraction.getID() + ", Name: " + attraction.getName());
            if (!attraction.getType().isEmpty()) {
                System.out.println(", Description: " + attraction.getType());
            } else {
                System.out.println(", Description: N/A");
            }
        }
    }


    private boolean getStatus() {
        return this.status;
    }

    public static List<Attraction> getAttractionsList() {
        return attractionsList;
    }

    public int getID() {
        return this.ID;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    private void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Type: " + type + ", Capacity: " + capacity + ", Price: " + price + ", Status: "+ status;
    }

    public Object removeAnimal(Animal animal) {
        return null;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public double getPrice() {
        return this.price;
    }
    public void setStatus(boolean x) {
        this.status = x;
    }
}
