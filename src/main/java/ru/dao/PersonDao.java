package ru.dao;

import org.springframework.stereotype.Component;
import ru.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private int peapleCount=0;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++peapleCount,"Tom"));
        people.add(new Person(++peapleCount,"Jon"));
        people.add(new Person(++peapleCount,"Bill"));
        people.add(new Person(++peapleCount,"Lisa"));
        people.add(new Person(++peapleCount,"Nell"));

    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
