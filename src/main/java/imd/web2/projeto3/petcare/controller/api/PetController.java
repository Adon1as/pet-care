package imd.web2.projeto3.petcare.controller.api;

import imd.web2.projeto3.petcare.model.Pet;
import imd.web2.projeto3.petcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/pet"} )
public class PetController extends GenericController<Pet, PetService>{

    @Autowired
    public PetController(PetService Service){
        super.setDependencies(Service);
    }

}
