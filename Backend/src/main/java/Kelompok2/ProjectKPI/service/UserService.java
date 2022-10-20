package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Role;
import Kelompok2.ProjectKPI.model.User;
import Kelompok2.ProjectKPI.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private RoleService roleService;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User is Not Found"));
    }

    public User update(User user,Long id){
        User newUser = getById(id);
        user.setId(id);
        user.setEmployee(newUser.getEmployee());
        user.setRoles(newUser.getRoles());

        return userRepository.save(user);
    }

    public User delete(Long id){
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

    public User addRole(Role role, Long id){
        User oldUser = getById(id);
        List<Role> roles = oldUser.getRoles();
        roles.add(roleService.getById(role.getId()));
        oldUser.setRoles(roles);
        return userRepository.save(oldUser);
    }
}
