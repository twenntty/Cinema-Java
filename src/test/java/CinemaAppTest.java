import org.example.Cinema;
import org.example.CinemaApp;
import org.junit.Test;
import static org.junit.Assert.*;

public class CinemaAppTest {
    @Test
    public void testCinemaAppConstructor() {
        CinemaApp cinemaApp = new CinemaApp();
        assertNotNull(cinemaApp);
    }

    @Test
    public void testInvalidHallNumber() {
        CinemaApp cinemaApp = new CinemaApp();
        int hallNumber = 6;
        boolean validInput = cinemaApp.isValidHallNumber(hallNumber);
        assertFalse(validInput);
    }
}

