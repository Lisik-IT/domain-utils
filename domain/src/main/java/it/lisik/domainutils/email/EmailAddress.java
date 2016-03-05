package it.lisik.domainutils.email;

import com.google.common.base.Preconditions;
import it.lisik.domainutils.ValueObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.validator.routines.EmailValidator;
import org.jetbrains.annotations.NotNull;

public class EmailAddress implements ValueObject<String> {
    private final static EmailValidator emailValidator = EmailValidator.getInstance();
    private final String address;

    public EmailAddress(@NotNull String address) {
        address = Preconditions.checkNotNull(StringUtils.trim(address));
        this.address = address.toLowerCase();

        if (!emailValidator.isValid(this.address)) {
            throw new EmailAddressNotValidException(this.address);
        }
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String getValue() {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("address", address)
                .toString();
    }
}
