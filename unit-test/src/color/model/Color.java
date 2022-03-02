package color.model;

import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Color {

    // TODO constantes pour les valeurs inférieures et supérieures (0 et 255)

    final static Pattern hexadecimalRegexPattern = Pattern.compile(
            "#"
            + "([0-9a-fA-F]{2}+)"
            + "([0-9a-fA-F]{2}+)"
            + "([0-9a-fA-F]{2}+)");
    final static Hashtable<String, Integer> hexToRGBDictionary;
    final static Hashtable<Integer, String> RGBToHexDictionary;

    static {
        hexToRGBDictionary = new Hashtable<>();

        hexToRGBDictionary.put("0", 0);
        hexToRGBDictionary.put("1", 1);
        hexToRGBDictionary.put("2", 2);
        hexToRGBDictionary.put("3", 3);
        hexToRGBDictionary.put("4", 4);
        hexToRGBDictionary.put("5", 5);
        hexToRGBDictionary.put("6", 6);
        hexToRGBDictionary.put("7", 7);
        hexToRGBDictionary.put("8", 8);
        hexToRGBDictionary.put("9", 9);
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

    private int red;
    private int green;
    private int blue;
    private String hexadecimalCode;

    public Color(int red, int green, int blue) throws IllegalArgumentException {
        if (!rgbValueIsValid(red) || !rgbValueIsValid(green) || !rgbValueIsValid(blue))
        {
            throw new IllegalArgumentException("La valeur d'une couleur doit être comprise entre 0 et 255");
        } else {
            try {
                this.red = red;
                this.green = green;
                this.blue = blue;
                this.hexadecimalCode = rgbCodeToHexidacemalCode(red, green, blue);
            } catch(IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public Color(String hexadecimalCode) {
        Matcher matcher = hexadecimalRegexPattern.matcher(hexadecimalCode);
        boolean hexadecimalInputIsCorrect = matcher.matches();
        if (!hexadecimalInputIsCorrect) {
            throw new IllegalArgumentException(
                    "Le code hexadecimal entré est incorrect. "
                  + "Il doit être de la forme "
                  + "'#xxxxxx' où 'xx' est un chiffre hexadécimal compris entre 0 et 9 "
                  + "ou A, B, C, D, E, F");
        } else {
            try {
                // group(0) = whole pattern
                this.red = hexToRGBValue(matcher.group(1));
                this.green = hexToRGBValue(matcher.group(2));
                this.blue = hexToRGBValue(matcher.group(3));
                this.hexadecimalCode = hexadecimalCode;
            } catch(IllegalArgumentException e) {
                throw e;
            }
        }
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getHexadecimalCode() {
        return hexadecimalCode;
    }

    /**
     * Méthode privée pour retourner la valeur en RGB d'un des groupes d'un triplet hexadécimal
     *
     * [source](https://www.developintelligence.com/blog/2017/02/rgb-to-hex-understanding-the-major-web-color-codes/)
     * @param hexInputValue     Deux chiffres hexadécimaux
     * @return                  Le chiffre RGB correspondant
     * @throws IllegalArgumentException     lorsque la valeur entrée n'est pas valide
     */
    private int hexToRGBValue(String hexInputValue) throws IllegalArgumentException {
        final Pattern hexadecimalValidPattern = Pattern.compile("[A-Fa-f0-9]{2}+");
        Matcher validMatcher = hexadecimalValidPattern.matcher(hexInputValue);
        boolean inputIsValid = validMatcher.matches();

        if (!inputIsValid) {
            throw new IllegalArgumentException("Invalid hex value (must be two digits like 0-9 or A-F)");
        } else {
            String firstDigit = hexInputValue.substring(0, 1);
            String secondDigit = hexInputValue.substring(1, 2);

            int rgbValue = hexToRGBDictionary.get(firstDigit) * 16 + hexToRGBDictionary.get(secondDigit);

            return rgbValue;
        }
    }

    private String rgbCodeToHexidacemalCode(int red, int green, int blue) throws IllegalArgumentException {
        try {
            return '#'
                    + oneRGBValueToHexTwoDigits(red)
                    + oneRGBValueToHexTwoDigits(green)
                    + oneRGBValueToHexTwoDigits(blue);
        } catch(IllegalArgumentException e) {
            throw e;
        }
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
        return rgbValue >= 0 && rgbValue <= 255;
    }

}
