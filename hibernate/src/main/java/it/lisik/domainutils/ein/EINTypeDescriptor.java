package it.lisik.domainutils.ein;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class EINTypeDescriptor extends AbstractTypeDescriptor<EIN> {
    public final static EINTypeDescriptor INSTANCE = new EINTypeDescriptor();

    protected EINTypeDescriptor() {
        super(EIN.class);
    }

    public String toString(EIN value) {
        return value.getValue();
    }

    public EIN fromString(String string) {
        return new EIN(string);
    }

    public <X> X unwrap(EIN value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) toString(value);
        }
        throw unknownUnwrap(type);
    }

    public <X> EIN wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (String.class.isInstance(value)) {
            return fromString((String) value);
        }
        throw unknownWrap(value.getClass());
    }
}