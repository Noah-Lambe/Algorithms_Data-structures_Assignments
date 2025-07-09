package Assignment5.AnimalShelterQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Assignment5.AnimalShelterQueue.Animal;
import Assignment5.AnimalShelterQueue.Cat;
import Assignment5.AnimalShelterQueue.Dog;
import Assignment5.AnimalShelterQueue.AnimalShelter.*;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Scanner sc = new Scanner(System.in);

        shelter.enqueue(new Dog("Buddy"));
        shelter.enqueue(new Cat("Mittens"));
        shelter.enqueue(new Dog("Rex"));
        shelter.enqueue(new Cat("Whiskers"));
        shelter.enqueue(new Dog("Max"));

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
                    System.out.println("Adopting any animal: " + shelter.dequeueAny());
                    break;
                case 3:
                    System.out.println("Adopting a dog: " + shelter.dequeueDog());
                    break;
                case 4:
                    System.out.println("Adopting a cat: " + shelter.dequeueCat());
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
            System.out.println("\nPlease select an option:");
            selection = sc.nextInt();
        }
        System.out.println("Thank you for visiting the Animal Shelter!");
        sc.close();
    }
}
