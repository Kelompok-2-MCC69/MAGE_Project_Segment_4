package Kelompok2.ProjectKPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Kelompok2.ProjectKPI.model.KPI;

@Service
public class KPIService {
    private RestTemplate restTemplate;

    @Value("${server.baseUrl}/kpi")
    private String url;

    @Autowired
    public KPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<KPI> getAll(){
        return restTemplate.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<KPI>>(){}).getBody();
    }

    public KPI getById(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.GET,null,new ParameterizedTypeReference<KPI>() {}).getBody();
    }

    public KPI create(KPI kpi){
        return restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(kpi), new ParameterizedTypeReference<KPI>() {}).getBody();
    }

    public KPI update(KPI kpi,Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT,new HttpEntity(kpi), new ParameterizedTypeReference<KPI>(){}).getBody();
    }

    public KPI delete(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE,null, new ParameterizedTypeReference<KPI>() {}).getBody();
    }
}
