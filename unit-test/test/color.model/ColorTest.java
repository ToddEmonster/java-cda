import color.model.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    private Color color;

    @BeforeEach
    public void cleanStart() {
        this.color = null;
    }

    @Test
    public void testConstructor() {
        this.color = new Color(1, 2, 3);
        assertEquals(1, color.red, "constructeur incorrect sur red");
        assertEquals(2, color.green, "constructeur incorrect sur green");
        assertEquals(3, color.blue, "constructeur incorrect sur blue");
    }

    @Test
    public void testConstructorThrowsExceptionArgumentTooLow() {
        String expectedErrorMessage = "La valeur d'une couleur doit être comprise entre 0 et 255";
        IllegalArgumentException exceptionRed = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(-1, 0, 0),
                "Exception non lancée pour une valeur de rouge < 0");

        assertTrue(exceptionRed.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de rouge < 0");

        IllegalArgumentException exceptionGreen = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(0, -1, 0),
                "Exception non lancée pour une valeur de vert < 0");

        assertTrue(exceptionGreen.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de vert < 0");


        IllegalArgumentException exceptionBlue = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(0, 0, -1),
                "Exception non lancée pour une valeur de bleu < 0");

        assertTrue(exceptionBlue.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de bleu < 0");

    }

    @Test
    public void testConstructorThrowsExceptionArgumentTooHigh() {
        String expectedErrorMessage = "La valeur d'une couleur doit être comprise entre 0 et 255";
        IllegalArgumentException exceptionRed = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(256, 0, 0),
                "Exception non lancée pour une valeur de rouge > 255");

        assertTrue(exceptionRed.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de rouge > 255");

        IllegalArgumentException exceptionGreen = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(0, 256, 0),
                "Exception non lancée pour une valeur de vert > 255");

        assertTrue(exceptionGreen.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de vert > 255");


        IllegalArgumentException exceptionBlue = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(0, 0, 256),
                "Exception non lancée pour une valeur de bleu > 255");

        assertTrue(exceptionBlue.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de bleu > 255");
    }


    @AfterEach
    public void throwOut() {
        this.color = null;
    }
}
