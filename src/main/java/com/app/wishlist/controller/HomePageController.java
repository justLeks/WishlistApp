package com.app.wishlist.controller;

import com.app.wishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class HomePageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showHomePage() {
        return "homePage";
    }

    @RequestMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @RequestMapping("/newwish")
    public String showNewWishPage() {
        return "newWish";
    }

    @RequestMapping("personalroom")
    public String showPersonalRoomPage(Model model, Principal principal) {
        int idUser = userService.findByEmail(principal.getName()).getIdUser();
        String userEmail = principal.getName();

        model.addAttribute("idUser", idUser);
        model.addAttribute("userEmail", userEmail);

        return "personalRoom";
    }

    @RequestMapping(value = "/friend", params = {"id"})
    public String showFriendPage(@RequestParam int id, Model model, Principal principal) {
        int idUser = userService.findByEmail(principal.getName()).getIdUser();

        model.addAttribute("myId", idUser);
        model.addAttribute("id", id);

        return "friendPage";
    }
}
