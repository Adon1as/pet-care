package imd.web2.projeto3.petcare.controller.api;

import imd.web2.projeto3.petcare.model.Local;
import imd.web2.projeto3.petcare.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/local"} )
public class LocalController extends GenericController<Local, LocalService>{

    @Autowired
    public LocalController(LocalService Service){
        super.setDependencies(Service);
    }

}
