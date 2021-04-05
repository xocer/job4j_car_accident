package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    {
        accidents.put(1, new Accident( "test", "test", "test"));
        accidents.put(2, new Accident( "test2", "test2", "test2"));
        accidents.put(3, new Accident( "test3", "test3", "test3"));
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public Accident getById(int id) {
        return accidents.get(id);
    }
}
