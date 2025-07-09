package Assignment5.AnimalShelterQueue;

import java.util.LinkedList;
import java.util.Queue;

class AnimalShelter {
    private Queue<Dog> dogs;
    private Queue<Cat> cats;
    private int arrivalCounter; // Tracks arrival order

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        arrivalCounter = 0;
    }

    // Enqueue any animal
    public void enqueue(Animal animal) {
        animal.setArrivalOrder(arrivalCounter++);

        if (animal instanceof Dog) {
            dogs.offer((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.offer((Cat) animal);
        } else {
            throw new IllegalArgumentException("Only dogs and cats are allowed in this shelter");
        }

        System.out.println("Added to shelter: " + animal);
    }

    // Dequeue the oldest animal
    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        }

        if (dogs.isEmpty()) {
            return cats.poll();
        }

        if (cats.isEmpty()) {
            return dogs.poll();
        }

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();

        if (oldestDog.isOlderThan(oldestCat)) {
            return dogs.poll();
        } else {
            return cats.poll();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }

    // Utility methods
    public boolean isEmpty() {
        return dogs.isEmpty() && cats.isEmpty();
    }

    public int size() {
        return dogs.size() + cats.size();
    }

    public int getDogCount() {
        return dogs.size();
    }

    public int getCatCount() {
        return cats.size();
    }
}

