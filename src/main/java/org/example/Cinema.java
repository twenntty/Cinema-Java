package org.example;

public class Cinema {
    private static int halls = 5;
    private static int rows = 10;
    private static int seatsPerRow = 20;

    private static int[][][] cinemaArray;

    public Cinema() {

        cinemaArray = new int[halls][rows][seatsPerRow];

        for (int hall = 0; hall < halls; hall++) {
            for (int row = 0; row < rows; row++) {
                for (int seat = 0; seat < seatsPerRow; seat++) {
                    cinemaArray[hall][row][seat] = 0;
                }
            }
        }
    }

    public  void bookSeats(int hallNumber, int row, int[] seats) {
        if (hallNumber < 1 || hallNumber > halls) {
            System.out.println("Зал з номером " + hallNumber + " не існує");
            return;
        }

        if(row < 1 || row > rows) {
            System.out.println("Ряд " + row + " не існує в залі " +  hallNumber );
            return;
        }

        for (int seat : seats) {
            if (seat < 1 || seat > seatsPerRow) {
                System.out.println("Місце " + seat + " не існує в ряду " +  row + "." );
                return;
            }

            int seatIndex = seat - 1;
            if (cinemaArray[hallNumber - 1][row - 1][seatIndex] == 1) {
                System.out.println("Місце " + seat + " в ряду "  + row + " в залі " + hallNumber + " вже заброньоване.");
            } else {
                cinemaArray[hallNumber - 1][row - 1][seatIndex] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " було успішно заброньоване.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        if (hallNumber < 1 || hallNumber > halls) {
            System.out.println("Зал з номером " + hallNumber + " не існує.");
            return;
        }

        if (row < 1 || row > rows) {
            System.out.println("Ряд " + row + " не існує в залі " + hallNumber + ".");
            return;
        }

        for (int seat : seats) {
            if (seat < 1 || seat > seatsPerRow) {
                System.out.println("Місце " + seat + " не існує в ряду " + row + ".");
                continue;
            }

            int seatIndex = seat - 1;
            if (cinemaArray[hallNumber - 1][row - 1][seatIndex] == 0) {
                System.out.println("Місце " + seat + " в ряду " + row + " в залі " + hallNumber + " вже вільне.");
            } else {
                cinemaArray[hallNumber - 1][row - 1][seatIndex] = 0;
                System.out.println("Скасування бронювання місця " + seat + " в ряду " + row + " в залі " + hallNumber + ".");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        if (hallNumber < 1 || hallNumber > halls) {
            System.out.println("Зал з номером " + hallNumber + " не існує.");
            return false;
        }

        if (numSeats <= 0 || numSeats > seatsPerRow) {
            System.out.println("Невірна кількість місць для перевірки.");
            return false;
        }

        for (int row = 0; row < rows; row++) {
            int consecutiveEmptySeats = 0;

            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (cinemaArray[hallNumber - 1][row][seat] == 0) {
                    consecutiveEmptySeats++;
                    if (consecutiveEmptySeats == numSeats) {
                        System.out.println("Доступно " + numSeats + " послідовних місць у ряду " + (row + 1) + " в залі " + hallNumber + ".");
                        return true;
                    }
                } else {
                    consecutiveEmptySeats = 0;
                }
            }
        }

        System.out.println("Не знайдено " + numSeats + " послідовних вільних місць у залі " + hallNumber + ".");
        return false;
    }

    public void displayHall(int hallNumber) {
        if (hallNumber < 1 || hallNumber > halls) {
            System.out.println("" + hallNumber + "");
            return;
        }

        System.out.println("" + hallNumber + "");
        for (int row = 0; row < rows; row++) {
            for (int seat = 0; seat < seatsPerRow; seat++) {
                if (cinemaArray[hallNumber - 1][row][seat] == 0){
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

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