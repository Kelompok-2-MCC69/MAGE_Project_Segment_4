package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Job;
import Kelompok2.ProjectKPI.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class JobService {

    private JobRepository jobRepository;

    public List<Job> getAll(){
        return jobRepository.findAll();
    }

    public Job getById(Long id){
        return jobRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Job is Not Found"));
    }

    public Job create(Job job){
        if(job.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Job is Already Exist");
        }
        if(jobRepository.findByTitle(job.getTitle()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Job Title is Already Exist");
        }
        return jobRepository.save(job);
    }

    public Job update(Job job, Long id){
        getById(id);
        job.setId(id);
        return jobRepository.save(job);
    }

    public Job delete(Long id){
        Job job = getById(id);
        jobRepository.delete(job);
        return job;
    }
}
