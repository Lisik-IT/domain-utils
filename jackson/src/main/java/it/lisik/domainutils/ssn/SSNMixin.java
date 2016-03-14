package it.lisik.domainutils.ssn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class SSNMixin {
    SSNMixin(@JsonProperty String value) {
    }

    @JsonValue
    abstract String getValue();

}
