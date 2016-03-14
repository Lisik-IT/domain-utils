package it.lisik.domainutils.phonenumber;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public abstract class PhoneNumberMixin {
    PhoneNumberMixin(@JsonProperty String phoneNumber) {}

    @JsonValue abstract String getValue();
}
