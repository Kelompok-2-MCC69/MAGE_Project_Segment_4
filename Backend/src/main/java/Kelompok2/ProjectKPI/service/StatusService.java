package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Status;
import Kelompok2.ProjectKPI.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class StatusService {

    private StatusRepository statusRepository;

    public List<Status> getAll(){
        return statusRepository.findAll();
    }

    public Status getById(Long id){
        return statusRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Status is Not Found"));
    }

    public Status create(Status status){
        if(status.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Status is Already Exist");
        }
        if(statusRepository.findByName(status.getName()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Status is Already Exist");
        }
        return statusRepository.save(status);
    }

    public Status update(Status status, Long id){
        getById(id);
        status.setId(id);
        return statusRepository.save(status);
    }

    public Status delete(Long id){
        Status status = getById(id);
        statusRepository.delete(status);
        return status;
    }
}
