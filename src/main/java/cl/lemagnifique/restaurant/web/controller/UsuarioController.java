package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
private final UsuarioService service;
private final UsuarioRestController usuarioRestController;

    public UsuarioController(UsuarioService service,
                             UsuarioRestController usuarioRestController) {
        this.service = service;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listUsuarios(Model model){
        List<User> users = usuarioRestController.findAll().getBody();
        model.addAttribute("users",users);
        return "listUsuarios";
}
    @GetMapping ("/c")
    public String crearUsuario(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "usuario";
    }

    @PostMapping("/c")
    public String create(@ModelAttribute User user, HttpServletRequest request){
        usuarioRestController.create(user);
        return "redirect:/usuario";
    }

    @GetMapping("/u/{Id}")
    public String editUsuario(@PathVariable int Id
            , Model model){
        model.addAttribute("usuario", service.findById(Id).get());
        model.addAttribute("op","u");
        return "usuario";
    }
    @PostMapping("/u")
    public String saveEditUser(
            @ModelAttribute User user,
            Model model){
        System.out.println(user.toString());
        usuarioRestController.update(user);
        return "redirect:/usuario";
    }
}
