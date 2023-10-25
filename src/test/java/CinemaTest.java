import org.example.Cinema;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CinemaTest {
    private Cinema cinema;

    @Before
    public void setUp() {
        cinema = new Cinema();
    }

    @Test
    public void testBookSeats() {
        int hallNumber = 1;
        int row = 2;
        int[] seats = {3, 4, 5};
        cinema.bookSeats(hallNumber, row, seats);
        assertEquals(1, cinema.getCinemaArray()[hallNumber - 1][row - 1][2]);
        assertEquals(1, cinema.getCinemaArray()[hallNumber - 1][row - 1][3]);
        assertEquals(1, cinema.getCinemaArray()[hallNumber - 1][row - 1][4]);
    }

    @Test
    public void testCancelBooking() {
        int hallNumber = 2;
        int row = 3;
        int[] seats = {6, 7};
        cinema.bookSeats(hallNumber, row, seats);
        cinema.cancelBooking(hallNumber, row, seats);
        assertEquals(0, cinema.getCinemaArray()[hallNumber - 1][row - 1][5]);
        assertEquals(0, cinema.getCinemaArray()[hallNumber - 1][row - 1][6]);
    }

}

