package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Agendamento;
import imd.web2.projeto3.petcare.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = {"/agendamento"} )
public class AgendamentoService extends GenericServe<Agendamento, AgendamentoRepository> {

    @Autowired
    public AgendamentoService(AgendamentoRepository repository){
        super.setDependencies(repository);
    }


}
