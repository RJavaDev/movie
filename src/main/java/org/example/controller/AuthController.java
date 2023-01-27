package org.example.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserRegisterRequest;
import org.example.model.UserEntity;
import org.example.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("")
    public String main(){
        return "login/login";
    }

    @PostMapping("register")
    public String register(
            Model model,
            @ModelAttribute UserRegisterRequest userRegisterRequest
    ) {
        boolean save = authService.addUser(userRegisterRequest);
        return "login/login";
    }


    @PostMapping("login")
    public String login(
            HttpServletRequest request,
            Model model
    ) {
        UserEntity currentUser = authService.login(request);
        String attribute = request.getParameter("userName");
        if (currentUser != null) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("userId", currentUser.getId());
        } else if (attribute != null) {
            model.addAttribute("text", "INCORRECT PASSWORD OR PHONE NUMBER");
            return "login/login";
        }
        return "login/login";
    }
}
