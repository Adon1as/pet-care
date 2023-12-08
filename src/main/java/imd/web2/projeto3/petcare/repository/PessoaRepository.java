package imd.web2.projeto3.petcare.repository;

import imd.web2.projeto3.petcare.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PessoaRepository<T extends Pessoa> extends JpaRepository<T, Long> {
}