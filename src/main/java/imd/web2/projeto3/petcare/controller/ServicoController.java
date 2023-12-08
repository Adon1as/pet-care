package imd.web2.projeto3.petcare.controller;

import imd.web2.projeto3.petcare.model.Servico;
import imd.web2.projeto3.petcare.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/servico"} )
public class ServicoController extends GenericController<Servico, ServicoRepository>{

    @Autowired
    public ServicoController(ServicoRepository repository){
        super.setDependencies(repository);
    }

}
