package it.lisik.domainutils.person;

import it.lisik.domainutils.ValueObject;
import it.lisik.domainutils.hibernate.StringValueObjectColumnMapper;

public class FirstNameColumnMapper extends StringValueObjectColumnMapper {
    @Override
    public ValueObject<String> fromNonNullValue(String s) {
        return new FirstName(s);
    }
}
