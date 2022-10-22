package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Role;
import Kelompok2.ProjectKPI.model.User;
import Kelompok2.ProjectKPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PostMapping("{id}")
    public User addRole(@RequestBody Role role, @PathVariable Long id){
        return userService.addRole(role,id);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user,@PathVariable Long id){
        return userService.update(user,id);
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable Long id){
        return userService.delete(id);
    }

}
