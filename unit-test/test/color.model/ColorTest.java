import color.model.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorTest {

    private Color color;

    @Test
    public void testGetRed() {
        Color color = new Color(1, 1, 1);
        assertEquals(1, color.getRed(), "getRed() est incorrecte");
    }
}
