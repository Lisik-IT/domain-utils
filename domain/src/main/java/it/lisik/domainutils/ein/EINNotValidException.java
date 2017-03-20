package it.lisik.domainutils.ein;

import it.lisik.domainutils.DomainException;

public class EINNotValidException extends DomainException {
    public EINNotValidException(String ein) {
        super("EIN \""+ein+"\" is not valid!");
    }
}
