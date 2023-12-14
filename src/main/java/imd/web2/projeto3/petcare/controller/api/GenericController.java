package imd.web2.projeto3.petcare.controller.api;


import imd.web2.projeto3.petcare.service.GenericServe;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericController<Model, Service extends GenericServe>{

    private Service Service;

    public void setDependencies(Service Service){
        this.Service = Service;
    }


    @GetMapping
    public String status(){
        return "API ON";
    }

    @GetMapping("/getAll")
    public List<Model> getAll(){
        return Service.findAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Model> getById(@PathVariable(value="id") Long id){
        return Service.findById(id);
    }

    @PostMapping("/post")
    public void postProduct(@RequestBody @Valid Model p){
        Service.save(p);
    }

    @PutMapping("/put")
    public void putProduct(@RequestBody @Valid Model p){
        Service.save(p);
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteProduct(@PathVariable(value="id") Long id){
        Service.deleteById(id);
    }

}
