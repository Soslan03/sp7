package ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import ru.models.User;
import ru.service.UserService;

import javax.validation.Valid;

//import javax.annotation.processing.Generated;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private UserService userservice;
    @Autowired
    public PeopleController(UserService userservice) {
        this.userservice = userservice;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", userservice.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", userservice.show(id));
        return "people/show";

    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User person){
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid User person, BindingResult bindingResult){
        userservice.save(person);
        if (bindingResult.hasErrors()) { return "people/new"; }
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("person", userservice.show(id));
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String updte(@ModelAttribute("person") @Valid User person, BindingResult bindingResult, @PathVariable("id") int id){
      userservice.edit(person, id);
        if (bindingResult.hasErrors()) { return "people/edit"; }
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userservice.delete(id);
        return "redirect:/people";
    }
}
