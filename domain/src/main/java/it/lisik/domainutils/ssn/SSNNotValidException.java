package it.lisik.domainutils.ssn;

import it.lisik.domainutils.DomainException;

public class SSNNotValidException extends DomainException {
    public SSNNotValidException(String ssn) {
        super("SSN \""+ssn+"\" is not valid!");
    }
}
