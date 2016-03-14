package it.lisik.domainutils.phonenumber

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class PhoneNumberMixinTest {
    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/{
          "name": "Karol",
          "phoneNumber": "+1-202-555-0191"
    }/$

    @Before
    def void setUp() {
        mapper.addMixIn(PhoneNumber, PhoneNumberMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.phoneNumber.value, is(equalTo("+12025550191")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject("Karol", new PhoneNumber("+1-202-555-0191"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);

        assertThat(deserializationResult.phoneNumber.value, is(equalTo("+12025550191")))
    }


    static class ExampleObject {
        def String name;
        def PhoneNumber phoneNumber;

        ExampleObject(@JsonProperty("name") String name, @JsonProperty("phoneNumber") PhoneNumber phoneNumber) {
            this.name = name
            this.phoneNumber = phoneNumber
        }
    }
}