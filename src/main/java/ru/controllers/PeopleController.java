package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dao.PersonDao;

import ru.models.User;

//import javax.annotation.processing.Generated;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;

    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDao.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDao.show(id));
        return "people/show";

    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User person){
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") User person){
        personDao.save(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDao.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String updte(@ModelAttribute("person") User person, @PathVariable("id") int id){
        personDao.edit(person, id);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDao.delete(id);
        return "redirect:/people";
    }
}
