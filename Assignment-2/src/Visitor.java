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

    public Visitor() {
        super("", 0, "", "", "", "");
        this.balance = 0;
        this.membershipType = "";
    }

    public void buyMembership() {
        System.out.println(getBalance());
        System.out.println("Buy Membership :");
        System.out.println("1. Basic Membership (Rs. 20)");
        System.out.println("2. Buy Premium Membership (Rs. 80)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        if ((choice == 1)&&(getMembershipType().equals(""))) {
            if (this.balance >= 20) {
                this.balance -= 20;
                this.membershipType = "Basic";
                System.out.println("Basic Membership bought successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }
        else if ((choice == 2)&&(!(getMembershipType().equals("Premium")))) {
            if (this.balance >= 80) {
                this.balance -= 80;
                this.membershipType = "Premium";
                System.out.println("Premium Membership bought successfully.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid choice / You are already a "+getMembershipType() + "member");  //assumption
        }
    }

    public void buyTicket() {
        // implementation
    }

    public void applyDiscount() {
        // implementation
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
                attraction.printAllAttraction();
            } else if (choice == 2) {
                Animal animal = new Animal();
                animal.printAnimals();
            } else if (choice == 3) {
                System.out.println("Exiting...");
                
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void visitEvent() {
        // implementation
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
        accounts.put(email, password); //ADD email,password to hashmap for login
        // Save the new Visitor object to the database
        try {
            // implementation to save the new Visitor object to the database
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
    private double getBalance() {
        return this.balance;
    }
}
