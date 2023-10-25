package org.example;

import java.util.Scanner;

public class CinemaApp {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вітаємо у кінотеатрі!");
        int hallNumber;
        do {
            System.out.println("Виберіть номер залу (1-5): ");
            hallNumber = scanner.nextInt();
            if (hallNumber < 1 || hallNumber > 5) {
                System.out.println("Зал з номером " + hallNumber + " не існує.");
            }
        } while (hallNumber < 1 || hallNumber > 5);

        cinema.printSeatingArrangement(hallNumber);

        System.out.println("Введіть кількість місць для бронювання: ");
        int numSeats = scanner.nextInt();

        boolean seatsAvailable = cinema.checkAvailability(hallNumber, numSeats);
        if (!seatsAvailable) {
            System.out.println("На жаль, недостатньо вільних місць для заданої кількості.");
            return;
        }

        System.out.println("Введіть номер ряду: ");
        int row = scanner.nextInt();

        System.out.println("Введіть номери місць (розділіть пробілами): ");
        scanner.nextLine();
        String seatsInput = scanner.nextLine();
        String[] seatsInputArray = seatsInput.split(" ");
        int[] seats = new int[seatsInputArray.length];
        for (int i = 0; i < seatsInputArray.length; i++) {
            seats[i] = Integer.parseInt(seatsInputArray[i]);
        }

        cinema.bookSeats(hallNumber, row, seats);

        cinema.printSeatingArrangement(hallNumber);

        System.out.println("Бажаєте скасувати бронювання? (Так/Ні): ");
        String cancelChoice = scanner.next();
        if (cancelChoice.equalsIgnoreCase("Так")) {
            cinema.cancelBooking(hallNumber, row, seats);
            cinema.printSeatingArrangement(hallNumber);
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        return false;
    }

    public boolean isValidHallNumber(int hallNumber) {
        return false;
    }
}
