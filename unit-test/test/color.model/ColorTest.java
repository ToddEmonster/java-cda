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

    // Messages d'erreur attendus
    final static String RGB_INVALID_ERROR_MESSAGE = "La valeur d'une couleur doit être comprise entre 0 et 255";
    final static String HEX_DIGIT_ERROR_MESSAGE = "Valeur hex incorrecte (doit être deux caractères 0-9 ou A-F)";
    final static String HEX_CODE_INVALID_ERROR_MESSAGE =
            "Le code hexadecimal entré est incorrect. Il doit être de la forme "
                    + "'#xxxxxx' où 'xx' est un chiffre hexadécimal compris entre 0 et 9 "
                    + "ou A, B, C, D, E, F";


    /*
    ------------------------------------------------------------------------------------------
    Getters
    ------------------------------------------------------------------------------------------
    */
    @Test
    public void testGetRed() {
        assertEquals(213, color.getRed(), "getRed() est incorrecte");
    }

    @Test
    public void testGetGreen() {
        assertEquals(141, color.getGreen(), "getGreen() est incorrecte");
    }
    @Test
    public void testGetBlue() {
        assertEquals(53, color.getBlue(), "getBlue() est incorrecte");
    }

    @Test
    public void testGetHexadecimalCode() {
        assertEquals("#D58D35", color.getHexValue(), "getHexadecimalCode() est incorrecte");
    }

    /*
    ------------------------------------------------------------------------------------------
    Setters
    ------------------------------------------------------------------------------------------
    */
    @Test
    public void testSetRed() {
        color.setRed(25);
        assertAll("setRed() incorrect",
                  () -> assertEquals(25, color.getRed(), "getRed() est incorrect"),
                  () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                  () -> assertEquals(53, color.getBlue(), "getBlue() est incorrect"),
                  () -> assertEquals("#198D35", color.getHexValue(), "getHexadecimalCode() est incorrect"));
    }

    @Test
    public void testSetGreen() {
        color.setGreen(25);
        assertAll("setRed() incorrect",
                  () -> assertEquals(213, color.getRed(), "Invalide sur getRed()"),
                  () -> assertEquals(25, color.getGreen(), "Invalide sur getGreen()"),
                  () -> assertEquals(53, color.getBlue(), "Invalide sur getBlue()"),
                  () -> assertEquals("#D51935", color.getHexValue(), "Invalide sur getHexadecimalCode()"));
    }

    @Test
    public void testSetBlue() {
        color.setBlue(25);
        assertAll("setRed() incorrect",
                  () -> assertEquals(213, color.getRed(), "getRed() est incorrect"),
                  () -> assertEquals(141, color.getGreen(), "getGreen() est incorrect"),
                  () -> assertEquals(25, color.getBlue(), "getBlue() est incorrect"),
                  () -> assertEquals("#D58D19", color.getHexValue(), "getHexadecimalCode() est incorrect"));
    }

    @Test
    public void testSetHexValue() {
        color.setHexValue("#1643B1");
        assertAll("setHexValue() incorrect",
                  () -> assertEquals(22, color.getRed(), "getRed() est incorrect"),
                  () -> assertEquals(67, color.getGreen(), "getGreen() est incorrect"),
                  () -> assertEquals(177, color.getBlue(), "getBlue() est incorrect"),
                  () -> assertEquals("#1643B1", color.getHexValue(), "getHexadecimalCode() est incorrect"));
    }

    // TODO : setters throw exception * 4

    /*
    ------------------------------------------------------------------------------------------
    Constructeurs
    ------------------------------------------------------------------------------------------
    */

    // RGB
    @Test
    public void testConstructorRGB() {
        assertAll("Objet Color non conforme",
                  () -> assertEquals(213, color.getRed(), "Constructeur incorrect sur red"),
                  () -> assertEquals(141, color.getGreen(), "Constructeur incorrect sur green"),
                  () -> assertEquals(53, color.getBlue(), "Constructeur incorrect sur blue")
        );
    }

    @Test
    public void testConstructorRGBThrowsExceptionArgumentTooLow() {
        assertAll("Exception non gérée sur le constructeur RGB pour input < 0",
                  () -> { // red
                      IllegalArgumentException exceptionRed = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color(-1, 141, 43),
                              "Exception non lancée pour une valeur de rouge < 0");
                      assertNotNull(
                              exceptionRed.getMessage(),
                              "Message d'exception manquant pour une valeur de rouge < 0");
                      assertTrue(
                              exceptionRed.getMessage().contains(RGB_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de rouge < 0");
                  },
                  () -> { // green
                      IllegalArgumentException exceptionGreen = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color(213, -1, 43),
                              "Exception non lancée pour une valeur de vert < 0");
                      assertNotNull(
                              exceptionGreen.getMessage(),
                              "Message d'exception manquant pour une valeur de vert < 0");
                      assertTrue(
                              exceptionGreen.getMessage().contains(RGB_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de vert < 0");
                  },
                  () -> { // blue
                      IllegalArgumentException exceptionBlue = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color(213, 141, -1),
                              "Exception non lancée pour une valeur de bleu < 0");
                      assertNotNull(
                              exceptionBlue.getMessage(),
                              "Message d'exception manquant pour une valeur de bleu < 0");
                      assertTrue(
                              exceptionBlue.getMessage().contains(RGB_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de bleu < 0");
                  }
        );
    }

    @Test
    public void testConstructorRGBThrowsExceptionArgumentTooHigh() {
        assertAll("Exception non gérée sur le constructeur RGB pour input > 255",
                  () -> { // red
                      IllegalArgumentException exceptionRed = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color(256, 141, 43),
                              "Exception non lancée pour une valeur de rouge > 255");
                      assertNotNull(
                              exceptionRed.getMessage(),
                              "Message d'exception manquant pour une valeur de rouge > 255");
                      assertTrue(
                              exceptionRed.getMessage().contains(RGB_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de rouge > 255");
                  },
                  () -> { // green
                      IllegalArgumentException exceptionGreen = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color(213, 256, 43),
                              "Exception non lancée pour une valeur de vert > 255");
                      assertNotNull(
                              exceptionGreen.getMessage(),
                              "Message d'exception manquant pour une valeur de vert > 255");
                      assertTrue(
                              exceptionGreen.getMessage().contains(RGB_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de vert > 255");
                  },
                  () -> { // blue
                      IllegalArgumentException exceptionBlue = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color(213, 141, 256),
                              "Exception non lancée pour une valeur de bleu > 255");
                      assertNotNull(
                              exceptionBlue.getMessage(),
                              "Message d'exception manquant pour une valeur de bleu > 255");
                      assertTrue(
                              exceptionBlue.getMessage().contains(RGB_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de bleu > 255");
                  }
        );
    }

    // Hex
    @Test
    public void testConstructorHexadecimal() {
        this.color = new Color("#D58D35");
        assertAll("Objet Color non conforme",
                  () -> assertEquals(213, color.getRed(), "Constructeur incorrect sur red"),
                  () -> assertEquals(141, color.getGreen(), "Constructeur incorrect sur green"),
                  () -> assertEquals(53, color.getBlue(), "Constructeur incorrect sur blue")
        );
    }

    @Test
    public void testConstructorHexThrowsExceptionArgumentInvalid() {
        assertAll("Exception non gérée sur le constructeur hex pour input incorrect",
                  () -> { // hex
                      IllegalArgumentException exceptionHex = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color("mauvaiseValeur"),
                              "Exception non lancée pour une valeur de hex invalide");
                      assertNotNull(
                              exceptionHex.getMessage(),
                              "Message d'exception manquant pour une valeur de hex invalide");
                      assertTrue(
                              exceptionHex.getMessage().contains(HEX_CODE_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de hex invalide");

                  },
                  () -> {
                      IllegalArgumentException exceptionHex = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color("&D58D35"),
                              "Exception non lancée pour une valeur de hex invalide");
                      assertNotNull(
                              exceptionHex.getMessage(),
                              "Message d'exception manquant pour une valeur de hex invalide");
                      assertTrue(
                              exceptionHex.getMessage().contains(HEX_CODE_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de hex invalide");
                  },
                  () -> {
                      IllegalArgumentException exceptionHex = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color("#G58D35"),
                              "Exception non lancée pour une valeur de hex invalide");
                      assertNotNull(
                              exceptionHex.getMessage(),
                              "Message d'exception manquant pour une valeur de hex invalide");
                      assertTrue(
                              exceptionHex.getMessage().contains(HEX_CODE_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de hex invalide");
                  },
                  () -> {
                      IllegalArgumentException exceptionHex = assertThrows(
                              IllegalArgumentException.class,
                              () -> new Color("#D108D35"),
                              "Exception non lancée pour une valeur de hex invalide");
                      assertNotNull(
                              exceptionHex.getMessage(),
                              "Message d'exception manquant pour une valeur de hex invalide");
                      assertTrue(
                              exceptionHex.getMessage().contains(HEX_CODE_INVALID_ERROR_MESSAGE),
                              "Message d'exception incorrect pour une valeur de hex invalide");
                  }
        );
    }
}
