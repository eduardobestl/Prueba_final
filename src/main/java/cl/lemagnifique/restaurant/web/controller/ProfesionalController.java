package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Professional;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.ProfesionalService;
import awakelab.g6.grupal.web.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesional")
public class ProfesionalController {
private final ProfesionalService service;
private final UsuarioService serviceUsuario;
private final ProfesionalRestController profesionalRestController;
private final UsuarioRestController usuarioRestController;

    public ProfesionalController(ProfesionalService service,
                                 UsuarioService serviceUsuario, ProfesionalRestController profesionalRestController, UsuarioRestController usuarioRestController) {
        this.service = service;
        this.serviceUsuario = serviceUsuario;
        this.profesionalRestController = profesionalRestController;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listProfesionales(Model model){
        List<Professional> professionals =
                profesionalRestController.findAll().getBody();
        model.addAttribute("professionals",professionals);
        return "listProfesionales";
}
    @GetMapping ("/c")
    public String crearProfesional(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "profesional";
    }

    @PostMapping("/c")
    public String create(@ModelAttribute Professional professional,
                         @ModelAttribute User user,
                         HttpServletRequest request){
        professional.setUserId(usuarioRestController.create(user).getBody().getId());
        profesionalRestController.create(professional);
        return "redirect:/profesional";
    }
    @GetMapping("/u/{Id}")
    public String editProfesional(@PathVariable int Id
            , Model model){
        model.addAttribute("profesional", service.findById(Id).get());
        model.addAttribute("usuario",
                serviceUsuario.findById(service.findById(Id).get().getUserId()).get());
        model.addAttribute("op","u");
        return "profesional";
    }
    @PostMapping("/u")
    public String saveEditProfesional(
            @ModelAttribute Professional professional,
            @ModelAttribute User user,
            Model model){
        System.out.println(professional.toString());
        System.out.println(user.toString());
        user.setId(professional.getUserId());
        usuarioRestController.update(user);
        profesionalRestController.update(professional);
        return "redirect:/profesional";
    }
}
