package Kelompok2.ProjectKPI.service;

import java.util.List;
import java.util.concurrent.Exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Kelompok2.ProjectKPI.model.KPI;
import Kelompok2.ProjectKPI.model.dto.request.KpiRequest;

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

    public KPI update(KpiRequest kpiRequest,Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.PUT,new HttpEntity(kpiRequest), new ParameterizedTypeReference<KPI>(){}).getBody();
    }

    public KPI delete(Long id){
        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE,null, new ParameterizedTypeReference<KPI>() {}).getBody();
    }

    public List<KPI> getMyKPI(String name){
        return restTemplate.exchange(url + "/myKpi/" + name, HttpMethod.GET,null,new ParameterizedTypeReference<List<KPI>>() {}).getBody();
    }
}
