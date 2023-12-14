package imd.web2.projeto3.petcare.controller.view;

import imd.web2.projeto3.petcare.model.Servico;
import imd.web2.projeto3.petcare.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServicoViewController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoViewController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("/servicos")
    public String listservicos(Model model) {
        model.addAttribute("servicos", servicoService.findAll());
        model.addAttribute("pageTitle", "Listar servicos");
        return "servico-listing";
    }

    @GetMapping("/servicos/add")
    public String showAddClienteForm(Model model) {
        model.addAttribute("servico", new Servico());
        model.addAttribute("pageTitle", "Cadastrar Servico");
        model.addAttribute("viewMode", false);
        return "servico-form";

    }

    @PostMapping("/servicos/add")
    public String addCliente(@Valid @ModelAttribute("servico") Servico servico, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastrar Servico");
            model.addAttribute("viewMode", false);
            return "servico-form";
        }
        servicoService.save(servico);

        return "redirect:/servicos";
    }
    @GetMapping("/servicos/edit/{id}")
    public String showEditClienteForm(@PathVariable Long id, Model model) {
        Servico servico = servicoService.findById(id).orElseThrow(() -> new IllegalArgumentException("Servico inválido com id: " + id));
        model.addAttribute("servico", servico);
        model.addAttribute("pageTitle", "Editar Servico");
        model.addAttribute("viewMode", false);
        return "servico-form";
    }

    @PostMapping("/servicos/edit/{id}")
    public String editCliente(@PathVariable Long id,@Valid @ModelAttribute("servico") Servico servico, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Editar Servico");
            model.addAttribute("viewMode", false);
            return "servico-form";
        }
        servico.setId(id);
        servicoService.save(servico);
        return "redirect:/servicos";
    }

    @GetMapping("/servicos/view/{id}")
    public String viewCliente(@PathVariable Long id, Model model) {
        Servico servico = servicoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Servico inválido com id: " + id));
        model.addAttribute("servico", servico);
        model.addAttribute("viewMode", true);
        return "servico-form";
    }

    @PostMapping("/servicos/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        servicoService.deleteById(id);
        return "redirect:/servicos";
    }





}
