package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}