package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.mechanicapp2.model.Repair;
import pl.project.mechanicapp2.services.CarService;
import pl.project.mechanicapp2.services.RepairService;

@Controller
public class RepairController {

    private RepairService repairService;
    private CarService carService;

    public RepairController(RepairService repairService, CarService carService) {
        this.repairService = repairService;
        this.carService = carService;
    }

    @RequestMapping("/repairForm/{id}")
    public String newRepair(@PathVariable("id") Long id, Model model){
        Repair repair = new Repair();
        repair.setCar(carService.getItemById(id));
        model.addAttribute("newRepair", repair);
        return "new_car";
    }

    @PostMapping("/saveRepair")
    public String saveRepair(@ModelAttribute("newRepair") Repair repair){

    }
}
