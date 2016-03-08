package it.lisik.domainutils.phonenumber;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class PhoneNumberType extends AbstractSingleColumnStandardBasicType<PhoneNumber> implements DiscriminatorType<PhoneNumber> {
    public PhoneNumberType() {
        super(VarcharTypeDescriptor.INSTANCE, PhoneNumberTypeDescriptor.INSTANCE);
    }

    public String getName() {
        return "phonenumber";
    }

    public PhoneNumber stringToObject(String xml) throws Exception {
        return new PhoneNumber(xml);
    }

    public String objectToSQLString(PhoneNumber value, Dialect dialect) throws Exception {
        return '\'' + value.getValue() + '\'';    }
}
