package Kelompok2.ProjectKPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Kelompok2.ProjectKPI.model.Employee;

@Service
public class EmployeeService {
    
    private RestTemplate restTemplate;
    
    @Value("${server.baseUrl}/employee")
    private String url;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAll(){
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){}).getBody();
    }

    public Employee getById(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.GET,null,new ParameterizedTypeReference<Employee>() {}).getBody();
    }

    public Employee create(Employee employee){
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(employee), new ParameterizedTypeReference<Employee>() {}).getBody();
    }

    public Employee update(Employee employee,Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT,new HttpEntity(employee), new ParameterizedTypeReference<Employee>(){}).getBody();
    }

    public Employee delete(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE,null, new ParameterizedTypeReference<Employee>() {}).getBody();
    }

}
