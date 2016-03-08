package it.lisik.domainutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.lisik.domainutils.ein.EIN;

import java.io.IOException;

public class EINSerializer extends JsonSerializer<EIN> {
    public void serialize(EIN ein, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(ein.getValue());
    }

    @Override
    public Class<EIN> handledType() {
        return EIN.class;
    }
}
