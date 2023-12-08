package imd.web2.projeto3.petcare.controller;

import imd.web2.projeto3.petcare.model.Funcionario;
import imd.web2.projeto3.petcare.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = {"/funcionario"} )
public class FuncionarioController extends GenericController<Funcionario, FuncionarioRepository>{

    @Autowired
    public FuncionarioController(FuncionarioRepository repository){
        super.setDependencies(repository);
    }

}