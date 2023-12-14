package imd.web2.projeto3.petcare.viewcontroller;

import imd.web2.projeto3.petcare.model.Funcionario;
import imd.web2.projeto3.petcare.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import java.util.Arrays;
import java.util.List;

@Controller
public class FuncionarioViewController {

    private final FuncionarioRepository petRepository;
    private List<String> especialidades = Arrays.asList("Auxiliar de Limpeza", "Veterinário", "Treinador", "Atendente");

    @Autowired
    public FuncionarioViewController(FuncionarioRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/funcionarios")
    public String listFuncionarios(Model model) {
        model.addAttribute("funcionarios", petRepository.findAll());
        model.addAttribute("pageTitle", "Listar funcionarios");
        return "funcionario-listing";
    }

    @GetMapping("/funcionarios/add")
    public String showAddFuncionarioForm(Model model) {
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("pageTitle", "Cadastrar Funcionario");
        model.addAttribute("viewMode", false);

        return "funcionario-form";

    }
    @PostMapping("/funcionarios/add")
    public String addFuncionario(@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult bindingResult, Model model) {
        model.addAttribute("especialidades", especialidades);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastrar Funcionario");
            model.addAttribute("viewMode", false);
            return "funcionario-form";
        }
        petRepository.save(funcionario);

        return "redirect:/funcionarios";
    }
    @GetMapping("/funcionarios/edit/{id}")
    public String showEditFuncionarioForm(@PathVariable Long id, Model model) {
        model.addAttribute("especialidades", especialidades);
        Funcionario funcionario = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Funcionario inválido com id: " + id));
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("pageTitle", "Editar Funcionario");
        model.addAttribute("viewMode", false);
        return "funcionario-form";
    }

    @PostMapping("/funcionarios/edit/{id}")
    public String editFuncionario(@PathVariable Long id,@Valid @ModelAttribute("funcionario") Funcionario funcionario, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Editar Funcionario");
            model.addAttribute("viewMode", false);
            return "funcionario-form";
        }
        funcionario.setId(id);
        petRepository.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/funcionarios/view/{id}")
    public String viewFuncionario(@PathVariable Long id, Model model) {
        Funcionario funcionario = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario inválido com id: " + id));
        model.addAttribute("funcionario", funcionario);
        model.addAttribute("viewMode", true);
        return "funcionario-form";
    }

    @PostMapping("/funcionarios/delete/{id}")
    public String deleteFuncionario(@PathVariable Long id) {
        petRepository.deleteById(id);
        return "redirect:/funcionarios";
    }





}
