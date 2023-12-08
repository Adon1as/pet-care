package imd.web2.projeto3.petcare.controller;

import imd.web2.projeto3.petcare.model.Agendamento;
import imd.web2.projeto3.petcare.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = {"/agendamento"} )
public class AgendamentoController extends GenericController<Agendamento, AgendamentoRepository>{

    @Autowired
    public AgendamentoController(AgendamentoRepository repository){
        super.setDependencies(repository);
    }


}
