package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getTypes());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @ModelAttribute AccidentType accidentType) {
        accident.setType(accidents.getTypeById(accident.getType().getId()));
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.getById(id));
        return "accident/edit";
    }
}