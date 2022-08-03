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
    public List<User> index() {


        return entityManager.createQuery(" FROM User").getResultList();
    }

    @Override
    public User show(int id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User person) {

        entityManager.persist(person);
    }

    @Override
    public void edit(User person, int id) {

        User edit = entityManager.find(User.class, id);
        edit.setName(person.getName());
        edit.setAge(person.getAge());
        edit.setEmail(person.getEmail());

    }

    @Override
    public void delete(int id) {

        entityManager.remove(entityManager.find(User.class, id));
    }
}
