package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}