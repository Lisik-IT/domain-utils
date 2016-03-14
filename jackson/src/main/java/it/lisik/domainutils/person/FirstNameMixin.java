package it.lisik.domainutils.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class FirstNameMixin {
    FirstNameMixin(@JsonProperty String firstName) {

    }

    @JsonValue
    abstract String getValue();
}
