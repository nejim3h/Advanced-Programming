package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private static int nextID = 1;
    private int id;
    private String name;
    private String type;
    private String sound;
    private static List<Animal> animalsList = new ArrayList<>();

    public Animal(String name, String type, String sound) {
        this.id = nextID++;
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    public Animal() {
    }

    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Animal Type:");
        System.out.println("1. Mammals");
        System.out.println("2. Amphibians");
        System.out.println("3. Reptiles");
        int typeOption = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        while (typeOption < 1 || typeOption > 3) {
            System.out.println("Invalid option. Please enter 1, 2, or 3:");
            typeOption = scanner.nextInt();
            scanner.nextLine(); // consume newline character
        }
        String type = "";
        switch (typeOption) {
            case 1:
                type = "Mammals";
                break;
            case 2:
                type = "Amphibians";
                break;
            case 3:
                type = "Reptiles";
                break;
        }
        System.out.println("Enter Animal Sound:");
        String sound = scanner.nextLine();
        Animal newAnimal = new Animal(name, type, sound);
        animalsList.add(newAnimal);
        System.out.println("New animal added successfully.");
    }

    public void updateAnimalDetails() {
        printAnimalsList(animalsList);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal ID:");
        int animalID = scanner.nextInt();
        scanner.nextLine();
        Animal animal = getAnimalByID(animalsList, animalID);
        if (animal == null) {
            System.out.println("Invalid animal ID.");
            return;
        }
        System.out.println("Enter Animal Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Animal Type (Mammals, Amphibians, or Reptiles):");
        String type = scanner.nextLine();
        while (!isValidType(type)) {
            System.out.println("Invalid type. Please enter Mammals, Amphibians, or Reptiles:");
            type = scanner.nextLine();
        }
        animal.name = name;
        animal.type = type;
        System.out.println("Animal details updated successfully.");
    }

    public void removeAnimal() {
        printAnimalsList(animalsList);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal ID:");
        int animalID = scanner.nextInt();
        scanner.nextLine();
        Animal animal = getAnimalByID(animalsList, animalID);
        if (animal == null) {
            System.out.println("Invalid animal ID.");
            return;
        }
        animalsList.remove(animal);
        System.out.println("Animal removed successfully.");
    }

    // Create a new method to list animals
    public static void listAnimals() {
        System.out.println("List of all animals:");
        for (Animal animal : animalsList) {
            System.out.println(animal.getID() + ": " + animal.getName() + " (" + animal.getType() + ")");
        }
    }

    private boolean isValidType(String type) {
        return type.equals("Mammals") || type.equals("Amphibians") || type.equals("Reptiles");
    }

    public Animal getAnimalByID(List<Animal> animalsList, int animalID) {
        for (Animal animal : animalsList) {
            if (animal.getID() == animalID) {
                return animal;
            }
        }
        return null;
    }
    public static void visitAnimal() {
        printAnimals();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the animal you want to visit: ");
        int animalID = scanner.nextInt();
        scanner.nextLine();

        Animal animalToVisit = getAnimalByID(animalID);

        if (animalToVisit == null) {
            System.out.println("Animal with the specified ID was not found.");
            return;
        }

        System.out.println("What would you like to do with " + animalToVisit.getName() + "?");
        System.out.println("1. Feed");
        System.out.println("2. Read");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Feeding " + animalToVisit.getName() + " with sound: " + animalToVisit.getSound());
        } else if (choice == 2) {
            System.out.println("Reading about " + animalToVisit.getName() + "'s type: " + animalToVisit.getType());
        } else {
            System.out.println("Invalid choice. Please select 1 to feed or 2 to read.");
        }
    }

    public void printAnimalsList(List<Animal> animalsList) {
        System.out.println("List of all animals:");
        for (Animal animal : animalsList) {
            System.out.println(animal.getID() + ": " + animal.getName() + " (" + animal.getType() + ")");
        }
    }

    public static void printAnimals() {
        System.out.println("List of all animal names:");
        for (Animal animal : animalsList) {
            System.out.println(animal.getID() + ": " + animal.getName());
        }
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public List<Animal> getAnimalsList() {
        return new ArrayList<>(animalsList);
    }

    public void setAnimalsList(List<Animal> animalsList) {
        this.animalsList = animalsList;
    }


    @Override
    public String toString() {
        return "ID: " + this.getID() + ", Name: " + this.getName();
    }

    public static Animal getAnimalByID(int animalID) {
        for (Animal animal : animalsList) {
            if (animal.getID() == animalID) {
                return animal;
            }
        }
        return null;
    }

    public String getSound() {
        return this.sound;
    }
}