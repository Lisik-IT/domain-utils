package it.lisik.domainutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.lisik.domainutils.email.EmailAddress;

import java.io.IOException;

public class EmailAddressSerializer extends JsonSerializer<EmailAddress> {
    public void serialize(EmailAddress emailAddress, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(emailAddress.getValue());
    }

    @Override
    public Class<EmailAddress> handledType() {
        return EmailAddress.class;
    }
}
