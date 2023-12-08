package imd.web2.projeto3.petcare.controller;

import imd.web2.projeto3.petcare.model.Pet;
import imd.web2.projeto3.petcare.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/pet"} )
public class PetController extends GenericController<Pet, PetRepository>{

    @Autowired
    public PetController(PetRepository repository){
        super.setDependencies(repository);
    }

}
