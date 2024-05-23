package com.saket.run;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;


    public RunController(RunRepository runRepository){
        this.runRepository=runRepository;
    }

    @GetMapping("")
    List<Run> findAll(){
        return runRepository.findAll();
    }


    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
//        if(run.isEmpty()){
//            throw new RunNotFoundException();
//        }

        if (run.isPresent()) {
            return run.get();
        } else {
            throw new RunNotFoundException(); // Pass the ID to the exception
        }
//        return run.get();
    }

    @PostMapping("")
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    @PutMapping("/{id}")
    void update (@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
