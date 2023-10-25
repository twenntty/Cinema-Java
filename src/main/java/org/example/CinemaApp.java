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
        } while (hallNumber < 1 || hallNumber > 5);

        cinema.displayHall(hallNumber);

        System.out.println("Введіть номер ряду: ");
        int row = scanner.nextInt();

        System.out.println("Введіть номери місць (розділіть пробілами): ");
        String seatsInput = scanner.next();
        String[] seatsInputArray = seatsInput.split(" ");
        int[] seats = new int[seatsInputArray.length];
        for (int i = 0; i < seatsInputArray.length; i++) {
            seats[i] = Integer.parseInt(seatsInputArray[i]);
        }

        cinema.bookSeats(hallNumber, row, seats);

        cinema.displayHall(hallNumber);
    }
}
