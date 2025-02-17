package io.gabrielsalesls.banking.users.service;


import io.gabrielsalesls.banking.users.dto.UserDTO;
import io.gabrielsalesls.banking.users.dto.mapper.UserMapper;
import io.gabrielsalesls.banking.users.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO findByCPF(@Valid @NotNull @CPF String cpf) {
        return userMapper.toDTO(userRepository.findByCpf(cpf));
    }

    public UserDTO save(@Valid @NotNull UserDTO userDto) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDto)));
    }
}
