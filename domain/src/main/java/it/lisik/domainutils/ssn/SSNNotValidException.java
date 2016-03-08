package it.lisik.domainutils.ssn;

public class SSNNotValidException extends RuntimeException {
    public SSNNotValidException(String ssn) {
        super("SSN \""+ssn+"\" is not valid!");
    }
}
