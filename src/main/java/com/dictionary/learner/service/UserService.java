package com.dictionary.learner.service;

import com.dictionary.learner.entity.Role;
import com.dictionary.learner.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
