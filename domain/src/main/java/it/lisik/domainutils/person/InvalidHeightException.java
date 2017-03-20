package it.lisik.domainutils.person;

import it.lisik.domainutils.DomainException;

public class InvalidHeightException extends DomainException {

    public InvalidHeightException() {
        super("Height has to be positive number");
    }
}
