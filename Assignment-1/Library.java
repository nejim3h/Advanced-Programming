package org.example;

import java.util.*;

public class Library {
    private static Member member;
    private ArrayList<Member> members;

    public static void main(String[] args) {
        System.out.println("Library Portal Initialized…");
        System.out.println("\n========================================================");
        System.out.println("                Library Portal Initialized…             ");
        System.out.println("               Welcome to the Library Portal             ");
        System.out.println("========================================================\n");

        Scanner scan = new Scanner(System.in);
        int response;
        String mem_name;
        long Ph_No;
        long T1 = 0; long T2 = 0; int fees = 0;
        Librarian librarian = new Librarian();

        while (true) {
            System.out.println(" 1) Enter as a librarian");
            System.out.println(" 2) Enter as a member");
            System.out.println(" 3) Exit");
            try {
                response = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scan.next(); 
                continue;
            }
            if (response == 1) {
                modeSelection:
                while (true) {
                    System.out.println("\nChoose your task by selecting the index:");
                    System.out.println(" 1. Add Book:");
                    System.out.println(" 2. Remove Book");
                    System.out.println(" 3. Register Member");
                    System.out.println(" 4. Remove Member");
                    System.out.println(" 5. View all members along with their books and fines to be paid");
                    System.out.println(" 6. View all books");
                    System.out.println(" 7. Back");
                    try {
                        response = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please try again.");
                        scan.next(); 
                        continue;
                    }

                    if (response == 1) {
                        librarian.addBook();
                    } else if (response == 2) {
                        librarian.removeBook();
                    } else if (response == 3) {
                        librarian.addMember();
                    }else if (response ==4){
                        librarian.removeMember();
                    }else if (response == 5) {
                        librarian.displayMembersWithBooksAndFines();
                    }else if(response==6) {
                        librarian.listBooks();
                    }else if (response == 7) {
                        break;
                    }
                    else{
                        System.out.println("Enter a valid option!");
                    }

                }

            } else if (response == 2) {
                modeSelection:
                while (true) {
                    System.out.println("\nLogin to View Options");
                    System.out.println("Press 'E' to go BACK or any other key to login.");
                    System.out.print("Your choice: ");
                    String choice = scan.next();

                    if (choice.equalsIgnoreCase("E")) {
                        System.out.println();
                        break; 
                    }

                    System.out.print("Enter your Name: ");
                    mem_name = scan.next();
                    scan.nextLine(); 

                    if (!isAlpha(mem_name)) {
                        System.out.println("Invalid name. Please enter alphabetic characters only.");
                        continue;
                    }

                    System.out.print("Enter your Phone Number: ");

                    try {
                        Ph_No = scan.nextLong();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid phone number. Please enter a valid number.");
                        scan.nextLine(); 
                        continue; 
                    }

                    if (Ph_No <= 1000000000 || Ph_No >= 9999999999L) {
                        System.out.println("Invalid phone number format. Please enter a 10-digit number.");
                        continue; 
                    }

                    if((librarian.member_name.contains(mem_name)) && (librarian.member_ph.contains(Ph_No))) {
                        int ind = librarian.member_name.indexOf(mem_name);
                        System.out.println("==============================");
                        System.out.println("Welcome " + mem_name + "!\nYour Member ID is : " + librarian.member_id.get(ind));
                        System.out.println("==============================\n");
                        while (true) {
                            System.out.println("1) List Available Books");
                            System.out.println("2) List My Books");
                            System.out.println("3) Issue book");
                            System.out.println("4) Return book");
                            System.out.println("5) Pay Fine");
                            System.out.println("6) Back");
                            try {
                                response = scan.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please try again.");
                                scan.next(); 
                                continue;
                            }
                            if (response == 1) {
                                librarian.listBooks();
                            } else if (response == 2) {
                                librarian.printIssuedBooksByMember(librarian.member_id.get(ind));
                            } else if (response == 3) {
                                if (fees == 0) {
                                    librarian.listBooks();
                                    librarian.issueBook(librarian.member_id.get(ind));
                                    long timeStart = System.currentTimeMillis();
                                    T1 = timeStart / 1000;
                                } else {
                                    System.out.println("Kindly pay the fine to proceed!");
                                }
                            }

                            else if (response == 4) {
                                int fine = 0; 

                                System.out.println("List of your borrowed books:");
                                librarian.printIssuedBooksByMember(librarian.member_id.get(ind));

                                librarian.returnBook(librarian.member_id.get(ind));
                                System.out.println("Book returned successfully.");
                                if (librarian.presence(librarian.member_id.get((ind)))) {
                                    long timeEnd = System.currentTimeMillis();
                                    T2 = timeEnd / 1000;
                                    int timeDifference = (int) Math.abs((T2 - T1));

                                    if (timeDifference >= 10) {
                                        fine = 3 * (timeDifference - 10);
                                    } else {
                                        fine = 0;
                                    }
                                }

                                int index_ = librarian.member_ph.indexOf(Ph_No);

                                if (index_ >= 0) {
                                    if (index_ >= librarian.memberFines.size()) {
                                        while (index_ >= librarian.memberFines.size()) {
                                            librarian.memberFines.add(0); 
                                        }
                                    }
                                    librarian.memberFines.set(index_, fine);
                                    fees = librarian.memberFines.get(index_);

                                    if (fees > 0) {
                                        System.out.println("You have a fine of Rs." + fees);
                                        System.out.println("Please pay the fine to return the book.");
                                    }
                                } else {
                                    System.out.println("Ph_No " + Ph_No + " not found in member_ph.");
                                }
                            }
                            
                            else if (response == 5) {
                                if (fees == 0) {
                                    System.out.println("You don't have any due fine!");
                                } else {
                                    System.out.println("You had a total fine of Rs. " + fees + ". It has been paid successfully!");

                                    int index_ = librarian.member_ph.indexOf(Ph_No);

                                    if (index_ >= 0) {
                                        librarian.memberFines.set(index_, 0);
                                        fees = 0;
                                    } else {
                                        System.out.println("Ph_No " + Ph_No + " not found in member_ph.");
                                    }
                                }

                        } else if (response == 6) {
                                    break;
                                } else {
                                    System.out.println("Enter a valid option!");
                                }
                            }

                        } else {
                            System.out.println("Member with Name: " + mem_name + " and Phone No: " + Ph_No + " doesn't exist.");
                            System.out.println("Complete Registration to login\n");
                            break;
                        }

                }
            } else if (response == 3) {
                System.out.println("==============================");
                System.out.println("    ThankYou for visiting!    ");
                System.out.println("==============================");
                break;
            }
            else{
                System.out.println("Enter a valid option!");
            }
        }
    }

    public static void setMember(Member member) {
        Library.member = member;
    }

    public static int FEES(long T1, long T2){
        int fees;
        if (Math.abs(T1-T2)>=10) {
            fees = 3 * Math.abs(((int) (Math.abs(T1 - T2)) - 10));
        }
        else{
            fees = 0;
        }
        return fees;
    }
    public static boolean isAlpha(String str) {
        return str != null && str.replaceAll(" ", "").chars().allMatch(Character::isLetter);
    }


    static class Librarian {

        private ArrayList<Member> members = new ArrayList<Member>();
        private ArrayList<Book> books = new ArrayList<Book>();
        private ArrayList<String> member_name = new ArrayList<String>();
        private ArrayList<Long> member_ph = new ArrayList<Long>();
        private ArrayList<Integer> member_id = new ArrayList<>();
        private ArrayList<Book> issuedBooks = new ArrayList<>();
        private ArrayList<Book> returnedBooks = new ArrayList<>();
        private ArrayList<Integer> memberFines = new ArrayList<>();
        private HashMap<Integer, ArrayList<Book>> borrowedBooksByMember = new HashMap<>();

        public void addBook() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter book details:");

            int bookID;
            while (true) {
                try {
                    System.out.print("Assign Book ID (Integer Number): ");
                    bookID = scan.nextInt();
                    if (bookID <= 0) {
                        System.out.println("Please enter a positive integer for Book ID.");
                        continue;
                    }
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Book ID.");
                    scan.next();
                }
            }
            for (Book existingBook : books) {
                if (existingBook.getBookID() == bookID) {
                    System.out.println("A book with the same Book ID already exists.");
                    return;
                }
            }

            scan.nextLine();

            System.out.print("Title: ");
            String title = scan.nextLine(); 

            System.out.print("Author: ");
            String author = scan.nextLine();
            if (!isAlpha(author)){
                System.out.println("Enter a valid name");
                System.out.print("Author: ");
                author = scan.nextLine();
            }

            int totalCopies;
            while (true) {
                try {
                    System.out.print("Total Copies: ");
                    totalCopies = scan.nextInt();
                    if (totalCopies <= 0) {
                        System.out.println("Please enter a positive integer for Total Copies.");
                        continue;
                    }
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Total Copies.");
                    scan.next(); 
                }
            }
            Book newBook = new Book(bookID, title, author, totalCopies, totalCopies);
            books.add(newBook);
            System.out.println("Book added successfully!");
        }

        public void removeBook() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Book ID to remove:");

            int bookIDToRemove;
            try {
                bookIDToRemove = scan.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for Book ID.");
                return;
            }

            Book bookToRemove = null;
            for (Book book : books) {
                if (book.getBookID() == bookIDToRemove) {
                    bookToRemove = book;
                    break;
                }
            }
            if (bookToRemove != null) {
                books.remove(bookToRemove);
                System.out.println("Book removed successfully!");
            } else {
                System.out.println("Book not found with the provided ID.");
            }
        }

        public void listBooks() {
            if (books.isEmpty()){
                System.out.println("No books are available!");
            }
            else{
                System.out.println("List of available books:");
                for (Book book : books) {
                    System.out.println("==============================");
                    System.out.println("Book ID: " + book.getBookID());
                    System.out.println("Title: " + book.getTitle());
                    System.out.println("Author: " + book.getAuthor());
                    System.out.println("Available Copies: " + book.getAvailableCopies());
                    System.out.println("==============================");
                }
            }
        }
        
        public void addMember() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Details:");

            try {
                System.out.print("Name: ");
                String name = scan.nextLine(); 

                if (!name.matches("^[a-zA-Z\\s]+$")) {
                    throw new IllegalArgumentException("Enter a valid name");
                }

                int age;
                while (true) {
                    System.out.print("Age: ");
                    if (scan.hasNextInt()) {
                        age = scan.nextInt();
                        if (age > 0) {
                            break; 
                        } else {
                            System.out.println("Age should be a positive number.");
                        }
                    } else {
                        System.out.println("Age should be a numeric value.");
                        scan.next(); 
                    }
                }

                long phoneNumber;
                while (true) {
                    System.out.print("Phone Number: ");
                    if (scan.hasNextLong()) {
                        phoneNumber = scan.nextLong();
                        if (phoneNumber > 1000000000 && phoneNumber < 9999999999L) {
                            break; 
                        } else {
                            System.out.println("Enter a 10 digit phone number.");
                        }
                    } else {
                        System.out.println("Phone number should be a numeric value.");
                        scan.next(); 
                    }
                }

                Member newMember = new Member(name, age, phoneNumber);
                members.add(newMember);
                System.out.println("Member Successfully Registered with Member ID: " + newMember.getMemberID());
                member_id.add(newMember.getMemberID());
                member_name.add(name);
                member_ph.add(phoneNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        public void removeMember() {
            Scanner scan = new Scanner(System.in);

            int memberIDToRemove;

            while (true) {
                System.out.print("Enter the Member ID to remove: ");
                if (scan.hasNextInt()) {
                    memberIDToRemove = scan.nextInt();
                    if (memberIDToRemove > 0) {
                        break; 
                    }
                }

                System.out.println("Invalid input. Please enter a valid positive Member ID.");
                scan.nextLine(); 
            }

            Member memberToRemove = null;
            for (Member member : members) {
                if (member.getMemberID() == memberIDToRemove) {
                    memberToRemove = member;
                    break;
                }
            }

            if (memberToRemove != null) {
                Member.markMemberIDAvailable(memberToRemove.getMemberID());
                members.remove(memberToRemove);
                System.out.println("Member removed successfully!");
            } else {
                System.out.println("Member not found with the provided ID.");
            }
        }

        public void issueBook(int memberID) {
            if (!borrowedBooksByMember.containsKey(memberID)) {
                borrowedBooksByMember.put(memberID, new ArrayList<>());
            }
            if (borrowedBooksByMember.get(memberID).size() >= 2) {
                System.out.println("Maximum limit of 2 books reached for this member.");
                return;
            }
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the Book ID to issue: ");

            int bookIDToIssue;
            while (true) {
                try {
                    bookIDToIssue = scan.nextInt();
                    break; // Exit the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Book ID.");
                    scan.next(); // Clear the invalid input
                }
            }
            for (Book book : books) {
                if (book.getBookID() == bookIDToIssue) {
                    if (book.getAvailableCopies() > 1) {
                        book.decrementAvailableCopies();
                    } else {
                        books.remove(book);
                    }

                    borrowedBooksByMember.get(memberID).add(book);
                    System.out.println("Book issued successfully!");
                    return;
                }
            }
            System.out.println("Book not found or not available.");
        }


        public void returnBook(int memberID) {
            if (!borrowedBooksByMember.containsKey(memberID)) {
                System.out.println("Member has not borrowed any books.");
                return;
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter the Book ID to return: ");

            int bookIDToReturn;
            while (true) {
                try {
                    bookIDToReturn = scan.nextInt();
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Book ID.");
                    scan.next(); 
                }
            }
            for (Book book : borrowedBooksByMember.get(memberID)) {
                if (book.getBookID() == bookIDToReturn) {
                    book.incrementAvailableCopies();
                    if (shouldAddBookBack(book)) {
                        books.add(book);
                    }
                    borrowedBooksByMember.get(memberID).remove(book);
                    System.out.println("Book returned successfully!");
                    return;
                }
            }
            System.out.println("Book not found in the member's borrowed books.");
        }

        private boolean shouldAddBookBack(Book returnedBook) {
            for (Book book : books) {
                if (book.getBookID() == returnedBook.getBookID()) {
                    return false; 
                }
            }
            returnedBook.setAvailableCopies(1);
            return true; 
        }

        public void displayMembersWithBooksAndFines() {
            if (members.isEmpty()) {
                System.out.println("No members found.");
            } else {
                System.out.println("Member Fines:");
                for (int i = 0; i < members.size(); i++) {
                    Member member = members.get(i);
                    Integer fine = i < memberFines.size() ? memberFines.get(i) : null;

                    System.out.println("Member ID: " + (member.getMemberID()));
                    System.out.println("Member Name: " + (member.getName()));
                    System.out.println("Member Phone Number: " + (member.getPhoneNumber()));

                    System.out.println("Books Borrowed:");
                    List<Book> borrowedBooks = borrowedBooksByMember.get(member.getMemberID());
                    if (borrowedBooks != null) {
                        for (Book book : borrowedBooks) {
                            int bookID = book.getBookID();
                            System.out.println("  Book ID: " + (bookID != -1 ? bookID : "None"));
                            System.out.println("  Title: " + (book.getTitle() != null ? book.getTitle() : "None"));
                        }
                    } else {
                        System.out.println("  None"); 
                    }

                    System.out.println("Fine to be Paid: Rs." + (fine != null ? fine : "0"));
                    System.out.println("==============================");
                }
            }
        }

        public void printIssuedBooksByMember(int memberID) {
            if (!borrowedBooksByMember.containsKey(memberID)) {
                System.out.println("No books borrowed by this member.");
                return;
            }

            ArrayList<Book> borrowedBooks = borrowedBooksByMember.get(memberID);

            if (borrowedBooks.isEmpty()) {
                System.out.println("No books borrowed by this member.");
                return;
            }

            System.out.println("Issued Books for Member ID: " + memberID);
            System.out.println("==============================");

            for (Book book : borrowedBooks) {
                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("==============================");
            }
        }
        public boolean presence(int memberID){
            return (borrowedBooksByMember.containsKey(memberID));
        }
    }

    static class Member {
        private String name;
        private int age;
        private long phoneNumber;
        private int memberID;
        private int fine;

        private static int nextMemberID = 1; 

        private ArrayList<Book> borrowed_books = new ArrayList<Book>();

        private static Set<Integer> availableMemberIDs = new HashSet<>();

        public Member(String name, int age, long phoneNumber) {
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.fine = 0;

            if (availableMemberIDs.isEmpty()) {
                memberID = nextMemberID++;
            } else {
                memberID = availableMemberIDs.iterator().next();
                availableMemberIDs.remove(memberID);
            }
        }

        public void borrowBook(Book book) {
            borrowed_books.add(book);
        }

        public void returnBook(Book book) {
            borrowed_books.remove(book);
        }

        public void payFine() {
            fine = 0;
        }

        public static void markMemberIDAvailable(int memberID) {
            availableMemberIDs.add(memberID);
        }
        public int getMemberID(){
            return memberID;
        }
        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public long getPhoneNumber(){
            return phoneNumber;
        }
        public int getFine(){
            return fine;
        }
    }

    static class Book {
        private int bookID;
        private String title;
        private String author;
        private int totalCopies;
        private int availableCopies;

        public Book(int bookID, String title, String author, int totalCopies, int availableCopies) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.totalCopies = totalCopies;
            this.availableCopies = availableCopies;
        }

        public int getBookID() {
            return bookID;
        }
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public int incrementedAvailableCopies() {
            return availableCopies++;
        }

        public int decrementAvailableCopies() {
            return availableCopies--;
        }
        public int incrementAvailableCopies(){
            return availableCopies++;
        }

        public int getAvailableCopies() {
            return availableCopies;
        }
        public void setAvailableCopies(int availableCopies) {
            this.availableCopies = availableCopies;
        }
    }
}
