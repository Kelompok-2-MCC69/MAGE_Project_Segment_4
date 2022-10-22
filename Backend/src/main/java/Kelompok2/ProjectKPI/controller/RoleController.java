package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Role;
import Kelompok2.ProjectKPI.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public List<Role> getAll(){
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Long id){
        return roleService.getById(id);
    }

    @PostMapping
    public Role create(@RequestBody Role role){
        return roleService.create(role);
    }

    @PutMapping("/{id}")
    public Role update(@RequestBody Role role, @PathVariable Long id){
        return roleService.update(role,id);
    }

    @DeleteMapping("/{id}")
    public Role delete(@PathVariable Long id){
        return roleService.delete(id);
    }
}
