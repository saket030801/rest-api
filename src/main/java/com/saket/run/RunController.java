package com.saket.run;

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
    Optional<Run> findById(@PathVariable Integer id){
        return runRepository.findById(id);
    }

    @PostMapping("")
    void create(@RequestBody Run run){
        runRepository.create(run);
    }

    @PutMapping("/{id}")
    void update (@RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
