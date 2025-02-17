package io.gabrielsalesls.banking.users.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Data
@Table(name = "banking_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 255)
    @Column(length = 255, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Column(unique=true)
    @CPF
    private String cpf;

    @NotBlank
    @NotNull
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(unique=true)
    private String email;

    //TODO: Trocar para ENUM
    @NotNull
    @Column(nullable = false, length = 10)
    private String status = "INATIVO";


}
