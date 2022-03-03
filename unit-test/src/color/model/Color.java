package color.model;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    // Constantes de format des valeurs
    final static short RGB_INFERIOR_LIMIT = 0;
    final static short RGB_SUPERIOR_LIMIT = 255;
    final static String HEX_DOUBLE_DIGIT_REGEX_PATTERN = "([0-9a-fA-F]{2}+)";
    final static Pattern HEX_CODE_REGEX_PATTERN = Pattern.compile(
            "#" + String.join("", Collections.nCopies(3, HEX_DOUBLE_DIGIT_REGEX_PATTERN)));

    // Messages d'erreur
    final static String RGB_INVALID_ERROR_MESSAGE = "La valeur d'une couleur doit être comprise entre 0 et 255";
    final static String HEX_DIGIT_ERROR_MESSAGE = "Valeur hex incorrecte (doit être deux caractères 0-9 ou A-F)";
    final static String HEX_CODE_INVALID_ERROR_MESSAGE =
            "Le code hexadecimal entré est incorrect. Il doit être de la forme "
                    + "'#xxxxxx' où 'xx' est un chiffre hexadécimal compris entre 0 et 9 "
                    + "ou A, B, C, D, E, F";

    // Dictionnaires de conversion RGB / hexadecimal
    final static Hashtable<String, Integer> hexToRGBDictionary;
    final static Hashtable<Integer, String> RGBToHexDictionary;

    // Initialisation des dictionnaires
    static {
        hexToRGBDictionary = new Hashtable<>();

        for (int i = 0 ; i < 10; i++) {
            hexToRGBDictionary.put(Integer.toString(i), i);
        }
        hexToRGBDictionary.put("A", 10);
        hexToRGBDictionary.put("B", 11);
        hexToRGBDictionary.put("C", 12);
        hexToRGBDictionary.put("D", 13);
        hexToRGBDictionary.put("E", 14);
        hexToRGBDictionary.put("F", 15);

        RGBToHexDictionary = new Hashtable<>();
        for (Map.Entry<String, Integer> entry : hexToRGBDictionary.entrySet()){
            RGBToHexDictionary.put(entry.getValue(), entry.getKey());
        }
    }

    // Attributs de la classe;
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    // Constructeurs

    public Color(int red, int green, int blue) throws IllegalArgumentException {
        if (!rgbValueIsValid(red) || !rgbValueIsValid(green) || !rgbValueIsValid(blue))
        {
            throw new IllegalArgumentException(RGB_INVALID_ERROR_MESSAGE);
        } else {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.hexValue = rgbCodeToHexidacemalCode(red, green, blue);
        }
    }

    public Color(String hexValue) throws IllegalArgumentException {
        this.setHexValue(hexValue);
    }

    // Getters

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getHexValue() {
        return hexValue;
    }

    // Setters

    public void setRed(int red) throws IllegalArgumentException {
        if (rgbValueIsValid(red)) {
            this.red = red;
            this.hexValue = rgbCodeToHexidacemalCode(red, this.green, this.blue);
        } else {
            throw new IllegalArgumentException(RGB_INVALID_ERROR_MESSAGE);
        }
    }

    public void setGreen(int green) throws IllegalArgumentException {
        if (rgbValueIsValid(green)) {
            this.green = green;
            this.hexValue = rgbCodeToHexidacemalCode(this.red, green, this.blue);
        } else {
            throw new IllegalArgumentException(RGB_INVALID_ERROR_MESSAGE);
        }
    }

    public void setBlue(int blue) throws IllegalArgumentException {
        if (rgbValueIsValid(blue)) {
            this.blue = blue;
            this.hexValue = rgbCodeToHexidacemalCode(this.red, this.green, blue);
        } else {
            throw new IllegalArgumentException(RGB_INVALID_ERROR_MESSAGE);
        }
    }

    public void setHexValue(String hexValue) throws IllegalArgumentException{
        Matcher matcher = HEX_CODE_REGEX_PATTERN.matcher(hexValue);
        boolean hexadecimalInputIsCorrect = matcher.matches();
        if (hexadecimalInputIsCorrect) {
            // group(0) = whole pattern
            this.red = hexDoubleDigitToRGBValue(matcher.group(1));
            this.green = hexDoubleDigitToRGBValue(matcher.group(2));
            this.blue = hexDoubleDigitToRGBValue(matcher.group(3));
            this.hexValue = hexValue;
        } else {
            throw new IllegalArgumentException(HEX_CODE_INVALID_ERROR_MESSAGE);
        }
    }

    // Méthodes privées de conversion

    /**
     * Méthode privée pour retourner la valeur en RGB d'un des groupes d'un triplet hexadécimal
     *
     * [source](https://www.developintelligence.com/blog/2017/02/rgb-to-hex-understanding-the-major-web-color-codes/)
     * @param hexDoubleDigitInputValue     Deux chiffres hexadécimaux
     * @return                  Le chiffre RGB correspondant
     * @throws IllegalArgumentException     lorsque la valeur entrée n'est pas valide
     */
    private int hexDoubleDigitToRGBValue(String hexDoubleDigitInputValue) throws IllegalArgumentException {
        final Pattern hexadecimalValidPattern = Pattern.compile("[A-Fa-f0-9]{2}+");
        Matcher validMatcher = hexadecimalValidPattern.matcher(hexDoubleDigitInputValue);
        boolean inputIsValid = validMatcher.matches();

        if (inputIsValid) {
            String firstDigit = hexDoubleDigitInputValue.substring(0, 1).toUpperCase();
            String secondDigit = hexDoubleDigitInputValue.substring(1, 2).toUpperCase();
            return hexToRGBDictionary.get(firstDigit) * 16 + hexToRGBDictionary.get(secondDigit);
        } else {
            throw new IllegalArgumentException(HEX_DIGIT_ERROR_MESSAGE);
        }
    }

    private String rgbCodeToHexidacemalCode(int red, int green, int blue) throws IllegalArgumentException {
        return '#'
                + oneRGBValueToHexTwoDigits(red)
                + oneRGBValueToHexTwoDigits(green)
                + oneRGBValueToHexTwoDigits(blue);
    }

    private String oneRGBValueToHexTwoDigits(int rgbValue) throws IllegalArgumentException {
        if (rgbValueIsValid(rgbValue)) {
            int decimalPart = rgbValue / 16;
            int remainderPart = rgbValue % 16;
            return RGBToHexDictionary.get(decimalPart) + RGBToHexDictionary.get(remainderPart);
        } else {
            throw new IllegalArgumentException("La valeur de la composante RGB est invalide");
        }
    }

    private boolean rgbValueIsValid(int rgbValue) {
        return rgbValue >= RGB_INFERIOR_LIMIT && rgbValue <= RGB_SUPERIOR_LIMIT;
    }

}
