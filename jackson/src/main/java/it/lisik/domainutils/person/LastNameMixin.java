package it.lisik.domainutils.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class LastNameMixin {
    LastNameMixin(@JsonProperty String lastName) {
    }

    @JsonValue
    abstract String getValue();
}
