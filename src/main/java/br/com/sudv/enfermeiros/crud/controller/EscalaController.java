package br.com.sudv.enfermeiros.crud.controller;

import br.com.sudv.enfermeiros.crud.model.Ala;
import br.com.sudv.enfermeiros.crud.model.Enfermeiro;
import br.com.sudv.enfermeiros.crud.model.Escalacao;
import br.com.sudv.enfermeiros.crud.model.Escala;
import br.com.sudv.enfermeiros.crud.repository.AlaRepository;
import br.com.sudv.enfermeiros.crud.repository.CriteriaEscalaRepository;
import br.com.sudv.enfermeiros.crud.repository.EnfermeiroRepository;
import br.com.sudv.enfermeiros.crud.repository.EscalaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/escalas")
public class EscalaController {
    private final CriteriaEscalaRepository criteriaEscalaRepository;
    private final EscalaRepository escalaRepository;
    private final AlaRepository alaRepository;
    private final EnfermeiroRepository enfermeiroRepository;

    public EscalaController(CriteriaEscalaRepository criteriaEscalaRepository, EscalaRepository escalaRepository, AlaRepository alaRepository, EnfermeiroRepository enfermeiroRepository) {
        this.criteriaEscalaRepository = criteriaEscalaRepository;
        this.escalaRepository = escalaRepository;
        this.alaRepository = alaRepository;
        this.enfermeiroRepository = enfermeiroRepository;
    }


    @GetMapping("/nova-escala")
    public String showSignUpForm(Escalacao escalacao) {
        return "add-escala";
    }

    @PostMapping("/addescala")
    public String addUser(@Valid Escalacao escalacao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-escala";
        }
        Ala ala = alaRepository.findByNomeAndAndar( escalacao.getAla(),escalacao.getAndar());
        Enfermeiro enfermeiro = enfermeiroRepository.findByCoren(escalacao.getCoren());

        Escala escala = new Escala();
        escala.setIdAla(ala.getId());
        escala.setIdEnfermeiro(enfermeiro.getId());
        escalaRepository.save(escala);

        return "redirect:/escalas";
    }

    @GetMapping
    public String showUserList(Model model) {
        model.addAttribute("escalas", criteriaEscalaRepository.findAll());
        return "escalas";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Escala escala = escalaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id da escala invalido:" + id));
        escalaRepository.delete(escala);
        return "redirect:/escalas";
    }

}
