package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Customer;
import awakelab.g6.grupal.model.domain.dto.Pay;
import awakelab.g6.grupal.web.service.ClienteService;
import awakelab.g6.grupal.web.service.PagoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/pago")
public class PagoController {
private final PagoService service;
private final PagoRestController pagoRestController;
private final ClienteService service2;
private final ClienteRestController clienteRestController;


    public PagoController(PagoService service, PagoRestController pagoRestController, ClienteService service2, ClienteRestController clienteRestController) {
        this.service = service;
        this.pagoRestController = pagoRestController;
        this.service2 = service2;
        this.clienteRestController = clienteRestController;
    }

    @GetMapping
public String listPagos(Model model){
    List<Pay> pays = pagoRestController.findAll().getBody();
    System.out.println(pays);
    model.addAttribute("pays",pays);
return "listPagos";
}
    @GetMapping ("/create")
    public String crearCapacitaciones(Model model){
        List<Pay> pays = pagoRestController.findAll().getBody();
        model.addAttribute("pays",pays);
        List<Customer> customers = clienteRestController.findAll().getBody();
        model.addAttribute("customers",customers);
        String op = "c";
        model.addAttribute("op",op);
        return "pago";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Pay pay,
                         HttpServletRequest request){
        pay.setPayDay(Date.valueOf(request.getParameter("dates")));
        pay.setCustomer(service2.findById(Integer.parseInt(request.getParameter(
                "customerId"))).orElse(null));
        pagoRestController.create(pay).getBody();

        return "redirect:/pago";
    }

}
