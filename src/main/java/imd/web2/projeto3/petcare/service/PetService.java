package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.model.Pet;
import imd.web2.projeto3.petcare.repository.ClienteRepository;
import imd.web2.projeto3.petcare.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService extends GenericServe<Pet, PetRepository>{

   private final ClienteRepository clienteRepository;
    @Autowired
    public PetService(PetRepository repository, ClienteRepository clienteRepository){
        super.setDependencies(repository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void save(Pet p){
        Cliente r = clienteRepository.getReferenceById(p.getResponsavelId());
        r.getPets().add(p);
        clienteRepository.save(r);
    }


}
