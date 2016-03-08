package it.lisik.domainutils.ein;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class EINType extends AbstractSingleColumnStandardBasicType<EIN> implements DiscriminatorType<EIN> {
    public EINType() {
        super(VarcharTypeDescriptor.INSTANCE, EINTypeDescriptor.INSTANCE);
    }

    public EIN stringToObject(String xml) throws Exception {
        return new EIN(xml);
    }

    public String objectToSQLString(EIN value, Dialect dialect) throws Exception {
        return '\'' + value.getValue() + '\'';
    }

    public String getName() {
        return "ein";
    }
}

