package org.example;

public class Statistics {
    private int totalVisitors;
    private double totalRevenue;
    private String mostPopularAttraction;

    public Statistics(int totalVisitors, double totalRevenue, String mostPopularAttraction) {
        this.totalVisitors = totalVisitors;
        this.totalRevenue = totalRevenue;
        this.mostPopularAttraction = mostPopularAttraction;
    }

    public Statistics() {

    }

    public int getTotalVisitors() {
        return totalVisitors;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public String getMostPopularAttraction() {
        return mostPopularAttraction;
    }

    public void setTotalVisitors(int totalVisitors) {
        this.totalVisitors = totalVisitors;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void setMostPopularAttraction(String mostPopularAttraction) {
        this.mostPopularAttraction = mostPopularAttraction;
    }


    public void printStats() {           //NOT WORKING
        Visitor v = new Visitor();
        Ticket t = new Ticket();
        int totalvisitor = v.countTotalVisitors();
        double totalmoney = v.countTotalBalance();
        String attraction = t.calculateMostPopularAttraction();
        System.out.println("Visitor Statistics:" + "\n");
        System.out.println("- Total Visitors: " + totalvisitor + "\n");
        System.out.println("- Total Revenue: Rs." + totalmoney + "\n");
        System.out.println("- Most Popular Attraction: " + attraction);
    }
}
