package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.entity.UserEntity;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class AuthController {
    private final UserDao userDao;


    @PostMapping("/register")
    public String register(
            Model model,
            @ModelAttribute UserRegisterRequest userRegisterRequest
    ) {
        UserEntity save = userDao.save(userRegisterRequest);
        return save != null ? "login" : "register";
    }

    @PostMapping("/login")
    public String login(
            Model model,
            HttpServletRequest httpServletRequest,
            @ModelAttribute UserLoginRequest loginRequest

    ) {
        boolean condition;
        UserEntity currentUser = userDao.login(loginRequest);
        if(currentUser==null){
            condition = true;
            model.addAttribute("condition",condition);
            return "index";
        }
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userId",currentUser.getId());
        model.addAttribute("message", "username or password is incorrect");
        model.addAttribute("user", currentUser);
        return "home";
    }

//    @GetMapping("/logOut")
//    public String logOut(HttpServletRequest req){
//        req.getSession().setAttribute("userId",null);
//        req.getSession().setMaxInactiveInterval(0);
//        return "/index";
//    }
}