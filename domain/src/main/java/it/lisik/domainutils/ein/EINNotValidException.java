package it.lisik.domainutils.ein;

public class EINNotValidException extends RuntimeException {
    public EINNotValidException(String ein) {
        super("EIN \""+ein+"\" is not valid!");
    }
}
