package it.lisik.domainutils.phonenumber;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String phoneNumber) {
        super("Phone number \"" + phoneNumber + "\" is not valid phone number");
    }
}
