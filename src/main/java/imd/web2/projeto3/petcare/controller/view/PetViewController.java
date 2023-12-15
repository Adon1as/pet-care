package imd.web2.projeto3.petcare.controller.view;

import imd.web2.projeto3.petcare.model.Cliente;
import imd.web2.projeto3.petcare.model.Pet;
import imd.web2.projeto3.petcare.service.ClienteService;
import imd.web2.projeto3.petcare.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@Controller
public class PetViewController {

    private final PetService petService;
    private final ClienteService clienteService;

    @Autowired
    public PetViewController(PetService petService, ClienteService clienteService) {
        this.petService = petService;
        this.clienteService = clienteService;
    }

    @GetMapping("/pets")
    public String listPets(Model model) {
        model.addAttribute("pets", petService.findAll());
        model.addAttribute("pageTitle", "Listar Pets");
        return "pet-listing";
    }

    @GetMapping("/pets/add")
    public String showAddPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("pageTitle", "Cadastrar Pet");
        model.addAttribute("viewMode", false);
        List<Cliente> responsaveis = this.clienteService.findAll();
        model.addAttribute("responsaveis", responsaveis);
        return "pet-form";

    }

    @PostMapping("/pets/add")
    public String addPet(@Valid @ModelAttribute("pet") Pet pet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastrar Pet");
            model.addAttribute("viewMode", false);
            return "pet-form";
        }
        petService.save(pet);

        return "redirect:/pets";
    }
    @GetMapping("/pets/edit/{id}")
    public String showEditPetForm(@PathVariable Long id, Model model) {
        Pet pet = petService.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet inválido com id: " + id));
        model.addAttribute("pet", pet);
        model.addAttribute("pageTitle", "Editar Pet");
        model.addAttribute("viewMode", false);
        List<Cliente> responsaveis = this.clienteService.findAll();
        model.addAttribute("responsaveis", responsaveis);
        return "pet-form";
    }

    @PostMapping("/pets/edit/{id}")
    public String editPet(@PathVariable Long id,@Valid @ModelAttribute("pet") Pet pet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Editar Pet");
            model.addAttribute("viewMode", false);
            return "pet-form";
        }
        List<Cliente> responsaveis = this.clienteService.findAll();
        model.addAttribute("responsaveis", responsaveis);
        pet.setId(id);
        petService.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pets/view/{id}")
    public String viewPet(@PathVariable Long id, Model model) {
        Pet pet = petService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet inválido com id: " + id));
        model.addAttribute("pet", pet);
        model.addAttribute("viewMode", true);
        Cliente responsavel = petService.reponsavelByPetId(pet.getId());
        model.addAttribute("responsavel", responsavel.getNome());
        return "pet-form";
    }

    @PostMapping("/pets/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deleteById(id);
        return "redirect:/pets";
    }





}
