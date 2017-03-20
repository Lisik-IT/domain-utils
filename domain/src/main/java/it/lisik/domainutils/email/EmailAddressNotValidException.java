package it.lisik.domainutils.email;

import it.lisik.domainutils.DomainException;

public class EmailAddressNotValidException extends DomainException {

    public EmailAddressNotValidException(String address) {
        super("Email address \" " + address + "\" is not valid!");
    }
}
