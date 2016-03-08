package it.lisik.domainutils.ssn;

import it.lisik.domainutils.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSN implements ValueObject<String> {
    private final static Pattern PATTERN = Pattern.compile("^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$");
    private String value;

    private SSN() {}

    public SSN(String value) {
        setValue(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        final Matcher matcher = PATTERN.matcher(value);

        if (!matcher.matches()) {
            throw new SSNNotValidException(value);
        }

        this.value = value;
    }
}
