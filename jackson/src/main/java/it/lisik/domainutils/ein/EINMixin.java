package it.lisik.domainutils.ein;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class EINMixin {
    EINMixin(@JsonProperty String value) {}

    @JsonValue
    abstract String getValue();
}
