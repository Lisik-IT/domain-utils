package it.lisik.domainutils.hibernate;

import it.lisik.domainutils.ValueObject;
import org.hibernate.HibernateException;
import org.hibernate.engine.jdbc.CharacterStream;
import org.hibernate.engine.jdbc.internal.CharacterStreamImpl;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.DataHelper;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.java.MutabilityPlan;

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.sql.Clob;
import java.util.Comparator;

public class GenericSingleParameterTypeDescriptor<T> implements JavaTypeDescriptor<T> {
    private final Class<? extends ValueObject> clazz;

    public GenericSingleParameterTypeDescriptor(Class<? extends ValueObject> clazz) {
        this.clazz = clazz;
    }

    public Class getJavaTypeClass() {
        return clazz;
    }

    public MutabilityPlan getMutabilityPlan() {
        return new ImmutableMutabilityPlan();
    }

    public Comparator getComparator() {
        return null;
    }

    public int extractHashCode(Object value) {
        return 0;
    }

    public boolean areEqual(Object one, Object another) {
        return false;
    }

    public String extractLoggableRepresentation(Object value) {
        return value.toString();
    }

    public String toString(Object value) {
        return ((ValueObject<String>) value).getValue();
    }

    public T fromString(String string) {
        try {
            return (T) clazz.getConstructor(String.class).newInstance(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <X> X unwrap(T value, Class<X> type, WrapperOptions options) {
        ValueObject<String> vo = (ValueObject) value;

        if (value == null) {
            return null;
        }
        if (String.class.isAssignableFrom(type)) {
            return (X) value;
        }
        if (Reader.class.isAssignableFrom(type)) {
            return (X) new StringReader(vo.getValue());
        }
        if (CharacterStream.class.isAssignableFrom(type)) {
            return (X) new CharacterStreamImpl(vo.getValue());
        }
        if (Clob.class.isAssignableFrom(type)) {
            return (X) options.getLobCreator().createClob(vo.getValue());
        }
        if (DataHelper.isNClob(type)) {
            return (X) options.getLobCreator().createNClob(vo.getValue());
        }

        throw new HibernateException(
                "Unknown wrap conversion requested: " + value.getClass().getName() + " to " + type.getName()
        );
    }


    public Object wrap(Object value, WrapperOptions options) {
        final Constructor<? extends ValueObject> constructor;

        try {
            constructor = clazz.getConstructor(String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        try {
            return constructor.newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
