package it.lisik.domainutils.hibernate;

import it.lisik.domainutils.ValueObject;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;
import org.jadira.usertype.spi.shared.AbstractColumnMapper;

import java.sql.Types;

public abstract class StringValueObjectColumnMapper extends AbstractColumnMapper<ValueObject<String>, String> {

    public final StringType getHibernateType() {
        return StandardBasicTypes.STRING;
    }

    public final int getSqlType() {
        return Types.VARCHAR;
    }

    public abstract ValueObject<String> fromNonNullValue(String s);

    public final ValueObject<String> fromNonNullString(String s) {
        return fromNonNullValue(s);
    }

    public String toNonNullValue(ValueObject<String> value) {
        return value.getValue();
    }

    public String toNonNullString(ValueObject<String> value) {
        return toNonNullValue(value);
    }

}
