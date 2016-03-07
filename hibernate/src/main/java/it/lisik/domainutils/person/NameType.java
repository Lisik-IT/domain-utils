package it.lisik.domainutils.person;

import org.jadira.usertype.spi.shared.AbstractMultiColumnUserType;
import org.jadira.usertype.spi.shared.ColumnMapper;

public class NameType extends AbstractMultiColumnUserType<Name> {
    private static final String[] PROPERTY_NAMES = new String[]{"first_name", "last_name"};


    @Override
    protected ColumnMapper<?, ?>[] getColumnMappers() {
        return new ColumnMapper<?, ?>[]{
                new FirstNameColumnMapper(),
                new LastNameColumnMapper()
        };
    }

    @Override
    protected Name fromConvertedColumns(Object[] convertedColumns) {
        return new Name((FirstName) convertedColumns[0], (LastName) convertedColumns[1]);
    }

    @Override
    protected Object[] toConvertedColumns(Name value) {
        return new Object[]{
                value.getFirstName(),
                value.getLastName()
        };
    }

    @Override
    public String[] getPropertyNames() {
        return PROPERTY_NAMES;
    }
}
