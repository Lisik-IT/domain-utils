package it.lisik.domainutils.person;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class LastNameType extends AbstractSingleColumnStandardBasicType<LastName> implements DiscriminatorType<LastName> {
    public LastNameType() {
        super(VarcharTypeDescriptor.INSTANCE, LastNameTypeDescriptor.INSTANCE);
    }

    public LastName stringToObject(String xml) throws Exception {
        return new LastName(xml);
    }

    public String objectToSQLString(LastName value, Dialect dialect) throws Exception {
        return '\'' + value.getValue() + '\'';
    }

    public String getName() {
        return "LastName";
    }
}
