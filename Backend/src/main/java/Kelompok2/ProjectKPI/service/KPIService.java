package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.KPI;
import Kelompok2.ProjectKPI.repository.KPIRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class KPIService {

    private KPIRepository kpiRepository;

    public List<KPI> getAll(){
        return kpiRepository.findAll();
    }

    public KPI getById(Long id){
        return kpiRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"KPI is Not Found"));
    }

    public KPI create(KPI kpi){
        if(kpi.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "KPI is Already Exist");
        }
        return kpiRepository.save(kpi);
    }

    public KPI update(KPI kpi, Long id){
        getById(id);
        kpi.setId(id);
        return kpiRepository.save(kpi);
    }

    public KPI delete(Long id){
        KPI kpi = getById(id);
        kpiRepository.delete(kpi);
        return kpi;
    }
}
