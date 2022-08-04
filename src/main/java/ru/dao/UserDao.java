package ru.dao;

import ru.models.User;

import java.util.List;

public interface UserDao {
    public List<User> listUsers();
    public User getUserById(int id);
    public void save(User person);
    public void edit(User person, int id);
    public void delete(int id);
}
