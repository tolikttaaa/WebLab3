import controllers.ControllerBean;
import models.Dot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerBeanTest {
    private final ControllerBean controller = new ControllerBean();
    private final static String className = Dot.class.getName();

    @Test
    public void resetBean() {
        assertEquals(0.0f, controller.getX(), 0.00001f);
        assertEquals("0", controller.getY());
        assertEquals("1", controller.getR());
        assertEquals("", controller.getResult());
    }
}