import color.model.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    // [value=#D58D35, r=213, g=141, b=53]
    private Color color;

    @BeforeEach
    public void setUp() {
        this.color = new Color(213, 141, 53);
    }

    @AfterEach
    public void throwOut() {
        this.color = null;
    }

    @Test
    public void testConstructorRGB() {
        assertAll("Objet Color non conforme",
                  () -> assertEquals(213, color.red, "Constructeur incorrect sur red"),
                  () -> assertEquals(141, color.green, "Constructeur incorrect sur green"),
                  () -> assertEquals(53, color.blue, "Constructeur incorrect sur blue")
        );
    }


    @Test
    public void testConstructorRGBThrowsExceptionArgumentTooLow() {
        String expectedErrorMessage = "La valeur d'une couleur doit être comprise entre 0 et 255";
        IllegalArgumentException exceptionRed = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(-1, 141, 53),
                "Exception non lancée pour une valeur de rouge < 0");

        assertTrue(exceptionRed.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de rouge < 0");

        IllegalArgumentException exceptionGreen = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(213, -1, 53),
                "Exception non lancée pour une valeur de vert < 0");

        assertTrue(exceptionGreen.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de vert < 0");


        IllegalArgumentException exceptionBlue = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(213, 141, -1),
                "Exception non lancée pour une valeur de bleu < 0");

        assertTrue(exceptionBlue.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de bleu < 0");

    }

    @Test
    public void testConstructorRGBThrowsExceptionArgumentTooHigh() {
        String expectedErrorMessage = "La valeur d'une couleur doit être comprise entre 0 et 255";
        IllegalArgumentException exceptionRed = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(256, 141, 43),
                "Exception non lancée pour une valeur de rouge > 255");

        assertTrue(exceptionRed.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de rouge > 255");

        IllegalArgumentException exceptionGreen = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(213, 256, 53),
                "Exception non lancée pour une valeur de vert > 255");

        assertTrue(exceptionGreen.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de vert > 255");


        IllegalArgumentException exceptionBlue = assertThrows(
                IllegalArgumentException.class,
                () -> new Color(213, 141, 256),
                "Exception non lancée pour une valeur de bleu > 255");

        assertTrue(exceptionBlue.getMessage().contains(expectedErrorMessage),
                   "Message d'exception manquant pour une valeur de bleu > 255");
    }

    @Test
    public void testConstructorHexadecimal() {
        this.color = new Color("#D58D35");
        assertAll("Objet Color non conforme",
                  () -> assertEquals(213, color.red, "Constructeur incorrect sur red"),
                  () -> assertEquals(141, color.green, "Constructeur incorrect sur green"),
                  () -> assertEquals(53, color.blue, "Constructeur incorrect sur blue")
        );
    }

    // TODO getter / setter
}
