package it.lisik.domainutils.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameMixin {
    NameMixin(@JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName) {
    }


}
