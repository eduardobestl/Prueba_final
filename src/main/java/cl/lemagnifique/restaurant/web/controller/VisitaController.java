package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.Visit;
import awakelab.g6.grupal.web.service.VisitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/visita")
public class VisitaController {
private final VisitaService service;
private final VisitaRestController visitaRestController;


    public VisitaController(VisitaService service, VisitaRestController visitaRestController) {
        this.service = service;
        this.visitaRestController = visitaRestController;
    }
@GetMapping
public String listVisitas(Model model){
    List<Visit> visits = visitaRestController.findAll().getBody();
    System.out.println(visits);
    model.addAttribute("visits",visits);
return "listVisitas";
}
}
