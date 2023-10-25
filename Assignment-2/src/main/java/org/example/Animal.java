package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private static int nextID = 1;
    private int id;
    private String name;
    private String type;
    private List<Animal> animalsList = new ArrayList<>();

    public Animal(String name, String type) {
        this.id = nextID++;
        this.name = name;
        this.type = type;
    }

    public Animal() {
    }

    public void addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Animal Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Animal Type (Mammals, Amphibians, or Reptiles):");
        String type = scanner.nextLine();
        while (!isValidType(type)) {
            System.out.println("Invalid type. Please enter Mammals, Amphibians, or Reptiles:");
            type = scanner.nextLine();
        }
        Animal newAnimal = new Animal(name, type);
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

    private boolean isValidType(String type) {
        return type.equals("Mammals") || type.equals("Amphibians") || type.equals("Reptiles");
    }

    private Animal getAnimalByID(List<Animal> animalsList, int animalID) {
        for (Animal animal : animalsList) {
            if (animal.getID() == animalID) {
                return animal;
            }
        }
        return null;
    }

    private void printAnimalsList(List<Animal> animalsList) {
        System.out.println("List of all animals:");
        for (Animal animal : animalsList) {
            System.out.println(animal.getID() + ": " + animal.getName() + " (" + animal.getType() + ")");
        }
    }

    void printAnimals() {
        System.out.println("List of all animals:");
        for (Animal animal : animalsList) {
            System.out.println(animal.toString());
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
        return animalsList;
    }
    @Override
    public String toString() {
        return "ID: " + this.getID() + ", Name: " + this.getName() + ", Type: " + this.getType();
    }
}
