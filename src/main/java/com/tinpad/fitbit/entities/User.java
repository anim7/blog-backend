package com.tinpad.fitbit.entities;

import com.tinpad.fitbit.dto.UserDTO;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GenericGenerator(name = "user_id", strategy = "com.tinpad.fitbit.generators.UserIDGenerator")
    @GeneratedValue(generator = "user_id")
    @Column(length = 9, name = "user_id")
    private String userID;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String passwordHash;

    private Date registeredAt;

    private Date lastLogin;

    public User() {
    }

    public User(UserDTO userDTO) {
        setUserID(userDTO.getUserID());
        setUsername(userDTO.getUsername());
        setEmail(userDTO.getEmail());
        setPasswordHash(userDTO.getPasswordHash());
        setRegisteredAt(userDTO.getRegisteredAt());
        setLastLogin(userDTO.getLastLogin());
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
