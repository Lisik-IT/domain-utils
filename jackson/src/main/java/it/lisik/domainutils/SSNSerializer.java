package it.lisik.domainutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.lisik.domainutils.ssn.SSN;

import java.io.IOException;

public class SSNSerializer extends JsonSerializer<SSN> {
    public void serialize(SSN ssn, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(ssn.getValue());
    }

    @Override
    public Class<SSN> handledType() {
        return SSN.class;
    }
}
