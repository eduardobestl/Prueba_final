package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.domain.dto.User;
import awakelab.g6.grupal.web.service.ClienteService;
import awakelab.g6.grupal.web.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
private final ClienteService service;
private final UsuarioService serviceUsuario;
private final ClienteRestController clienteRestController;
private final UsuarioRestController usuarioRestController;

    public ClienteController(ClienteService service,
                             UsuarioService serviceUsuario, ClienteRestController clienteRestController, UsuarioRestController usuarioRestController) {
        this.service = service;
        this.serviceUsuario = serviceUsuario;
        this.clienteRestController = clienteRestController;
        this.usuarioRestController = usuarioRestController;
    }

@GetMapping
    public String listClientes(Model model){
        List<Customer> customers = clienteRestController.findAll().getBody();
        model.addAttribute("customers",customers);
        return "listClientes";
}
    @GetMapping ("/c")
    public String crearCliente(Model model){
        String op = "c";
        model.addAttribute("op",op);
        return "cliente";
    }

    @PostMapping("/c")
    public String create(@ModelAttribute Customer customer,
                         @ModelAttribute User user,
                         HttpServletRequest request){
        customer.setUserId(usuarioRestController.create(user).getBody().getId());
        clienteRestController.create(customer);
        return "redirect:/cliente";
    }
    @GetMapping("/u/{Id}")
    public String editCliente(@PathVariable int Id
            , Model model){
        model.addAttribute("cliente", service.findById(Id).get());
        model.addAttribute("usuario",
                serviceUsuario.findById(service.findById(Id).get().getUserId()).get());
        model.addAttribute("op","u");
        return "cliente";
    }
    @PostMapping("/u")
    public String saveEditCliente(
            @ModelAttribute Customer customer,@ModelAttribute User user,
            Model model){
        System.out.println(customer.toString());
        System.out.println(user.toString());
        user.setId(customer.getUserId());
        usuarioRestController.update(user);
       clienteRestController.update(customer);
        return "redirect:/cliente";
    }
}
