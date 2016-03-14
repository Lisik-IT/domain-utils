package it.lisik.domainutils.ein

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.intellij.lang.annotations.Language
import org.junit.Before
import org.junit.Test

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat

class EINMixinTest {
    final ObjectMapper mapper = new ObjectMapper();
    @Language("JSON")
    public static final json = $/{
          "name": "Karol",
          "ssn": "55-1234567"
    }/$

    @Before
    def void setUp() {
        mapper.addMixIn(EIN, EINMixin);
    }

    @Test
    def void testDeserialization() {
        def value = mapper.readValue(json, ExampleObject);
        assertThat(value.ein.value, is(equalTo("55-1234567")))
    }

    @Test
    def void testSerialization() {
        def object = new ExampleObject("Karol", new EIN("55-1234567"))

        def serializedValue = mapper.writeValueAsString(object);
        def deserializationResult = mapper.readValue(serializedValue, ExampleObject);
        
        assertThat(deserializationResult.ein.value, is(equalTo("55-1234567")))
    }


    static class ExampleObject {
        def String name;
        def EIN ein;

        ExampleObject(@JsonProperty("name") String name, @JsonProperty("ssn") EIN ein) {
            this.name = name
            this.ein = ein
        }
    }
}
