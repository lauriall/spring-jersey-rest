package com.springjersey.rest.usermanagement.service;

import com.springjersey.rest.usermanagement.entity.User;

import java.util.List;

public interface UserService {
    
    public User saveUser(User user);

    public User read(long id);

    public User readUser(String name);

    public List<User> readAll();

    public User readByEmail(String email);

    public User updateUser(User userToUpdate);

    public void deleteUser(User user);

    public void deleteUserById(long id);

}
