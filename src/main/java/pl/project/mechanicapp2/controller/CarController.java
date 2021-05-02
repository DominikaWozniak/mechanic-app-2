package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.mechanicapp2.services.CarOwnerService;
import pl.project.mechanicapp2.services.CarService;

@Controller
public class CarController {

    private CarService carService;
    private CarOwnerService carOwnerService;

    public CarController(CarService carService, CarOwnerService carOwnerService) {
        this.carService = carService;
        this.carOwnerService = carOwnerService;
    }

    @GetMapping("/cars")
    public String viewCars(Model model){
        model.addAttribute("carList", carService.findAllItems());
        return "cars_list";
    }

}
