package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dao.UserDao;
import ru.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }


    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }


    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
