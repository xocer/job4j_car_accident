package ru.job4j.accident.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;

@Data
@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident(1, "test", "test", "test"));
        accidents.put(2, new Accident(2, "test2", "test2", "test2"));
        accidents.put(3, new Accident(3, "test3", "test3", "test3"));
    }
}
