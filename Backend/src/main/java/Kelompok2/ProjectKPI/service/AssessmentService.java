package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.repository.AssessmentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class AssessmentService {

    private AssessmentsRepository assessmentsRepository;

    public List<Assessment> getAll(){
        return assessmentsRepository.findAll();
    }

    public Assessment getById(Long id){
        return assessmentsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Assessment is Not Found"));
    }

    public Assessment create(Assessment assessment){
        if(assessment.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Assessment is Already Exist");
        }
        if(assessmentsRepository.findByIndicator(assessment.getIndicator()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Assessment is Already Exist");
        }
        return assessmentsRepository.save(assessment);
    }

    public Assessment update(Assessment assessment, Long id){
        getById(id);
        assessment.setId(id);
        return assessmentsRepository.save(assessment);
    }

    public Assessment delete(Long id){
        Assessment assessment = getById(id);
        assessmentsRepository.delete(assessment);
        return assessment;
    }
}

