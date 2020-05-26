import controllers.AreaValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaValidatorTest {
    private final static String className = AreaValidator.class.getName();

    @Test
    public void checkArea() {
        assertEquals("TRUE", AreaValidator.checkArea("1", "-2", "3"));
        assertEquals("FALSE", AreaValidator.checkArea("-1", "-1", "-1"));
    }

    @Test
    public void validateX() {
        assertThrows(NumberFormatException.class, () -> AreaValidator.validateX("-3.001"));
        assertThrows(NumberFormatException.class, () -> AreaValidator.validateX("3.001"));
    }

    @Test
    public void validateY() {
        assertThrows(NumberFormatException.class, () -> AreaValidator.validateY("-5.001"));
        assertThrows(NumberFormatException.class, () -> AreaValidator.validateY("3.001"));
    }

    @Test
    public void validateR() {
        assertThrows(NumberFormatException.class, () -> AreaValidator.validateR("0.999"));
        assertThrows(NumberFormatException.class, () -> AreaValidator.validateR("4.001"));
    }
}