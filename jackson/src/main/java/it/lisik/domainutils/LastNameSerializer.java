package it.lisik.domainutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.lisik.domainutils.person.LastName;

import java.io.IOException;

public class LastNameSerializer extends JsonSerializer<LastName> {
    public void serialize(LastName lastName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(lastName.getValue());
    }
}
