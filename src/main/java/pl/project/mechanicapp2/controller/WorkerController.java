package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.mechanicapp2.services.AddressService;
import pl.project.mechanicapp2.services.WorkerPDService;


@Controller
public class WorkerController {

    private WorkerPDService workerPDService;
    private AddressService addressService;

    public WorkerController(WorkerPDService workerPDService, AddressService addressService) {
        this.workerPDService = workerPDService;
        this.addressService = addressService;
    }

    @GetMapping("/workersPD")
    public String showPDWorker(Model model){
        model.addAttribute("workersPDList", workerPDService.findAllItems());
        return "admin_templates/show_workers";
    }

}
