package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.User;
import com.cnweb.mxh.repository.UserRepository;
import com.cnweb.mxh.repository.impl.UserRepositoryImpl;
import com.cnweb.mxh.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User insert(User user) {
        // Hash password before insert user to database
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        int id = userRepository.insert(user);
        return userRepository.findById(id);
    }

    @Override
    public User update(User user) {
        // Hash password before insert user to database
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        userRepository.update(user);
        return userRepository.findById(user.getId());
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
