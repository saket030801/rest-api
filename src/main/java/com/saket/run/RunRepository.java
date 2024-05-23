package com.saket.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Repository
public class RunRepository {

    private final List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return Optional.of(runs.stream()
                .filter(run -> run.id() == id)
                .findFirst()
                .get());
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    public void delete(Integer id) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()){
            runs.remove(existingRun);
        }
    }

    @PostConstruct
    private void init(){
        runs.add(new Run(1,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.INDOOR));


        runs.add(new Run(2,
                "Tuesday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                3,
                Location.OUTDOOR));
    }


}
