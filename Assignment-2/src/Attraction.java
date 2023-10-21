import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Attraction {
    private static int nextID = 1;
    private int ID;
    private String name;
    private String type;
    private double price;
    private int capacity;
    private List<Attraction> attractionsList = new ArrayList<>();

    public Attraction(String name, String type, double price, int capacity) {
        this.ID = nextID++;
        this.name = name;
        this.type = type;
        this.price = price;
        this.capacity = capacity;
    }

    public Attraction() {
    }

    public void addAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Attraction Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Attraction Type: ");
        String type = scanner.nextLine();
        double price = 0;
        boolean isPriceValid = false;
        while (!isPriceValid) {
            try {
                System.out.print("Enter Attraction Price: ");
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price <= 0) {
                    throw new IllegalArgumentException("Price must be greater than 0.");
                }
                isPriceValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid price.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        int capacity = 0;
        boolean isCapacityValid = false;
        while (!isCapacityValid) {
            try {
                System.out.print("Enter Attraction Capacity: ");
                capacity = scanner.nextInt();
                scanner.nextLine();
                if (capacity <= 0) {
                    throw new IllegalArgumentException("Capacity must be greater than 0.");
                }
                isCapacityValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid capacity.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        Attraction newAttraction = new Attraction(name, type, price, capacity);
        attractionsList.add(newAttraction);
        System.out.println("Attraction added successfully.");
    }

    public void modifyAttraction(int attractionID) {
        Scanner scanner = new Scanner(System.in);
        // find the attraction with the given ID
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
        // prompt the user to enter the new values
        System.out.print("Enter new Attraction Name (press return/enter to keep current value): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            attractionToModify.setName(name);
        }

        System.out.print("Enter new Attraction Type (press return/enter to keep current value): ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            attractionToModify.setType(type);
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

        System.out.println("Attraction modified successfully.");
    }

    public void removeAttraction() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Attraction ID: ");
        int attractionID = scanner.nextInt();
        scanner.nextLine();
        // find the attraction with the given ID
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

    public void printAllAttraction() {
        System.out.println("Attractions:");
        for (Attraction attraction : attractionsList) {
            System.out.println(attraction.toString());
        }
    }

    public int getID() {
        return this.ID;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Type: " + type + ", Capacity: " + capacity + ", Price: " + price;
    }

    public Object removeAnimal(Animal animal) {
        return null;
    }
}