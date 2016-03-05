package it.lisik.domainutils.person;

import com.google.common.collect.Range;

public class FirstNameLengthException extends RuntimeException {
    public FirstNameLengthException(String name, Range<Integer> range) {
        super("Name \"" + name + "\" does not fit in constraint " + range.toString());
    }
}
