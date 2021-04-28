package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.mechanicapp2.services.AddressService;

@Controller
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public String viewAddress(Model model) {
        model.addAttribute("addressesList", addressService.findAllItems());
        return "addresses";
    }

}
