/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bryan.airline;

/**
 *
 * @author EL GUARDIAN
 */

import java.util.Scanner;

public class Airline {


     public static void main(String[] args) {
        boolean[] seatingChart = new boolean[10];
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Please type 1 for First Class and 2 for Economy: ");
            int section = input.nextInt();

            if (section == 1) {
                int seat = assignSeat(seatingChart, 0, 4);
                if (seat != -1) {
                    printBoardingPass("First Class", seat);
                } else {
                    System.out.println("First Class is full. Would you like to be placed in Economy? (y/n)");
                    char choice = input.next().charAt(0);
                    if (choice == 'y') {
                        seat = assignSeat(seatingChart, 5, 9);
                        if (seat != -1) {
                            printBoardingPass("Economy", seat);
                        } else {
                            System.out.println("Economy is full.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                        break;
                    }
                }
            } else if (section == 2) {
                int seat = assignSeat(seatingChart, 5, 9);
                if (seat != -1) {
                    printBoardingPass("Economy", seat);
                } else {
                    System.out.println("Economy is full. Would you like to be placed in First Class? (y/n)");
                    char choice = input.next().charAt(0);
                    if (choice == 'y') {
                        seat = assignSeat(seatingChart, 0, 4);
                        if (seat != -1) {
                            printBoardingPass("First Class", seat);
                        } else {
                            System.out.println("First Class is full.");
                        }
                    } else {
                        System.out.println("Next flight leaves in 3 hours.");
                       break;
                    }
                }
            }
        }
    }

    public static int assignSeat(boolean[] seatingChart, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seatingChart[i]) {
                seatingChart[i] = true;
                return i + 1;
            }
        }
        return -1;
    }

    public static void printBoardingPass(String section, int seat) {
        System.out.println("Boarding Pass:");
        System.out.println("Section: " + section);
        System.out.println("Seat #: " + seat);
    }
}

    

