package io.gabrielsalesls.banking.users.dto.mapper;

import io.gabrielsalesls.banking.users.dto.UserDTO;
import io.gabrielsalesls.banking.users.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if(user == null) {
            return null;
        }

        return new UserDTO(user.getId(), user.getName(), user.getCpf(), user.getEmail());

    }

    public User toEntity(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }

        User user = new User();
        if(userDTO.id() != null) {
            user.setId(userDTO.id());
        }
        user.setName(userDTO.name());
        user.setCpf(userDTO.cpf());
        user.setEmail(userDTO.email());

        return user;

    }

}
