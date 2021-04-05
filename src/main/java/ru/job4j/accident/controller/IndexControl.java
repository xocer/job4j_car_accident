package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentMem;

@Controller
public class IndexControl {
    private final AccidentMem mem;

    public IndexControl(AccidentMem mem) {
        this.mem = mem;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", mem.getAccidents());
        return "index";
    }
}