package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieSeatSelector {
    int rows = 5;
    int cols = 10;
    static ArrayList<ArrayList<Integer>> seats = new ArrayList<>();
    ArrayList<ArrayList<Integer>> availableSeats = seats;

    public MovieSeatSelector() {
        int seat = 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(seat++);
            }
            seats.add(row);
        }
    }

    public void reserveSeat(int selectedRow, int selectedColumn) {
        try {
            int seatNum = availableSeats.get(selectedRow - 1).get(selectedColumn - 1);

            if (seatNum != 0) {
                availableSeats.get(selectedRow - 1).set(selectedColumn - 1, 0);
                System.out.println("Seat " + seatNum + " has been reserved.");
            } else {
                System.out.println("Seat already reserved.");
                System.out.println("Available Seats:");
                for (ArrayList<Integer> seatRow : seats) {
                    for (Integer seat : seatRow) {
                        if (seat != 0) {
                            System.out.printf("%3d ", seat);
                        } else {
                            System.out.print(" -- ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Seat not found. Please enter a valid row and column.");
        }
    }

    public void cancelBooking(int canceledRow, int canceledColumn) {
        try {
            if (seats.get(canceledRow - 1).get(canceledColumn - 1) == 0) {
                int seatNum = (canceledRow - 1) * cols + canceledColumn;
                seats.get(canceledRow - 1).set(canceledColumn - 1, seatNum);
                System.out.println("Seat " + seatNum + " has been cancelled.");
            } else {
                System.out.println("Unable to cancel seat. Seat has not yet been reserved.");
                System.out.println("Reserved Seats:");
                for (ArrayList<Integer> seatRow : seats) {
                    for (Integer seat : seatRow) {
                        if (seat == 0) {
                            System.out.print(" Res");
                        } else {
                            System.out.print(" -- ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Seat not found. Please enter a valid row and column.");
        }
    }

    public static void main(String[] args) {
        MovieSeatSelector MSS = new MovieSeatSelector();
        Scanner sc = new Scanner(System.in);

        boolean continueUse = true;

        while (continueUse) {
            System.out.println("What would you like to do?");
            System.out.println("Enter 1 to reserve a seat, " +
                                "2 to cancel a booking, " +
                                "3 to see available seats, " +
                                "4 to exit: ");

            int option = sc.nextInt();

            if (option == 1) {
                boolean continueBooking = true;

                while (continueBooking) {
                    System.out.println("Enter Row and Column of desired seat: ");
                    int selectedRow = sc.nextInt();
                    int selectedColumn = sc.nextInt();

                    MSS.reserveSeat(selectedRow, selectedColumn);

                    System.out.println("Would you like to reserve another seat? (Yes/No)");
                    sc.nextLine();
                    String choice = sc.nextLine().trim().toLowerCase();

                    if (choice.equals("no")) {
                        continueBooking = false;
                        System.out.println("Thank you for reserving your seats with us.");
                    }
                }

            } else if (option == 2) {
                boolean continueBooking = true;

                while (continueBooking) {
                    System.out.println("Enter Row and Column of seat to cancel: ");
                    int canceledRow = sc.nextInt();
                    int canceledColumn = sc.nextInt();

                    MSS.cancelBooking(canceledRow, canceledColumn);

                    System.out.println("Would you like to cancel another seat? (Yes/No)");
                    sc.nextLine();
                    String choiceC = sc.nextLine().trim().toLowerCase();

                    if (choiceC.equals("no")) {
                        continueBooking = false;
                        System.out.println("Thank you for considering us.");
                    }
                }
            } else if (option == 3) {
                System.out.println("Available Seats:");
                for (ArrayList<Integer> seatRow : seats) {
                    for (Integer seat : seatRow) {
                        if (seat != 0) {
                            System.out.printf("%3d ", seat);
                        } else {
                            System.out.print(" -- ");
                        }
                    }
                    System.out.println();
                }
                System.out.println();
            } else if (option == 4) {
                continueUse = false;
                System.out.println("Have a good day!");
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}
