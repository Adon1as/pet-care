package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.repository.ClienteRepository;
import imd.web2.projeto3.petcare.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService extends GenericServe<Cliente, ClienteRepository>{

    @Autowired
    public ClienteService(ClienteRepository repository){
        super.setDependencies(repository);
    }


}
