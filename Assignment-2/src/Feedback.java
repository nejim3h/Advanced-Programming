import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feedback {
    private Visitor visitor;
    private String message;
    private static List<Feedback> feedbackList = new ArrayList<>();

    public Feedback(Visitor visitor, String message) {
        this.visitor = visitor;
        this.message = message;
    }

    public Feedback() {
    }

    public void addFeedback(Visitor visitor) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter feedback message:");
        String message = scanner.nextLine();
        Feedback feedback = new Feedback(visitor, message);
        feedbackList.add(feedback);
        System.out.println("Feedback added successfully.");
    }

    public void viewFeedback() {
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            System.out.println("Feedback list:");
            for (Feedback feedback : feedbackList) {
                System.out.println(feedback.toString());
            }
        }
    }

    @Override
    public String toString() {
        return visitor.getName() + ": " + message;
    }
}
