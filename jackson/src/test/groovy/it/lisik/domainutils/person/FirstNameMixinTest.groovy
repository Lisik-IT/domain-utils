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

class FirstNameMixinTest {
    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/{\u000A  "firstName": "Karol",\u000A  "emailAddress": "carol@vatican.va"\u000A}/$

    @Before
    def void setUp() {
        mapper.addMixIn(FirstName, FirstNameMixin);
        mapper.addMixIn(EmailAddress, EmailAddressMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.name.value, is(equalTo("Karol")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject(new FirstName("Karol"), new EmailAddress("carol@vatican.va"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);

        assertThat(deserializationResult.name.value, is(equalTo("Karol")))
    }


    static class ExampleObject {
        def FirstName name;
        def EmailAddress emailAddress;

        ExampleObject(@JsonProperty("firstName") FirstName name, @JsonProperty("emailAddress") EmailAddress emailAddress) {
            this.name = name
            this.emailAddress = emailAddress
        }
    }
}