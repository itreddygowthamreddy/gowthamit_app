package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import beans.User;
import service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showIndexForm(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "index";
    }

    @PostMapping("/save")
    public String handleSubmitButton(@ModelAttribute("user") User user, Model model) {
        String msg = userService.saveOrUpdateUserAcc(user);
        model.addAttribute("msg", msg);
        return "view";

    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> userList = userService.getAllUserAcc();
        model.addAttribute("users", userList);
        return "view";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") Integer sno, Model model) {
        User user = userService.getUserAcc(sno);
        model.addAttribute("msg", "User updated succussfully ");
        return "forward:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer sno, Model model) {
        String deleteUser = userService.deleteUser(sno);
        model.addAttribute("msg", deleteUser);
        return "forward:/users";

    }

    @GetMapping("/status")
    public String changeAccStatus(@RequestParam("id") Integer sno, @RequestParam("status") String status, Model model) {
        userService.userActionStatus(sno, status);

        return "forward:/users";
    }


}
