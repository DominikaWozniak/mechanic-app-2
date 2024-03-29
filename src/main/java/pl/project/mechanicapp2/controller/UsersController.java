package pl.project.mechanicapp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.mechanicapp2.model.Users;
import pl.project.mechanicapp2.services.UsersService;

@Controller
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public String viewUsers(Model model){
        model.addAttribute("usersList", usersService.findAllItems());
        return "admin_templates/users_list";
    }

    @GetMapping("/userForm")
    public String newUserForm(Model model){
        Users users = new Users();
        model.addAttribute("newUser", users);
        return "admin_templates/new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") Users users){
        usersService.saveItem(users);
        return "redirect:/users";
    }

    @GetMapping("/formUpdateUser/{id}")
    public String formUpdateUser(@PathVariable (value = "id")  Long id, Model model){
        Users users = usersService.getItemById(id);

        model.addAttribute("user", users);
        return "admin_templates/update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") Long id){
        this.usersService.deleteItemById(id);
        return "redirect:/users";
    }

}
