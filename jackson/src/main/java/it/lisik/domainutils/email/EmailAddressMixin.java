package it.lisik.domainutils.email;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class EmailAddressMixin {
    EmailAddressMixin(@JsonProperty String address) {}
    @JsonValue abstract String getValue();
}
