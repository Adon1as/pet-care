package imd.web2.projeto3.petcare.service;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public abstract class GenericServe <Entiry, Repository extends JpaRepository>{
    private Repository repository;
    public void setDependencies(Repository repository){
        this.repository = repository;
    }
    public List<Entiry> findAll(){
        return repository.findAll();
    }
    public Optional<Entiry> findById(Long id){
        return repository.findById(id);
    }
    public void save(Entiry p){
        repository.save(p);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
