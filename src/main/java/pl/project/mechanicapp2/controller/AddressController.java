package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import pl.project.mechanicapp2.services.AddressService;

@Controller
public class AddressController {

    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


}
