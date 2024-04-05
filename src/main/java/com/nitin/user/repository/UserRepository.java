package com.nitin.user.repository;

import com.nitin.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    // get all users
    final static String GET_ALL_USERS = "SELECT * FROM User ORDER BY id ASC";

    @Query(value = GET_ALL_USERS, nativeQuery = true)
    public List<User> getAllUsers();

    // get user by id
    final static String GET_USER_BY_ID = "SELECT * FROM User WHERE id = ?1";

    @Query(value = GET_USER_BY_ID, nativeQuery = true)
    public User getUserById(Long id);

    // get user by username
    final static String GET_USER_BY_USERNAME = "SELECT * FROM User WHERE username = ?1";

    @Query(value = GET_USER_BY_USERNAME, nativeQuery = true)
    public User getUserByUsername(String username);

}
