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
        return "admin123";
    }

    public final String getPassword() {
        return "admin";
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
        // implementation
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
        // implementation
    }

    public void setSpecialDeals() {
        // implementation
    }

    public void viewVisitorStats() {
        // implementation
    }

    public void viewFeedback() {
        // implementation
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