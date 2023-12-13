package imd.web2.projeto3.petcare.viewcontroller;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
@Controller
public class ClienteViewController {

    private final ClienteRepository petRepository;

    @Autowired
    public ClienteViewController(ClienteRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/clientes")
    public String listclientes(Model model) {
        model.addAttribute("clientes", petRepository.findAll());
        model.addAttribute("pageTitle", "Listar clientes");
        return "cliente-listing";
    }

    @GetMapping("/clientes/add")
    public String showAddClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("pageTitle", "Cadastrar Cliente");
        model.addAttribute("viewMode", false);
        return "cliente-form";

    }

    @PostMapping("/clientes/add")
    public String addCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastrar Cliente");
            model.addAttribute("viewMode", false);
            return "cliente-form";
        }
        petRepository.save(cliente);

        return "redirect:/clientes";
    }
    @GetMapping("/clientes/edit/{id}")
    public String showEditClienteForm(@PathVariable Long id, Model model) {
        Cliente cliente = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente inválido com id: " + id));
        model.addAttribute("cliente", cliente);
        model.addAttribute("pageTitle", "Editar Cliente");
        model.addAttribute("viewMode", false);
        return "cliente-form";
    }

    @PostMapping("/clientes/edit/{id}")
    public String editCliente(@PathVariable Long id,@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Editar Cliente");
            model.addAttribute("viewMode", false);
            return "cliente-form";
        }
        cliente.setId(id);
        petRepository.save(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/clientes/view/{id}")
    public String viewCliente(@PathVariable Long id, Model model) {
        Cliente cliente = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido com id: " + id));
        model.addAttribute("cliente", cliente);
        model.addAttribute("viewMode", true);
        return "cliente-form";
    }

    @PostMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        petRepository.deleteById(id);
        return "redirect:/clientes";
    }





}
