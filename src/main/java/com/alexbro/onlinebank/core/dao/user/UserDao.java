package com.alexbro.onlinebank.core.dao.user;

import com.alexbro.onlinebank.core.entity.user.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> getUserByLogin(String username);
}
