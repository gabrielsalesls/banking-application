package io.gabrielsalesls.banking.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public record UserDTO(

        Long id,
        @NotBlank @NotNull @Length(min = 5, max = 255) String name,
        @NotNull @NotBlank @CPF String cpf,
        @NotBlank @NotNull @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email
) {
}
