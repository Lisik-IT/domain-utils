package it.lisik.domainutils.hibernate;

import it.lisik.domainutils.ValueObject;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class GenericSingleStringType implements ParameterizedType, UserType {

    private Class clazz;

    public GenericSingleStringType(Class clazz) {
        this.clazz = clazz;
    }

//    public void setParameterValues(Properties params) {
//        String className = params.getProperty("className");
//        if (className == null) {
//            throw new MappingException("className parameter not specified");
//        }
//        try {
//            this.clazz = Class.forName(className);
//        } catch (Exception e) {
//            throw new MappingException("Class " + className + " not found", e);
//        }
//
//        for (Class c : clazz.getInterfaces())
//            if (c.equals(ValueObject.class))
//                return;
//        throw new MappingException("Class " + className + " does not implement " + ValueObject.class.getCanonicalName() + ". It is a requirement for using the genericUserType");
//    }

    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    public Class returnedClass() {
        return clazz;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return x.equals(y);
    }

    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
        try {
            return clazz.getConstructor(String.class).newInstance(rs.getString(names[0]));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
        final ValueObject<String> valueObject = (ValueObject<String>) value;
        st.setString(index, valueObject.toString());
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public boolean isMutable() {
        return false;
    }

    public Serializable disassemble(Object value) throws HibernateException {
        final ValueObject<String> vo = (ValueObject<String>) value;
        return vo.getValue();
    }

    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        try {
            final Constructor constructor = clazz.getConstructor(String.class);
            return constructor.newInstance((String) cached);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    public void setParameterValues(Properties parameters) {

    }
//
//    public GenericSingleStringType(Class<? extends ValueObject> clazz) {
//        this.clazz = clazz;
//    }

}
