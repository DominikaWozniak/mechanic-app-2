package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.project.mechanicapp2.model.CarOwner;
import pl.project.mechanicapp2.services.CarOwnerService;

@Controller
public class CarOwnerController {

    private CarOwnerService carOwnerService;

    public CarOwnerController(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    @GetMapping("/showOwnerThisCar/{id}")
    public String viewThisOwner(@PathVariable("id") Long id, Model model){
        CarOwner carOwner = carOwnerService.getItemById(id);
        model.addAttribute("carOwner", carOwner);
        return "owner_this_car";
    }
}
