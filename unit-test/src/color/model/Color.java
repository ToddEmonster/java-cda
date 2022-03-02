package color.model;

import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {
    // TODO constantes pour les valeurs inférieures et supérieures (0 et 255)
    final static Pattern hexadecimalRegexPattern = Pattern.compile(
            "#"
            + "([0-9[a-fA-F]]{2}+)"
            + "([0-9[a-fA-F]]{2}+)"
            + "([0-9[a-fA-F]]{2}+)");
    final static Hashtable<String, Integer> hexRGBDictionary;

    static {
        hexRGBDictionary = new Hashtable<>();

        hexRGBDictionary.put("0", 0);
        hexRGBDictionary.put("1", 1);
        hexRGBDictionary.put("2", 2);
        hexRGBDictionary.put("3", 3);
        hexRGBDictionary.put("4", 4);
        hexRGBDictionary.put("5", 5);
        hexRGBDictionary.put("6", 6);
        hexRGBDictionary.put("7", 7);
        hexRGBDictionary.put("8", 8);
        hexRGBDictionary.put("9", 9);
        hexRGBDictionary.put("A", 10);
        hexRGBDictionary.put("B", 11);
        hexRGBDictionary.put("C", 12);
        hexRGBDictionary.put("D", 13);
        hexRGBDictionary.put("E", 14);
        hexRGBDictionary.put("F", 15);
    }

    public int red;
    public int green;
    public int blue;

    public Color(int red, int green, int blue) throws IllegalArgumentException {
        if (red < 0 || red > 255 ||
            green < 0 || green > 255 ||
            blue < 0 || blue > 255 )
        {
            throw new IllegalArgumentException("La valeur d'une couleur doit être comprise entre 0 et 255");
        } else {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }
    }

    public Color(String hexadecimalCode) {
        Matcher matcher = hexadecimalRegexPattern.matcher(hexadecimalCode);
        boolean inputIsCorrect = matcher.matches();
        if (!inputIsCorrect) {
            throw new IllegalArgumentException(
                    "Le code hexadecimal entré est incorrect. "
                  + "Il doit être de la forme "
                  + "'#xxxxxx' où 'xx' est un chiffre hexadécimal compris entre 0 et 9 "
                  + "ou A, B, C, D, E, F");
        } else {
            // group(0) = whole pattern
            this.red = hexToRGBValue(matcher.group(1));
            this.green = hexToRGBValue(matcher.group(2));
            this.blue = hexToRGBValue(matcher.group(3));
        }
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

            int rgbValue = hexRGBDictionary.get(firstDigit) * 16 + hexRGBDictionary.get(secondDigit);

            return rgbValue;
        }
    }
}
