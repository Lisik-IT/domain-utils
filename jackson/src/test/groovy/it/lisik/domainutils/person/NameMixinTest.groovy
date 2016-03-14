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

public class NameMixinTest {
    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/
    {
      "name": {
        "firstName": "Karol",
        "lastName": "Wojtyła"
      },
      "emailAddress": "carol@vatican.va"
    }
    /$

    @Before
    def void setUp() {
        mapper.addMixIn(FirstName, FirstNameMixin);
        mapper.addMixIn(LastName, LastNameMixin);
        mapper.addMixIn(Name, NameMixin);
        mapper.addMixIn(EmailAddress, EmailAddressMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.name.getValue(), is(equalTo("Karol Wojtyła")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject(new Name("Karol", "Wojtyła"), new EmailAddress("carol@vatican.va"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);

        assertThat(deserializationResult.name.value, is(equalTo("Karol Wojtyła")))
        assertThat(deserializationResult.name.firstName.value, is(equalTo("Karol")))
        assertThat(deserializationResult.name.lastName.value, is(equalTo("Wojtyła")))
    }


    static class ExampleObject {
        def Name name;
        def EmailAddress emailAddress;

        ExampleObject(
                @JsonProperty("name") Name name, @JsonProperty("emailAddress") EmailAddress emailAddress) {
            this.name = name
            this.emailAddress = emailAddress
        }
    }
}