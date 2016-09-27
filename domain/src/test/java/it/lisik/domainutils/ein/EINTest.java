package it.lisik.domainutils.ein;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EINTest {
    private final static String formattedEin = "55-5555555";

    @Test
    public void testConstructor() {
        new EIN(formattedEin);
    }

    @Test(expected = EINNotValidException.class)
    public void testInvalidEin() {
        new EIN("invalid");
    }

    @Test
    public void testAccessors() {
        final EIN ein = new EIN(formattedEin);

        assertEquals(formattedEin, ein.getValue());
    }
}
