package br.com.sudv.enfermeiros.crud.controller;

import br.com.sudv.enfermeiros.crud.data.model.Enfermeiro;
import br.com.sudv.enfermeiros.crud.repository.EnfermeiroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

    private final EnfermeiroRepository enfermeiroRepository;

    public EnfermeiroController(EnfermeiroRepository enfermeiroRepository) {
        this.enfermeiroRepository = enfermeiroRepository;
    }

    @GetMapping("/novo-enfermeiro")
    public String showSignUpForm(Enfermeiro enfermeiro) {
        return "add-enfermeiro";
    }

    @PostMapping("/addenfermeiro")
    public String addUser(@Valid Enfermeiro enfermeiro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-enfermeiro";
        }

        enfermeiroRepository.save(enfermeiro);
        return "redirect:/enfermeiros";
    }

    @GetMapping
    public String showUserList(Model model) {
        model.addAttribute("enfermeiros", enfermeiroRepository.findAll());
        return "enfermeiros";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        Enfermeiro enfermeiro = enfermeiroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id do enfermeiro invalido:" + id));
        enfermeiroRepository.delete(enfermeiro);
        return "redirect:/enfermeiros";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid Enfermeiro enfermeiro,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            enfermeiro.setId(id);
            return "update-enfermeiro";
        }

        enfermeiroRepository.save(enfermeiro);
        return "redirect:/enfermeiros";
    }


    @GetMapping("/update-enfermeiro/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Enfermeiro enfermeiro = enfermeiroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id do enfermeiro invalido:" + id));

        model.addAttribute("enfermeiro", enfermeiro);
        return "update-enfermeiro";
    }
}
