package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {
}