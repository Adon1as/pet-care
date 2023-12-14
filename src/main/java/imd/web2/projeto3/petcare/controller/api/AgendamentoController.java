package imd.web2.projeto3.petcare.controller.api;

import imd.web2.projeto3.petcare.model.Agendamento;
import imd.web2.projeto3.petcare.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = {"/agendamento"} )
public class AgendamentoController extends GenericController<Agendamento, AgendamentoService>{

    @Autowired
    public AgendamentoController(AgendamentoService Service){
        super.setDependencies(Service);
    }


}
