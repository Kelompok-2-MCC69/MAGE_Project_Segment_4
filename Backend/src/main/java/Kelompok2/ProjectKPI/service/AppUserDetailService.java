package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.AppUserDetail;
import Kelompok2.ProjectKPI.model.User;
import Kelompok2.ProjectKPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmployee_Email(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("Username or Password Incorrect"));
        return new AppUserDetail(user);
    }
}
