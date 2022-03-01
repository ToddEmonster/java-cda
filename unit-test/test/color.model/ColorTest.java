import color.model.Color;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @AfterEach
    public void throwOut() {
        this.color = null;
    }
}
