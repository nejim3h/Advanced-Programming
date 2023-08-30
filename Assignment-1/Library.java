package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        System.out.println("Library Portal Initialized…");
        System.out.println("\n========================================================");
        System.out.println("                Library Portal Initialized…             ");
        System.out.println("               Welcome to the Library Portal             ");
        System.out.println("========================================================\n");

        Scanner scan = new Scanner(System.in);
        int response;
        String mem_name;
        int Ph_No;

        Librarian librarian = new Librarian(); // Create a librarian object

        while (true) {
            System.out.println(" 1) Enter as a librarian");
            System.out.println(" 2) Enter as a member");
            System.out.println(" 3) Exit");
            response = scan.nextInt();
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
                    response = scan.nextInt();

                    if (response == 1) {
                        librarian.addBook();
                    } else if (response == 2) {
                        librarian.removeBook();
                    }else if (response == 3){
                        librarian.addMember();
                    }else if(response==6) {
                        librarian.listBooks();
                    }else if (response == 7) {
                        break;
                    }

                }

            } else if (response == 2) {
                modeSelection:
                while (true) {
                    System.out.println("\nLogin to View Options");
                    System.out.print("Enter your Name: ");
                    mem_name = scan.next();
                    System.out.println();
                    System.out.print("Enter your Phone Number: ");
                    Ph_No = scan.nextInt();
                    System.out.println();
                }
            } else {
                System.out.println("==============================");
                System.out.println("    ThankYou for visiting!    ");
                System.out.println("==============================");
                break;
            }
        }
    }

    static class Librarian {
        private ArrayList<Member> members = new ArrayList<Member>();
        private ArrayList<Book> books = new ArrayList<Book>();

        public void addBook() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter book details:");
            System.out.print("Book ID: ");
            int bookID = scan.nextInt();
            System.out.print("Title: ");
            String title = scan.next();
            System.out.print("Author: ");
            String author = scan.next();
            System.out.print("Total Copies: ");
            int totalCopies = scan.nextInt();

            Book newBook = new Book(bookID, title, author, totalCopies, totalCopies);
            books.add(newBook);
            System.out.println("Book added successfully!");
        }

        public void removeBook() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Book ID to remove:");
            int bookIDToRemove = scan.nextInt();

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

        public void addMember() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Details:");
            System.out.print("Name: ");
            String name = scan.next();
            System.out.print("Age: ");
            int age = scan.nextInt();
            System.out.print("Phone Number: ");
            long phoneNumber = scan.nextLong();

            Member newMember = new Member(name, age, phoneNumber);
            members.add(newMember);
            System.out.println("Member Successfully Registered with <Member ID>!");
        }

        // Other methods to add and remove members/books
        // Methods to issue, return books and calculate fines
    }

    static class Member {
        // Member class definition remains unchanged
        private String name;
        private int age;
        private long phoneNumber;
        private int memberID;
        private int balance;
        private ArrayList<Book> borrowed_books = new ArrayList<Book>();

        public Member(String name, int age, long PhoneNumber){
            this.name = name;
            this.age = age;
            this.phoneNumber = phoneNumber;
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
        public String getTitle() { //getter
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public int getAvailableCopies() {
            return availableCopies;
        }
        // Other methods and getters/setters
    }
}
