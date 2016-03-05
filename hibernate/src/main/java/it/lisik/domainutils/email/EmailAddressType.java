package it.lisik.domainutils.email;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class EmailAddressType extends AbstractSingleColumnStandardBasicType<EmailAddress> implements DiscriminatorType<EmailAddress> {
    public EmailAddressType() {
        super(VarcharTypeDescriptor.INSTANCE, EmailAddressTypeDescriptor.INSTANCE);
    }

    public String getName() {
        return "emailaddress";
    }

    public EmailAddress stringToObject(String xml) throws Exception {
        return new EmailAddress(xml);
    }

    public String objectToSQLString(EmailAddress value, Dialect dialect) throws Exception {
        return '\'' + value.getValue() + '\'';    }
}
