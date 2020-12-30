package hu.indicium.dev.mail.lib.exceptions;

public class MyFileNotFoundException extends RuntimeException {
    public MyFileNotFoundException(String message) {
        super(message);
    }
}
