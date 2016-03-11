package it.lisik.domainutils.ssn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SSNTest {
    private final static String ssnString = "123-45-6789";

    @Test
    public void testConstructor() {
        new SSN(ssnString);
    }

    @Test(expected = SSNNotValidException.class)
    public void testInvalidSsn() {
        new SSN("invalid");
    }

    @Test
    public void testAccessors() {
        final SSN ssn = new SSN(ssnString);

        assertEquals(ssnString, ssn.getValue());
    }
}

