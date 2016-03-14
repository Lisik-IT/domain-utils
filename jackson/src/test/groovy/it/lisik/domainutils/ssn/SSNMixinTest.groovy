package it.lisik.domainutils.ssn

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class SSNMixinTest {

    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/{
          "name": "Karol",
          "ssn": "259-53-4969"
    }/$

    @Before
    def void setUp() {
        mapper.addMixIn(SSN, SSNMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.ssn.value, is(equalTo("259-53-4969")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject("Karol", new SSN("259-53-4969"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);

        assertThat(deserializationResult.ssn.value, is(equalTo("259-53-4969")))
    }


    static class ExampleObject {
        def String name;
        def SSN ssn;

        ExampleObject(@JsonProperty("name") String name, @JsonProperty("SSN") SSN ssn) {
            this.name = name
            this.ssn = ssn
        }
    }

}