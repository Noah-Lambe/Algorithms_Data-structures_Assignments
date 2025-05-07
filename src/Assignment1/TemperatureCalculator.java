package Assignment1;

import java.util.Arrays;
import java.util.Scanner;

public class TemperatureCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of Temperatures for analysis: ");
        int quantity = sc.nextInt();

        int[] temps = new int[quantity];

        System.out.println("Enter " + quantity + " Temperatures:");
        for (int i = 0; i < quantity; i++) {
            temps[i] = sc.nextInt();
        }

//        System.out.println("You entered:");
//        for (int temp : temps) {
//            System.out.println(temp + " ");
//        }

        int totalTemp = 0;
        for (int i = 0; i < quantity; i++) {
            totalTemp = totalTemp + temps[i];
        }

//        System.out.println("Total Temperature: " + totalTemp);

        double averageTemp = (double)totalTemp / quantity;
        long roundedAverage = Math.round(averageTemp);
        System.out.println("Average Temperature is " + roundedAverage + " degrees.");

        int[] temporaryArray = new int[quantity];
        int newIndex = 0;
        for (int i = 0; i < quantity; i++){
            if (temps[i] > roundedAverage) {
                temporaryArray[newIndex] = temps[i];
                newIndex++;
            }
        }

        int[] tempsAboveAverage = new int[newIndex];
        for (int i = 0; i < newIndex; i++) {
            tempsAboveAverage[i] = temporaryArray[i];
        }

        System.out.println("Temperatures above average: " + Arrays.toString(tempsAboveAverage));
    }
}