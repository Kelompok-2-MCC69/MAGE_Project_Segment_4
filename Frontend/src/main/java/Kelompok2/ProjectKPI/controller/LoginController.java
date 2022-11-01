package Kelompok2.ProjectKPI.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Kelompok2.ProjectKPI.model.dto.request.LoginRequest;
import Kelompok2.ProjectKPI.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {
    
    private LoginService loginService;

    //mengambil halaman login
    @GetMapping
    public String formLogin(LoginRequest loginRequest, Authentication authentication){
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "auth/login";
        }
        return "redirect:/employee";
    }

    @PostMapping
    public String login(LoginRequest loginRequest){
        if(!loginService.login(loginRequest)){
            return "redirect:/login?error=true";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<String> roles = authentication.getAuthorities().stream()
        .map(authority -> authority.getAuthority())
        .collect(Collectors.toList());

        for (String role : roles) {
            if(role.equals("ROLE_MANAGER")){
                return "redirect:/employee";
            }
            if(role.equals("ROLE_EMPLOYEE")){
                return "redirect:/kpi";
            }
        }

        return "redirect:/employee";   
    }
}
