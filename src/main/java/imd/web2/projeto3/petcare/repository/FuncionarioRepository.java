package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}