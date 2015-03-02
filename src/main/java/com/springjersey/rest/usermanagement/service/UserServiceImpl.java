package com.springjersey.rest.usermanagement.service;

import com.springjersey.rest.usermanagement.entity.User;
import com.springjersey.rest.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.userRepository = repo;
    }
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    
    @Override
    public void deleteUserById(long id) {
        userRepository.delete(id);
    }

    @Override
    public User readByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(User userToUpdate) {
        return userRepository.save(userToUpdate);
    }

    @Override
    public User readUser(String name) {
        return userRepository.findByName(name);
    }
    
}
