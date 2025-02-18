package io.gabrielsalesls.banking.users.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id) {
        super("Usuário não encontrado com o ID: " + id);
    }

}
