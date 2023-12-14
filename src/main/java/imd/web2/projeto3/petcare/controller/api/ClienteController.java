package imd.web2.projeto3.petcare.controller.api;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/cliente"} )
public class ClienteController extends GenericController<Cliente, ClienteService>{

    @Autowired
    public ClienteController(ClienteService Service){
        super.setDependencies(Service);
    }

}