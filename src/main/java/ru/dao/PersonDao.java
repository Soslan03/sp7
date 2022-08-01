package ru.dao;

import org.springframework.stereotype.Component;
import ru.models.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private int peapleCount=0;
    private List<User> people;
    {
        people = new ArrayList<>();
        people.add(new User(++peapleCount,"Tom"));
        people.add(new User(++peapleCount,"Jon"));
        people.add(new User(++peapleCount,"Bill"));
        people.add(new User(++peapleCount,"Lisa"));
        people.add(new User(++peapleCount,"Nell"));

    }
    public List<User> index(){
        return people;
    }
    public User show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(User person) {
        person.setId(++peapleCount);
        people.add(person);
    }

    public void edit(User person, int id) {
        User persontoBeUpdate= show(id);
        persontoBeUpdate.setName(person.getName());

    }

    public void delete(int id) {
        people.removeIf(p ->p.getId() == id);
    }
}
