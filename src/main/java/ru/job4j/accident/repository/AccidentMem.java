package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.*;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final HashMap<Integer, AccidentType> types = new HashMap<>();


    {
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

    public void create(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public Accident getById(int id) {
        return accidents.get(id);
    }

    public AccidentType getTypeById(int id) {
        return types.get(id);
    }
}
