package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.domain.dto.Training;
import awakelab.g6.grupal.web.service.CapacitacionService;
import awakelab.g6.grupal.web.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {
private final CapacitacionService service;
private final ClienteService service2;
private final ClienteRestController clienteRestController;
private final CapacitacionRestController capacitacionRestController;
    public CapacitacionController(CapacitacionService service,
                                  ClienteRestController clienteRestController
            , CapacitacionRestController capacitacionRestController,
                                  ClienteService service2) {
        this.service = service;
        this.clienteRestController = clienteRestController;
        this.capacitacionRestController = capacitacionRestController;
        this.service2 =service2;
    }

@GetMapping
public String listCapacitaciones(Model model){
  List<Training> trainings = capacitacionRestController.findAll().getBody();
    System.out.println(trainings);
  model.addAttribute("trainings",trainings);
  return "listCapacitaciones";
}

@GetMapping ("/create")
public String crearCapacitaciones(Model model){
        List<Training> trainings = capacitacionRestController.findAll().getBody();
        model.addAttribute("trainings",trainings);
        List<Customer> customers = clienteRestController.findAll().getBody();
        model.addAttribute("customers",customers);
        String op = "c";
        model.addAttribute("op",op);
        return "capacitacion";
    }

  @PostMapping("/create")
  public String create(@ModelAttribute Training training,
                                         HttpServletRequest request){
    System.out.println("hola pos cap controler");
    training.setDate(Date.valueOf(request.getParameter("dates")));
    training.setTime(Time.valueOf(request.getParameter("times") + ":00"));
    training.setCustomer(service2.findById(Integer.parseInt(request.getParameter(
            "customerId"))).orElse(null));
      System.out.println(capacitacionRestController.create(training).getBody().toString());
    return "redirect:/capacitacion";
  }


}
