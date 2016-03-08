package it.lisik.domainutils.ssn;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class SSNTypeDescriptor extends AbstractTypeDescriptor<SSN> {
    public final static SSNTypeDescriptor INSTANCE = new SSNTypeDescriptor();

    protected SSNTypeDescriptor() {
        super(SSN.class);
    }

    public String toString(SSN value) {
        return value.getValue();
    }

    public SSN fromString(String string) {
        return new SSN(string);
    }

    public <X> X unwrap(SSN value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    public <X> SSN wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }
}