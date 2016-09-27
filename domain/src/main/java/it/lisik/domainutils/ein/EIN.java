package it.lisik.domainutils.ein;

import it.lisik.domainutils.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EIN implements ValueObject<String> {
    private final static Pattern PATTERN = Pattern.compile("^(0[1-9]|[1-9]\\d)-\\d{7}$");
    private final String value;

    public EIN(String value) {
        final Matcher matcher = PATTERN.matcher(value);

        if (!matcher.matches()) {
            throw new EINNotValidException(value);
        }

        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
