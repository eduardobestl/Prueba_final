package cl.lemagnifique.restaurant.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

  @GetMapping
  public String getContacto() {
    return "contacto";
  }

  @PostMapping
  public String postContacto(HttpServletRequest request) {
    String op = request.getParameter("enviar");
    if (op != null) {
      if (op.equals("contacto")) {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String mensaje = request.getParameter("mensaje");
        System.out.println("Nombre: " + nombre);
        System.out.println("E-Mail: " + email);
        System.out.println("Mensaje: " + mensaje);
      }
    }
    return "contacto";
  }
}
