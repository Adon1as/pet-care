package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Servico;
import imd.web2.projeto3.petcare.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/servico"} )
public class ServicoService extends GenericServe<Servico, ServicoRepository> {

    @Autowired
    public ServicoService(ServicoRepository repository){
        super.setDependencies(repository);
    }

}
