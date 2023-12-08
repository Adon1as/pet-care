package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}