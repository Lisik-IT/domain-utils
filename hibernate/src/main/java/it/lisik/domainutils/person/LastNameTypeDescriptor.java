package it.lisik.domainutils.person;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class LastNameTypeDescriptor extends AbstractTypeDescriptor<LastName> {
    public final static LastNameTypeDescriptor INSTANCE = new LastNameTypeDescriptor();

    public LastNameTypeDescriptor() {
        super(LastName.class);
    }

    public String toString(LastName value) {
        return value.getValue();
    }

    public LastName fromString(String string) {
        return new LastName(string);
    }

    public <X> X unwrap(LastName value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    public <X> LastName wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }

}
