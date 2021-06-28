package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.RuleRepository;
import ru.job4j.accident.repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccidentService {
    private final AccidentRepository accidentRepository;
    private final TypeRepository typeRepository;
    private final RuleRepository ruleRepository;

    public AccidentService(AccidentRepository accidentRepository,
                           TypeRepository typeRepository,
                           RuleRepository ruleRepository) {
        this.accidentRepository = accidentRepository;
        this.typeRepository = typeRepository;
        this.ruleRepository = ruleRepository;
    }

    public List<Accident> getAllAccidents() {
        List<Accident> accidents = new ArrayList<>();
        accidentRepository.findAll().forEach(accidents::add);
        return accidents;
    }

    public List<AccidentType> getAllTypes() {
        List<AccidentType> types = new ArrayList<>();
        typeRepository.findAll().forEach(types::add);
        return types;
    }

    public List<Rule> getAllRules() {
        List<Rule> rules = new ArrayList<>();
        ruleRepository.findAll().forEach(rules::add);
        return rules;
    }

    public Accident getAccidentById(int id) {
        return accidentRepository.findById(id).get();
    }

    public AccidentType getTypeById(int id) {
        return typeRepository.findById(id).get();
    }

    public Rule getRuleById(int id) {
        return ruleRepository.findById(id).get();
    }

    public void createAccident(Accident accident) {
        accidentRepository.save(accident);
    }

    public void deleteAccident(int id) {
        accidentRepository.deleteById(id);
    }
}
