package io.gabrielsalesls.banking.users.controller;

import io.gabrielsalesls.banking.users.dto.UserDTO;
import io.gabrielsalesls.banking.users.dto.UserEditRequestDTO;
import io.gabrielsalesls.banking.users.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping("/searchByCpf")
    public UserDTO findByCpf(@RequestParam String cpf) {
        return userService.findByCPF(cpf);
    }

    @GetMapping("/searchByEmail")
    public UserDTO findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @NotNull @Positive Long id) {
        userService.delete(id);
    }

    @PatchMapping("/{id}")
    public UserDTO update(@PathVariable @Positive @NotNull Long id,
                          @RequestBody @Valid UserEditRequestDTO userEditRequestDTO) {
        return userService.edit(id, userEditRequestDTO);
    }
}
