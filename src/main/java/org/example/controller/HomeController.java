package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final UserDao userDao;
    @GetMapping("home")
    public String home(){
        return "home";
    }
    @GetMapping("list")
    public ModelAndView list(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("userList",userDao.findAll());
//        request.setAttribute("userList", userDao.findAll());
        return modelAndView;
    }
}
