package com.example.withAngular.juice;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class JuiceController {
    private JuiceRepository repository;

    public JuiceController(JuiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/good-juices")
    @CrossOrigin(origins = "http://localhost:3000")
    public Collection<Juice> goodJuices() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }
    

    private boolean isGreat(Juice juice) {
        return !juice.getName().equals("strawberry") &&
                !juice.getName().equals("pineapple") &&
                !juice.getName().equals("cherry");
    }

}
