package me.splitque.menu.exceptions;

public class InaccessibleMethodException extends RuntimeException {
    public InaccessibleMethodException() {
        super("This method cannot be used with this class settings");
    }
}
