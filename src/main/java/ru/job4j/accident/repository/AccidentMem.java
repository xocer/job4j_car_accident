package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private final Map<Integer, AccidentType> types = new ConcurrentHashMap<>();
    private final Map<Integer, Rule> rules = new ConcurrentHashMap<>();
    private final AtomicInteger count = new AtomicInteger(3);

    {
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
        accidents.put(1, new Accident( "test", "test", "test"));
        accidents.put(2, new Accident( "test2", "test2", "test2"));
        accidents.put(3, new Accident( "test3", "test3", "test3"));
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public Collection<AccidentType> getTypes() {
        return types.values();
    }

    public Collection<Rule> getRules() {
        return rules.values();
    }

    public Rule getRuleById(int id) {
        return rules.get(id);
    }

    public void create(Accident accident) {
        int id = count.incrementAndGet();
        accident.setId(id);
        accidents.put(id, accident);
    }

    public Accident getById(int id) {
        return accidents.get(id);
    }

    public AccidentType getTypeById(int id) {
        return types.get(id);
    }
}
