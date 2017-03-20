package it.lisik.domainutils.person;

import com.google.common.collect.Range;
import it.lisik.domainutils.DomainException;

public class LastNameLengthException extends DomainException {
    public LastNameLengthException(String name, Range<Integer> range) {
        super("Name \"" + name + "\" does not fit in constraint " + range.toString());
    }
}
