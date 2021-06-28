package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;
import ru.job4j.accident.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AccidentControl {
    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", service.getAllTypes());
        model.addAttribute("rules", service.getAllRules());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        Set<Rule> rules = new HashSet<>();
        String[] ids = req.getParameterValues("rIds");
        if (ids != null) {
            Arrays.stream(ids).
                    forEach(r -> rules.add(service.getRuleById(Integer.parseInt(r))));
            accident.setRules(rules);
        }
        accident.setType(service.getTypeById(accident.getType().getId()));
        service.createAccident(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", service.getAllTypes());
        model.addAttribute("rules", service.getAllRules());
        model.addAttribute("accident", service.getAccidentById(id));
        return "accident/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        service.deleteAccident(id);
        return "redirect:/";
    }

//    @PostMapping("/update")
//    public String update(@ModelAttribute Accident accident, HttpServletRequest req) {
//        String[] rulesId = req.getParameterValues("rulesId");
//        Set<Rule> rules = new HashSet<>();
//        Arrays.stream(rulesId).
//                forEach(r -> rules.add(service.getRuleById(Integer.parseInt(r))));
//        accident.setRules(rules);
//        accident.setType(service.getTypeById(accident.getType().getId()));
//        service.createAccident(correctAccident);
//        return "redirect:/";
//    }
}