package ru.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    private int peapleCount=0;
    private List<User> people;
    {
        people = new ArrayList<>();
        people.add(new User("Tom", 24, "tom@mail.ru"));
        people.add(new User("Jon",52, "bob@mail.ru"));
        people.add(new User("Bill", 18, "mike@yahoo.com"));
        people.add(new User("Lisa", 34, "katy@gmail.com"));
        people.add(new User("Nell", 45, "nell@rambler.ru"));

    }



    public List<User> index(){
        return people;
    }
    public User show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(User person) {
//        person.setId(++peapleCount);
//        people.add(person);
        entityManager.persist(person);
    }

    public void edit(User person, int id) {
        User persontoBeUpdate= show(id);
        persontoBeUpdate.setName(person.getName());
        persontoBeUpdate.setAge(person.getAge());
        persontoBeUpdate.setEmail(person.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p ->p.getId() == id);
    }
}
