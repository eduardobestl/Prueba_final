package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Administrative;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.AdministrativoService;
import awakelab.g6.grupal.web.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/administrativo")
public class AdministrativoController {
private final AdministrativoService service;
private final UsuarioService serviceUsuario;
private final AdministrativoRestController administrativoRestController;
private final UsuarioRestController usuarioRestController;

    public AdministrativoController(AdministrativoService service,
                                    UsuarioService serviceUsuario, AdministrativoRestController administrativoRestController,
                                    UsuarioRestController usuarioRestController) {
        this.service = service;
        this.serviceUsuario = serviceUsuario;
        this.administrativoRestController = administrativoRestController;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listAdministrativoes(Model model){
        List<Administrative> administratives =
                administrativoRestController.findAll().getBody();
        model.addAttribute("administratives",administratives);
        return "listAdministrativos";
}
    @GetMapping ("/c")
    public String crearAdministrativo(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "administrativo";
    }

    @PostMapping("/c")
    public String create(@ModelAttribute Administrative administrative,
                         @ModelAttribute User user,
                         HttpServletRequest request){
        administrative.setUserId(usuarioRestController.create(user).getBody().getId());
        administrativoRestController.create(administrative);
        return "redirect:/administrativo";
    }
    @GetMapping("/u/{Id}")
    public String editAdmin(@PathVariable int Id, Model model){
        model.addAttribute("admin", service.findById(Id).get());
        model.addAttribute("usuario",
                serviceUsuario.findById(service.findById(Id).get().getUserId()).get());
        model.addAttribute("op","u");
        return "administrativo";
    }
    @PostMapping("/u")
    public String saveEditAdmin(
            @ModelAttribute Administrative administrative, @ModelAttribute User user,
            Model model){
        System.out.println(administrative.toString());
        System.out.println(user.toString());
        user.setId(administrative.getUserId());
        usuarioRestController.update(user);
        administrativoRestController.update(administrative);
        return "redirect:/administrativo";
    }
}
