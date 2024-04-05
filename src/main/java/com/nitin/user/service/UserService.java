package com.nitin.user.service;

import com.nitin.user.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(Long id);

    public String createUser(User user);

    public String updateUserById(Long id, User user);

    public String deleteUser(Long id);
}
