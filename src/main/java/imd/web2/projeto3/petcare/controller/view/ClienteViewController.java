package imd.web2.projeto3.petcare.controller.view;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.service.ClienteService;
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

    private final ClienteService clienteService;

    @Autowired
    public ClienteViewController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public String listclientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
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
        clienteService.save(cliente);

        return "redirect:/clientes";
    }
    @GetMapping("/clientes/edit/{id}")
    public String showEditClienteForm(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente inválido com id: " + id));
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
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/view/{id}")
    public String viewCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido com id: " + id));
        model.addAttribute("cliente", cliente);
        model.addAttribute("viewMode", true);
        return "cliente-form";
    }

    @PostMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable Long id) {
        clienteService.deleteById(id);
        return "redirect:/clientes";
    }





}
