package it.lisik.domainutils.person;

import com.google.common.collect.Range;
import it.lisik.domainutils.DomainException;

public class FirstNameLengthException extends DomainException {
    public FirstNameLengthException(String name, Range<Integer> range) {
        super("Name \"" + name + "\" does not fit in constraint " + range.toString());
    }
}
