package it.lisik.domainutils.person

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import it.lisik.domainutils.email.EmailAddress
import it.lisik.domainutils.email.EmailAddressMixin
import org.intellij.lang.annotations.Language
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

public class LastNameMixinTest {
    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/{\u000A  "lastName": "Wojtyła",\u000A  "emailAddress": "carol@vatican.va"\u000A}/$

    @Before
    def void setUp() {
        mapper.addMixIn(LastName, LastNameMixin);
        mapper.addMixIn(EmailAddress, EmailAddressMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.lastName.value, is(equalTo("Wojtyła")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject(new LastName("Wojtyła"), new EmailAddress("carol@vatican.va"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);

        assertThat(deserializationResult.lastName.value, is(equalTo("Wojtyła")))
    }


    static class ExampleObject {
        def LastName lastName;
        def EmailAddress emailAddress;

        ExampleObject(@JsonProperty("lastName") LastName lastName, @JsonProperty("emailAddress") EmailAddress emailAddress) {
            this.lastName = lastName
            this.emailAddress = emailAddress
        }
    }
}