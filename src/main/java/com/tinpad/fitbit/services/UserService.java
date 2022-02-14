package com.tinpad.fitbit.services;

import com.tinpad.fitbit.dto.UserDTO;
import com.tinpad.fitbit.entities.User;
import com.tinpad.fitbit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUsers(String id) {
        if(id != null) {
            return List.of(new UserDTO(userRepository.findById(id).get()));
        }
        return getUsers();
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user : users) {
            userDTOs.add(new UserDTO(user));
        }
        return userDTOs;
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        userDTO.setUserID(user.getUserID());
        return userDTO;
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userRepository.saveAndFlush(new User(userDTO));
        return userDTO;
    }

    public List<UserDTO> deleteUsers(String id) {
        if(id != null) {
            List<UserDTO> userDTO = getUsers(id);
            userRepository.deleteById(id);
            return userDTO;
        }
        return deleteUsers();
    }

    public List<UserDTO> deleteUsers() {
        List<UserDTO> userDTOs = getUsers();
        userRepository.deleteAll();
        return userDTOs;
    }

}
