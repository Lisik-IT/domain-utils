package it.lisik.domainutils.ssn;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class SSNType extends AbstractSingleColumnStandardBasicType<SSN> implements DiscriminatorType<SSN> {
    public SSNType() {
        super(VarcharTypeDescriptor.INSTANCE, SSNTypeDescriptor.INSTANCE);
    }

    public SSN stringToObject(String xml) throws Exception {
        return new SSN(xml);
    }

    public String objectToSQLString(SSN value, Dialect dialect) throws Exception {
        return '\'' + value.getValue() + '\'';
    }

    public String getName() {
        return "ssn";
    }
}

