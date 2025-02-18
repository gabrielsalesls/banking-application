package io.gabrielsalesls.banking.users.controller;

import io.gabrielsalesls.banking.users.dto.UserDTO;
import io.gabrielsalesls.banking.users.service.UserService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    //TODO: Edit User
    //TODO: Soft Delete User
    //TODO: Find by Email

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping
    public UserDTO findByCpf(@RequestParam String cpf) {
        return userService.findByCPF(cpf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long id) {
        userService.delete(id);
    }
}
