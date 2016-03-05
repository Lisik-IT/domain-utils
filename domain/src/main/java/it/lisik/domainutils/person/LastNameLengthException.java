package it.lisik.domainutils.person;

import com.google.common.collect.Range;

public class LastNameLengthException extends RuntimeException {
    public LastNameLengthException(String name, Range<Integer> range) {
        super("Name \"" + name + "\" does not fit in constraint " + range.toString());
    }
}
