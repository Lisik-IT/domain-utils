package it.lisik.domainutils.person;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class FirstNameType extends AbstractSingleColumnStandardBasicType<FirstName> implements DiscriminatorType<FirstName> {
    public FirstNameType() {
        super(VarcharTypeDescriptor.INSTANCE, FirstNameTypeDescriptor.INSTANCE);
    }

    public FirstName stringToObject(String xml) throws Exception {
        return new FirstName(xml);
    }

    public String objectToSQLString(FirstName value, Dialect dialect) throws Exception {
        return '\'' + value.getValue() + '\'';
    }

    public String getName() {
        return "firstname";
    }
}
