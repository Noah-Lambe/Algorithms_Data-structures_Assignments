package Assignment5.AnimalShelterQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Assignment5.AnimalShelterQueue.Animal;

public class Main {
    public static void main(String[] args) {
        Queue<Animal> shelter = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        shelter.offer(new Animal("Buddy", "Dog"));
        shelter.offer(new Animal("Mittens", "Cat"));
        shelter.offer(new Animal("Rex", "Dog"));
        shelter.offer(new Animal("Whiskers", "Cat"));

        System.out.println("Welcome to the Animal Shelter!");
        System.out.println("Please select an option:");
        System.out.println("1. View Shelter Queue");
        System.out.println("2. Adopt Any Animal");
        System.out.println("3. Adopt a Dog");
        System.out.println("4. Adopt a Cat");
        System.out.println("5. Exit");

        int selection = sc.nextInt();

        while (selection != 5) {
            switch (selection) {
                case 1:
                    System.out.println("Current Shelter Queue: " + shelter);
                    break;
                case 2:
                    System.out.println("Adopting an Animal: " + shelter.poll());
                    break;
                case 3:
                    for (Animal animal : shelter) {
                        if (animal.getType().equalsIgnoreCase("Dog")) {
                            System.out.println("Adopting a Dog: " + animal);
                            shelter.remove(animal);
                            break;
                        }
                    }
                    break;
                case 4:
                    for (Animal animal : shelter) {
                        if (animal.getType().equalsIgnoreCase("Cat")) {
                            System.out.println("Adopting a Cat: " + animal);
                            shelter.remove(animal);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
            System.out.println("\nPlease select an option:");
            selection = sc.nextInt();
        }
        sc.close();
    }
}
