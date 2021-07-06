package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.mechanicapp2.model.Address;
import pl.project.mechanicapp2.services.AddressService;
import pl.project.mechanicapp2.services.CarOwnerService;

@Controller
public class AddressController {

    private AddressService addressService;
    private CarOwnerService carOwnerService;

    public AddressController(AddressService addressService, CarOwnerService carOwnerService) {
        this.addressService = addressService;
        this.carOwnerService = carOwnerService;
    }

    @RequestMapping("/addressForm/{id}")
    public String newAddress(@PathVariable("id") Long id, Model model){
        Address address = new Address();
        address.setCarOwner(carOwnerService.getItemById(id));
        model.addAttribute("newAddress", address);
        return "new_address";
    }

    @PostMapping("/saveAddress")
    public String saveAddress(@ModelAttribute("newAddress") Address address){
        addressService.saveItem(address);
        return "redirect:/moreInfoOwner/" + address.getCarOwner().getId();
    }

    @GetMapping("/deleteAddress/{id}")
    public String deleteAddress(@PathVariable("id") Long id){
        Address address = addressService.getItemById(id);
        this.addressService.deleteItemById(id);
        return "redirect:/moreInfoOwner/" + address.getCarOwner().getId();
    }

    @GetMapping("/addressFormUpdate/{id}")
    public String updateAddress(@PathVariable("id") Long id, Model model){
        Address address = addressService.getItemById(id);
        model.addAttribute("addressUpdate", address);
        return "address_update";
    }
}
