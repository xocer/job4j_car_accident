package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", accidents.getTypes());
        model.addAttribute("rules", accidents.getRules());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        Set<Rule> rules = new HashSet<>();
        if (ids != null) {
            Arrays.stream(ids).
                    forEach(r -> rules.add(accidents.getRuleById(Integer.parseInt(r))));
            accident.setRules(rules);
        }
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