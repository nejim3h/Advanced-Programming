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
        // implementation
    }

    public void buyTicket() {
        // implementation
    }

    public void applyDiscount() {
        // implementation
    }

    public void visitAnimal() {
        // implementation
    }

    public void visitAttraction() {
        // implementation
    }

    public void visitEvent() {
        // implementation
    }

    public void provideFeedback() {
        // implementation
    }

    @Override
    public void register() {
        Scanner scanner = new Scanner(System.in);

        // Get visitor's name
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        // Get visitor's age
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

        // Get visitor's phone number
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        // Get visitor's email
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Get visitor's username
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

                // Get visitor's password
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Get visitor's wallet balance
        System.out.print("Enter Wallet Balance: ");
        double balance = 0;
        boolean isBalanceValid = false;
        while (!isBalanceValid) {
            try {
                balance = scanner.nextDouble();
                scanner.nextLine();
                if (balance < 0) {
                    throw new IllegalArgumentException("Balance cannot be negative.");
                }
                isBalanceValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid balance.");
                scanner.nextLine();
            }
        }

        // Get visitor's membership type
        String membershipType = "basic";

        // Create a new Visitor object with the user-provided values
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

    public Object getEmail() {
        return null;
    }

    public Object getPassword() {
        return null;
    }
}
