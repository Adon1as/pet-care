package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Local;
import imd.web2.projeto3.petcare.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/local"} )
public class LocalService extends GenericServe<Local, LocalRepository> {

    @Autowired
    public LocalService(LocalRepository repository){
        super.setDependencies(repository);
    }

}
