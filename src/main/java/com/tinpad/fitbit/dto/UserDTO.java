package com.tinpad.fitbit.dto;

import com.tinpad.fitbit.entities.User;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class UserDTO {

    private String userID;

    private String username;

    private String email;

    private String passwordHash;

    private Date registeredAt;

    private Date lastLogin;

    public UserDTO() {
    }

    public UserDTO(User user) {
        setUserID(user.getUserID());
        setUsername(user.getUsername());
        setEmail(user.getEmail());
        setPasswordHash(user.getPasswordHash());
        setRegisteredAt(user.getRegisteredAt());
        setLastLogin(user.getLastLogin());
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        if (userID != null && userID.length() == 9) {
            this.userID = userID;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        List<Character> allowedChars = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '_', '-', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '@', '!', '~', '#', '$'
        );
        for (int i = 0; i < username.length(); i++) {
            if (!allowedChars.contains(username.charAt(i))) {
                return;
            }
        }
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //add a check
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(@NotNull String passwordHash) {
        if (passwordHash.length() >= 8) {
            this.passwordHash = passwordHash;
        }
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

}
