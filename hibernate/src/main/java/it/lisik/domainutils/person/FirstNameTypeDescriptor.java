package it.lisik.domainutils.person;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class FirstNameTypeDescriptor extends AbstractTypeDescriptor<FirstName> {
    public final static FirstNameTypeDescriptor INSTANCE = new FirstNameTypeDescriptor();

    public FirstNameTypeDescriptor() {
        super(FirstName.class);
    }

    public String toString(FirstName value) {
        return value.getValue();
    }

    public FirstName fromString(String string) {
        return new FirstName(string);
    }

    public <X> X unwrap(FirstName value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    public <X> FirstName wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }

}
