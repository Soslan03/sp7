package ru.dao;

import ru.models.User;

import java.util.List;

public interface UserDao {
    public List<User> listUsers();
    public User getUserById(int id);
    public void save(User user);
    public void edit(User user);
    public void delete(int id);
}
