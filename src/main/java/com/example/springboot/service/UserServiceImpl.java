package com.example.springboot.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements com.example.springboot.service.UserService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
