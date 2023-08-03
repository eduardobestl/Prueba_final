package cl.lemagnifique.restaurant.web.controller;

import awakelab.g6.grupal.model.domain.dto.CheckList;
import awakelab.g6.grupal.web.service.ListaChequeoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chequeo")
public class ChequeoController {
private final ListaChequeoService service;
private final ChequeoRestController chequeoRestController;

    public ChequeoController(ListaChequeoService service, ChequeoRestController chequeoRestController) {
        this.service = service;
        this.chequeoRestController = chequeoRestController;
    }

    @GetMapping
public String listChequeo(Model model){
    List<CheckList> chequeos = chequeoRestController.findAll().getBody();
    System.out.println(chequeos);
    model.addAttribute("chequeos",chequeos);
return "listChequeos";
}
}
