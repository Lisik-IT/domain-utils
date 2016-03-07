package it.lisik.domainutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.lisik.domainutils.person.Name;

import java.io.IOException;

public class NameSerializer extends JsonSerializer<Name> {
    public void serialize(Name name, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStringField("value", name.getValue());
        jsonGenerator.writeStringField("firstName", name.getFirstName().getValue());
        jsonGenerator.writeStringField("lastName", name.getLastName().getValue());
    }
}
