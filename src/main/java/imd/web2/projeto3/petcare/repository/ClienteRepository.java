package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}