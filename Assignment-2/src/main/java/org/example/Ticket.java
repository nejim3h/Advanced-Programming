package org.example;

import java.util.*;

public class Ticket {
    private int ticketNo;
    private double price;
    private List<Ticket> purchasedTickets = new ArrayList<>();

    Ticket(int ticketNo, double price) {
        this.ticketNo = ticketNo;
        this.price = price;
    }

    Attraction attraction = new Attraction();
    Visitor visitor = new Visitor();

    public Ticket(Attraction selectedAttraction) {
    }

    public Ticket() {

    }

    public void purchase(List<Attraction> attractionsList, Visitor visitor) {
        Attraction.printAllAttraction();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the attraction you want to purchase a ticket for: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Attraction selectedAttraction = null;
        for (Attraction attraction : attractionsList) {
            if (attraction.getID() == id) {
                selectedAttraction = attraction;
                break;
            }
        }

        if (selectedAttraction == null) {
            System.out.println("Attraction not found.");
            return;
        }

        System.out.println("Selected Attraction: " + selectedAttraction.getName());

        if (selectedAttraction.getCapacity() <= 0) {
            System.out.println("Sorry, no tickets are available for this attraction.");
            return;
        }

        System.out.print("Enter the number of tickets you want to purchase: ");
        int numTickets = scanner.nextInt();
        scanner.nextLine();

        double price = numTickets * selectedAttraction.getPrice();

        if (numTickets <= 0 || numTickets > selectedAttraction.getCapacity()) {
            System.out.println("Invalid number of tickets or not enough capacity.");
        } else if (visitor.getBalance() < price) { // Check the visitor's balance
            System.out.println("Not enough balance");
        } else {
            for (int i = 0; i < numTickets; i++) {
                Ticket ticket = new Ticket(selectedAttraction);
                purchasedTickets.add(ticket);
            }
            selectedAttraction.setCapacity(selectedAttraction.getCapacity() - numTickets);
            visitor.setBalance(visitor.getBalance() - price);
            System.out.println(numTickets + " ticket(s) purchased for " + selectedAttraction.getName() + ".");
        }
    }

    public String calculateMostPopularAttraction() {
        if (purchasedTickets.isEmpty()) {
            return "No tickets have been sold yet.";
        }
        Map<Attraction, Integer> attractionTicketCounts = new HashMap<>();
        for (Ticket ticket : purchasedTickets) {
            Attraction attraction = ticket.getSelectedAttraction();
            attractionTicketCounts.put(attraction, attractionTicketCounts.getOrDefault(attraction, 0) + 1);
        }
        int maxTicketCount = 0;
        Attraction mostPopularAttraction = null;
        for (Map.Entry<Attraction, Integer> entry : attractionTicketCounts.entrySet()) {
            if (entry.getValue() > maxTicketCount) {
                maxTicketCount = entry.getValue();
                mostPopularAttraction = entry.getKey();
            }
        }
        if (mostPopularAttraction != null) {
            return mostPopularAttraction.getName();
        } else {
            return "No data available for the most popular attraction.";
        }
    }

    private Attraction getSelectedAttraction() {
        return attraction;
    }

}
