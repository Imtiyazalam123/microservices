package com.imtiyaj.service;

import com.imtiyaj.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getAllUser();

    User getUserById(Integer id);
}
