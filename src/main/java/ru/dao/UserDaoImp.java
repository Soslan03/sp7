package ru.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.models.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private final EntityManager entityManager;
    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery(" FROM User").getResultList();
    }
    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Override
    public void edit(User user, int id) {
        User edit = entityManager.find(User.class, id);
        edit.setName(user.getName());
        edit.setAge(user.getAge());
        edit.setEmail(user.getEmail());
    }
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
