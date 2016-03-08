package it.lisik.domainutils.ein;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

public class EINTest {
    private final static String einString = "55-5555555";

    @Test
    public void testEmptyConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Constructor<EIN> constructor = EIN.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        constructor.newInstance();
    }

    @Test
    public void testConstructor() {
        new EIN(einString);
    }

    @Test(expected = EINNotValidException.class)
    public void testInvalidEin() {
        new EIN("invalid");
    }

    @Test
    public void testAccessors() {
        final EIN ein = new EIN(einString);

        assertEquals(einString, ein.getValue());
    }
}
