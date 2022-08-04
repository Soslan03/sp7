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

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void save(User person) {
        userDao.save(person);
    }

    @Transactional
    @Override
    public void edit(User person, int id) {
        userDao.edit(person, id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
