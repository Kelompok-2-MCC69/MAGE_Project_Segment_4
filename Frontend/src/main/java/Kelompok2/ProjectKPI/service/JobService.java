package Kelompok2.ProjectKPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Kelompok2.ProjectKPI.model.Job;

@Service
public class JobService {
    
    private RestTemplate restTemplate;

    @Value("${server.baseUrl}/job")
    private String url;

    @Autowired
    public JobService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Job> getAll(){
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<Job>>() {}).getBody();
    }

    public Job getById(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.GET,null,new ParameterizedTypeReference<Job>() {}).getBody();
    }

    public Job create(Job job){
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(job), new ParameterizedTypeReference<Job>() {}).getBody();
    }

    public Job update(Job job,Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT,new HttpEntity(job), new ParameterizedTypeReference<Job>(){}).getBody();
    }

    public Job delete(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE,null, new ParameterizedTypeReference<Job>() {}).getBody();
    }
}
