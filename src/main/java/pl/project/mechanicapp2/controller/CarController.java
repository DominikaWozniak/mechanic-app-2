package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.mechanicapp2.model.Car;
import pl.project.mechanicapp2.services.CarOwnerService;
import pl.project.mechanicapp2.services.CarService;

@Controller
public class CarController {

    private CarOwnerService carOwnerService;
    private CarService carService;

    public CarController(CarOwnerService carOwnerService, CarService carService) {
        this.carOwnerService = carOwnerService;
        this.carService = carService;
    }

    @GetMapping("/carForm/{id}")
    public String newCarForm(@PathVariable("id") Long id, Model model){
        Car car = new Car();
        car.setCarOwner(carOwnerService.getItemById(id));
        model.addAttribute("newCar", car);
        return "new_car";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("newCar") Car car){
        carService.saveItem(car);
        return "redirect:/moreInfoOwner/" + car.getCarOwner().getId();
    }

    @GetMapping("/carFormUpdate/{id}")
    public String updateCar(@PathVariable(value = "id") Long id, Model model){
        Car car = carService.getItemById(id);
        model.addAttribute("carUpdate", car);
        return "car_update";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(value = "id") Long id){
        Car car = carService.getItemById(id);
        this.carService.deleteItemById(id);
        return "redirect:/moreInfoOwner/" + car.getCarOwner().getId();
    }
}
