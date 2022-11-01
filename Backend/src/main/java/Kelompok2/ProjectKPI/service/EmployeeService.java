package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.*;
import Kelompok2.ProjectKPI.model.dto.request.EmployeeRequest;
import Kelompok2.ProjectKPI.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    private JobService jobService;
    private ModelMapper modelMapper;

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee is Not Found"));
    }

    public Employee create(EmployeeRequest employeeRequest){

    //Set Employee
    Employee employee = modelMapper.map(employeeRequest,Employee.class);

    //Set User
    User user = modelMapper.map(employeeRequest,User.class);

    user.setPassword(passwordEncoder.encode(employeeRequest.getPassword()));

    //Set Role
    List<Role> roles =new ArrayList<>();
    roles.add(roleService.getById(1L));

    user.setRoles(roles);
    user.setEmployee(employee);
    employee.setUser(user);
    return employeeRepository.save(employee);
    }

    public Employee update(EmployeeRequest employeeRequest,Long id){
        Employee employee = modelMapper.map(employeeRequest,Employee.class);
        getById(id);
        employee.setId(id);
        employee.setUser(employee.getUser());
        employee.setManager(employeeRepository.findByName(employeeRequest.getManagerName()));
        return employeeRepository.save(employee);
    }

    public Employee delete(Long id){
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

    public Employee addManager(Employee employee,Long id){
        Employee newEmployee = getById(id);
        Employee manager = getById(employee.getId());
        newEmployee.setManager(manager);
        return employeeRepository.save(newEmployee);
    }

    public Employee addJob(Job job, Long id){
        Employee newEmployee = getById(id);
        Job jobEmployee = jobService.getById(job.getId());
        newEmployee.setJob(jobEmployee);
        return employeeRepository.save(newEmployee);
    }

}
