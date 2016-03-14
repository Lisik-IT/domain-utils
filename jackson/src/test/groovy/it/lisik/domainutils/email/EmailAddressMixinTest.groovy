package it.lisik.domainutils.email

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class EmailAddressMixinTest {
    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/{\u000A  "name": "Karol",\u000A  "emailAddress": "carol@vatican.va"\u000A}/$

    @Before
    def void setUp() {
        mapper.addMixIn(EmailAddress, EmailAddressMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.emailAddress.value, is(equalTo("carol@vatican.va")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject("Karol", new EmailAddress("carol@vatican.va"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);

        assertThat(deserializationResult.emailAddress.value, is(equalTo("carol@vatican.va")))
    }


    static class ExampleObject {
        def String name;
        def EmailAddress emailAddress;

        ExampleObject(@JsonProperty("name") String name, @JsonProperty("emailAddress") EmailAddress emailAddress) {
            this.name = name
            this.emailAddress = emailAddress
        }
    }
}