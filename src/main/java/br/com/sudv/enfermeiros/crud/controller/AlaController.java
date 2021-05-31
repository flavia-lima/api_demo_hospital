package br.com.sudv.enfermeiros.crud.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sudv.enfermeiros.crud.data.model.Ala;
import br.com.sudv.enfermeiros.crud.repository.AlaRepository;

@Controller
@RequestMapping("/alas")
public class AlaController {

    private final AlaRepository alaRepository;

    public AlaController(AlaRepository alaRepository) {
        this.alaRepository = alaRepository;
    }


    @GetMapping("/nova-ala")
    public String showSignUpForm(Ala ala) {
        return "add-ala";
    }

    @PostMapping("/addala")
    public String addUser(@Valid Ala ala, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-ala";
        }

        alaRepository.save(ala);
        return "redirect:/alas";
    }

    @GetMapping
    public String showUserList(Model model) {
        model.addAttribute("alas", alaRepository.findAll());
        return "alas";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        Ala ala = alaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id do ala invalido:" + id));
        alaRepository.delete(ala);
        return "redirect:/alas";
    }
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid Ala ala,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            ala.setId(id);
            return "update-ala";
        }

        alaRepository.save(ala);
        return "redirect:/alas";
    }


    @GetMapping("/update-ala/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Ala ala = alaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id da ala invalido:" + id));

        model.addAttribute("ala", ala);
        return "update-ala";
    }
}
