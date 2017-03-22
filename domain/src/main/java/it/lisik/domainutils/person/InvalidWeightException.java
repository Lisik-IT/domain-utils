package it.lisik.domainutils.person;

import it.lisik.domainutils.DomainException;

public class InvalidWeightException extends DomainException {
    public InvalidWeightException() {
        super("Weight has to be positive number");
    }
}
