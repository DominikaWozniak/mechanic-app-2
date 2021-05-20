package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.mechanicapp2.model.Car;
import pl.project.mechanicapp2.model.CarOwner;
import pl.project.mechanicapp2.services.CarOwnerService;
import pl.project.mechanicapp2.services.CarService;

@Controller
public class CarOwnerController {

    private CarOwnerService carOwnerService;
    private CarService carService;

    public CarOwnerController(CarOwnerService carOwnerService, CarService carService) {
        this.carOwnerService = carOwnerService;
        this.carService = carService;
    }

    @GetMapping("/carOwnerList")
    public String viewOwnerList(Model model){
        model.addAttribute("carOwners", carOwnerService.findAllItems());
        return "car_owner_list";
    }

    @GetMapping("/selectCars/{id}")
    public String selectCars(@PathVariable("id") Long id, Model model){
        model.addAttribute("carsByOwnerId", carService.findCarByOwnerId(id));
        return "selected_cars";
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
        return "redirect:/carOwnerList";
    }

    @GetMapping("/ownerForm")
    public String newOwnerForm(Model model){
        CarOwner carOwner = new CarOwner();
        model.addAttribute("newOwner", carOwner);
        return "new_owner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("newOwner") CarOwner carOwner){
        carOwnerService.saveItem(carOwner);
        return "redirect:/carOwnerList";
    }

    @GetMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable(value = "id") Long id){
        this.carOwnerService.deleteItemById(id);
        return "redirect:/carOwnerList";
    }

    @GetMapping("/formUpdateOwner/{id}")
    public String updateOwner(@PathVariable(value = "id") Long id, Model model){
        CarOwner carOwner = carOwnerService.getItemById(id);
        model.addAttribute("updateOwner", carOwner);
        return "update_owner_form";
    }
}
