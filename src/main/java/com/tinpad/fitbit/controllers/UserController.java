package com.tinpad.fitbit.controllers;

import com.tinpad.fitbit.dto.UserDTO;
import com.tinpad.fitbit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers(@RequestParam(required = false, name = "id") String id) {
        return userService.getUsers(id);
    }

    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping
    public List<UserDTO> deleteUsers(@RequestParam(required = false, name = "id") String id) {
        return userService.deleteUsers(id);
    }

}
