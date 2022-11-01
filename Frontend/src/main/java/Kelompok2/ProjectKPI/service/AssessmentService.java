package Kelompok2.ProjectKPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.dto.request.AssessmentRequest;

@Service
public class AssessmentService {
    
    private RestTemplate restTemplate;

    @Value("${server.baseUrl}/assessment")
    private String url;

    @Autowired
    public AssessmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Assessment> getAll(){
        return restTemplate.exchange(url, HttpMethod.GET,null, new ParameterizedTypeReference<List<Assessment>>() {}).getBody();
    }

    public Assessment getById(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.GET,null, new ParameterizedTypeReference<Assessment>() {}).getBody();
    }

    public Assessment create(AssessmentRequest assessmentRequest){
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(assessmentRequest), new ParameterizedTypeReference<Assessment>() {}).getBody();
    }

    public Assessment update(AssessmentRequest assessmentRequest, Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT, new HttpEntity(assessmentRequest), new ParameterizedTypeReference<Assessment>() {}).getBody();
    }

    public Assessment delete(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, null, new ParameterizedTypeReference<Assessment>() {
        }).getBody();
    }

    public List<Assessment> getByKPI(Long id){
        return restTemplate.exchange(url + "/kpi/" + id , HttpMethod.GET,null, new ParameterizedTypeReference<List<Assessment>>(){}).getBody();
    }

    public Integer sumScore(Long id){
        return restTemplate.exchange(url + "/sum/" + id, HttpMethod.GET,null, new ParameterizedTypeReference<Integer>(){}).getBody();
    }



}
