package imd.web2.projeto3.petcare.viewcontroller;

import imd.web2.projeto3.petcare.model.Pet;
import imd.web2.projeto3.petcare.repository.PetRepository;
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
public class PetViewController {

    private final PetRepository petRepository;

    @Autowired
    public PetViewController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping("/pets")
    public String listPets(Model model) {
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("pageTitle", "Listar Pets");
        return "pet-listing";
    }

    @GetMapping("/pets/add")
    public String showAddPetForm(Model model) {
        model.addAttribute("pet", new Pet());
        model.addAttribute("pageTitle", "Cadastrar Pet");
        model.addAttribute("viewMode", false);
        return "pet-form";

    }

    @PostMapping("/pets/add")
    public String addPet(@Valid @ModelAttribute("pet") Pet pet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Cadastrar Pet");
            model.addAttribute("viewMode", false);
            return "pet-form";
        }
        petRepository.save(pet);

        return "redirect:/pets";
    }
    @GetMapping("/pets/edit/{id}")
    public String showEditPetForm(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet inválido com id: " + id));
        model.addAttribute("pet", pet);
        model.addAttribute("pageTitle", "Editar Pet");
        model.addAttribute("viewMode", false);
        return "pet-form";
    }

    @PostMapping("/pets/edit/{id}")
    public String editPet(@PathVariable Long id,@Valid @ModelAttribute("pet") Pet pet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", "Editar Pet");
            model.addAttribute("viewMode", false);
            return "pet-form";
        }
        pet.setId(id);
        petRepository.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/pets/view/{id}")
    public String viewPet(@PathVariable Long id, Model model) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet inválido com id: " + id));
        model.addAttribute("pet", pet);
        model.addAttribute("viewMode", true);
        return "pet-form";
    }

    @PostMapping("/pets/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
        return "redirect:/pets";
    }





}
