package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.dto.request.LoginRequest;
import Kelompok2.ProjectKPI.model.dto.response.LoginResponse;
import Kelompok2.ProjectKPI.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginService.login(loginRequest);
    }
}
