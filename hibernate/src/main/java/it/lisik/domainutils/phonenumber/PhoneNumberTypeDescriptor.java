package it.lisik.domainutils.phonenumber;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class PhoneNumberTypeDescriptor extends AbstractTypeDescriptor<PhoneNumber> {
    public final static PhoneNumberTypeDescriptor INSTANCE = new PhoneNumberTypeDescriptor();

    public PhoneNumberTypeDescriptor() {
        super(PhoneNumber.class);
    }

    public String toString(PhoneNumber value) {
        return value.getValue();
    }

    public PhoneNumber fromString(String string) {
        return new PhoneNumber(string);
    }

    public <X> X unwrap(PhoneNumber value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    public <X> PhoneNumber wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }
}
