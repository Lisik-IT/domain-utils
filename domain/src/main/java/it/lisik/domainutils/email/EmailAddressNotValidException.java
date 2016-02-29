package it.lisik.domainutils.email;

public class EmailAddressNotValidException extends RuntimeException {

    public EmailAddressNotValidException(String address) {
        super("Email address \" " + address + "\" is not valid!");
    }
}
