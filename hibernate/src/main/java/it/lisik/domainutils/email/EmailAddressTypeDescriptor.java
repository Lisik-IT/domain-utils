package it.lisik.domainutils.email;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class EmailAddressTypeDescriptor extends AbstractTypeDescriptor<EmailAddress> {
    public final static EmailAddressTypeDescriptor INSTANCE = new EmailAddressTypeDescriptor();

    public EmailAddressTypeDescriptor() {
        super(EmailAddress.class);
    }

    public String toString(EmailAddress value) {
        return value.getValue();
    }

    public EmailAddress fromString(String string) {
        return new EmailAddress(string);
    }

    public <X> X unwrap(EmailAddress value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    public <X> EmailAddress wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }
}
