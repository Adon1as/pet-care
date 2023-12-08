package imd.web2.projeto3.petcare.controller;


import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<Model, Repository extends JpaRepository>{

    private Repository repository;

    public void setDependencies(Repository repository){
        this.repository = repository;
    }


    @GetMapping
    public String status(){
        return "API ON";
    }

    @GetMapping("/getAll")
    public List<Model> getAll(){
        return repository.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Model> getById(@PathVariable(value="id") Long id){
        return repository.findById(id);
    }

    @PostMapping("/post")
    public void postProduct(@RequestBody @Valid Model p){
        repository.save(p);
    }

    @PutMapping("/put")
    public void putProduct(@RequestBody @Valid Model p){
        repository.save(p);
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteProduct(@PathVariable(value="id") Long id){
        repository.deleteById(id);
    }

}
