package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Role;
import Kelompok2.ProjectKPI.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role getById(Long id){
        return roleRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Role id Not Found"));
    }

    public Role create(Role role){
        if(role.getId()!=null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Role is Already Exist");
        }
        if(roleRepository.findByName(role.getName()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Role Name is Already Exist");
        }
        role.setName(role.getName().substring(0,1).toUpperCase() + role.getName().substring(1));
        return roleRepository.save(role);
    }

    public Role update(Role role, Long id){
        getById(id);
        role.setId(id);
        return roleRepository.save(role);
    }

    public Role delete(Long id){
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }

}
