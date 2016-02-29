package it.lisik.domainutils.email;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EmailAddressTest {
    @Test
    public void testValidEmailAddress() {
        final EmailAddress emailAddress = new EmailAddress("mateusz@lisik.it");
        assertThat(emailAddress.getAddress(), is(equalTo("mateusz@lisik.it")));
    }

    @Test(expected = EmailAddressNotValidException.class)
    public void testInvalidEmailAddress() {
        new EmailAddress("michal@bialek");
    }

}