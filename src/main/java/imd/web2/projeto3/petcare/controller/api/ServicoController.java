package imd.web2.projeto3.petcare.controller.api;

import imd.web2.projeto3.petcare.model.Servico;
import imd.web2.projeto3.petcare.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/servico"} )
public class ServicoController extends GenericController<Servico, ServicoService>{

    @Autowired
    public ServicoController(ServicoService Service){
        super.setDependencies(Service);
    }

}
