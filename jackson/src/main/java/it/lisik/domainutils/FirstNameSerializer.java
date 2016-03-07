package it.lisik.domainutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.lisik.domainutils.person.FirstName;

import java.io.IOException;

public class FirstNameSerializer extends JsonSerializer<FirstName> {
    public void serialize(FirstName firstName, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(firstName.getValue());
    }
}
