package it.lisik.domainutils.phonenumber;

import com.google.common.base.Preconditions;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import it.lisik.domainutils.ValueObject;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class PhoneNumber implements ValueObject<String> {
    private final static PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();
    private String phoneNumber;

    public PhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = Preconditions.checkNotNull(phoneNumber);

        try {
            final Phonenumber.PhoneNumber parsedPhoneNumber = PHONE_NUMBER_UTIL.parse(this.phoneNumber, "US");
            this.phoneNumber = PHONE_NUMBER_UTIL.format(parsedPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
        } catch (NumberParseException e) {
            throw new InvalidPhoneNumberException(this.phoneNumber);
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("phoneNumber", phoneNumber)
                .toString();
    }

    @Override
    public String getValue() {
        return phoneNumber;
    }
}
