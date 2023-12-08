package imd.web2.projeto3.petcare.controller;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/cliente"} )
public class ClienteController extends GenericController<Cliente, ClienteRepository>{

    @Autowired
    public ClienteController(ClienteRepository repository){
        super.setDependencies(repository);
    }

}