package com.nitin.user.service.implementation;

import com.nitin.user.exception.NoDataFoundException;
import com.nitin.user.model.User;
import com.nitin.user.repository.UserRepository;
import com.nitin.user.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return Optional.ofNullable(userRepository.getUserById(id)).orElseThrow(() -> new NoDataFoundException("User not found!"));
    }

    @Transactional
    @Override
    public String updateUserById(Long id, User user) {
        User userToUpdate = Optional.ofNullable(userRepository.getUserById(id)).orElseThrow(() -> new NoDataFoundException("User not found!"));

        if (userToUpdate != null && !checkDuplicateUserBeforeUpdating(user.getUsername())) {
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRole(user.getRole());
            return "User updated successfully!";
        } else
            return "Username already exist!";
    }

    @Transactional
    private boolean checkDuplicateUserBeforeUpdating(String username) {
        return Optional.ofNullable(userRepository.getUserByUsername(username.trim())).isPresent();
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User saved successfully!";
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully!";
    }
}
