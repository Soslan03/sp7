package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dao.UserDao;
import ru.models.User;

import java.util.List;

@Service()
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> index() {

        return userDao.index();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return userDao.show(id);
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
