package org.example.controller;

import org.example.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class UserController {
    @GetMapping("list")
    public String getOrderList(Model model) {
        model.addAttribute("userList", new UserDao().getList());
        return "index";
    }
}
