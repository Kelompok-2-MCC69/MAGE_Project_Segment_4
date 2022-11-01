package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.User;
import Kelompok2.ProjectKPI.model.dto.request.LoginRequest;
import Kelompok2.ProjectKPI.model.dto.response.LoginResponse;
import Kelompok2.ProjectKPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoginService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private AppUserDetailService appUserDetailService;

    public LoginResponse login(LoginRequest loginRequest){

        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),loginRequest.getPassword());

        Authentication auth = authenticationManager.authenticate(authReq);

        SecurityContextHolder.getContext().setAuthentication(auth);

        UserDetails userDetails = appUserDetailService.loadUserByUsername(loginRequest.getUsername());

        User user = userRepository.findByUsernameOrEmployee_Email(loginRequest.getUsername(), loginRequest.getUsername()).get();

        List<String> authorities = userDetails.getAuthorities().stream().map(authority -> authority.getAuthority()).
                collect(Collectors.toList());

        return new LoginResponse(user.getUsername(), user.getEmployee().getEmail(),authorities);

    }

}
