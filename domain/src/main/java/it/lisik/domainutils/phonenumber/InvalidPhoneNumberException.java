package it.lisik.domainutils.phonenumber;

import it.lisik.domainutils.DomainException;

public class InvalidPhoneNumberException extends DomainException{
    public InvalidPhoneNumberException(String phoneNumber) {
        super("Phone number \"" + phoneNumber + "\" is not valid phone number");
    }
}
