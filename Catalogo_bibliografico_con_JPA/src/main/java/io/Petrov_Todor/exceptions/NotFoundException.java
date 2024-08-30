package io.Petrov_Todor.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String record) {
        super("Il record " + record + "non è stato trovato");
    }
}
