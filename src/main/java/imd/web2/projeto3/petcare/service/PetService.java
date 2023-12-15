package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.model.Pet;
import imd.web2.projeto3.petcare.repository.ClienteRepository;
import imd.web2.projeto3.petcare.repository.PetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService extends GenericServe<Pet, PetRepository>{

    final
    EntityManager em;
   private final ClienteRepository clienteRepository;
    @Autowired
    public PetService(PetRepository repository, ClienteRepository clienteRepository, EntityManager em){
        super.setDependencies(repository);
        this.clienteRepository = clienteRepository;
        this.em = em;
    }

    @Override
    public void save(Pet p){
        Cliente r = clienteRepository.getReferenceById(p.getResponsavelId());
        r.getPets().add(p);
        clienteRepository.save(r);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Query q = em.createNativeQuery("DELETE FROM cliente_pets WHERE pets_id=" + id);
        q.executeUpdate();
        super.deleteById(id);
    }


    public Cliente reponsavelByPetId(Long id){
        Query q = em.createNativeQuery("SELECT * FROM cliente c, cliente_pets cp  WHERE c.id = cp.cliente_id AND cp.pets_id ="+id, Cliente.class);
        return (Cliente) q.getSingleResult();
    }
}
