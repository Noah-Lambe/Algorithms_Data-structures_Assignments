package Assignment5.AnimalShelterQueue;

import java.util.LinkedList;
import java.util.Queue;

abstract class Animal {
    private String name;
    private int arrivalOrder;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArrivalOrder(int order) {
        this.arrivalOrder = order;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    public abstract String getType();

    public boolean isOlderThan(Animal other) {
        return this.arrivalOrder < other.arrivalOrder;
    }

    @Override
    public String toString() {
        return getType() + ": " + name + " (arrival #" + arrivalOrder + ")";
    }
}