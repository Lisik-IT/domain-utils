package it.lisik.domainutils.ein;

import it.lisik.domainutils.ValueObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EIN implements ValueObject<String> {
    private final static Pattern PATTERN = Pattern.compile("^(0[1-9]|[1-9]\\d)-\\d{7}$");
    private String value;

    private EIN() {}

    public EIN(String value) {
        setValue(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        final Matcher matcher = PATTERN.matcher(value);

        if (!matcher.matches()) {
            throw new EINNotValidException(value);
        }

        this.value = value;
    }
}
