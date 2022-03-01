package color.model;

public class Color {

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

}
