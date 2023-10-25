package org.example;

public class Cinema {
    public static void main(String[] args) {
        int halls = 5;
        int rows = 10;
        int seatsPerRow = 20;

        int[][][] cinemaArray = new int[halls][rows][seatsPerRow];

        for(int hall = 0; hall < halls; hall++){
            for(int row = 0; row < rows; row++) {
                for(int seat = 0; seat < seatsPerRow; seat++){
                    cinemaArray[hall][row][seat] = 0;
                }
            }
        }

        for(int hall = 0; hall < halls; hall++){
            System.out.println("Зал" + (hall + 1));
            for (int row = 0; row < rows; row++) {
                for (int seat = 0; seat < seatsPerRow; seat++){
                    System.out.print(cinemaArray[hall][row][seat] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}