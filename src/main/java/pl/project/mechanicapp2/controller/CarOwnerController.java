package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.mechanicapp2.model.CarOwner;
import pl.project.mechanicapp2.services.AddressService;
import pl.project.mechanicapp2.services.CarOwnerService;
import pl.project.mechanicapp2.services.CarService;

@Controller
public class CarOwnerController {

    private CarOwnerService carOwnerService;
    private CarService carService;
    private AddressService addressService;

    public CarOwnerController(CarOwnerService carOwnerService, CarService carService, AddressService addressService) {
        this.carOwnerService = carOwnerService;
        this.carService = carService;
        this.addressService = addressService;
    }

    @GetMapping("/carOwnerList")
    public String viewOwnerList(Model model){
        model.addAttribute("carOwners", carOwnerService.findAllItems());
        return "car_owner_list";
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
        return "redirect:/moreInfoOwner/" + carOwner.getId();
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

    @GetMapping("/moreInfoOwner/{id}")
    public String infoAndOptionsPage(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("viewThisOwner", carOwnerService.getItemById(id));
        model.addAttribute("carsByOwnerId", carService.findCarByOwnerId(id));
        model.addAttribute("address", addressService.findByOwnerId(id));
        return "more_info_owner";
    }
}
