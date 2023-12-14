package imd.web2.projeto3.petcare.service;

import imd.web2.projeto3.petcare.model.Funcionario;
import imd.web2.projeto3.petcare.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = {"/funcionario"} )
public class FuncionarioService extends GenericServe<Funcionario, FuncionarioRepository> {

    @Autowired
    public FuncionarioService(FuncionarioRepository repository){
        super.setDependencies(repository);
    }

}