package it.lisik.domainutils.ssn;

import it.lisik.domainutils.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSN implements ValueObject<String> {
    private final static Pattern PATTERN = Pattern.compile("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$");
    private String value;

    public SSN(String value) {
        final Matcher matcher = PATTERN.matcher(value);

        if (!matcher.matches()) {
            throw new SSNNotValidException(value);
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
