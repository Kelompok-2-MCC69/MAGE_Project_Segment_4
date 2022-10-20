package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.History;
import Kelompok2.ProjectKPI.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {

    private HistoryRepository historyRepository;

    public List<History> getAll(){
        return historyRepository.findAll();
    }

    public History getById(Long id){
        return historyRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "History is Not Found"));
    }

    public History create(History history){
        if(history.getId() != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"History is Already Exist");
        }
        return historyRepository.save(history);
    }

    public History update(History history, Long id){
        getById(id);
        history.setId(id);
        return historyRepository.save(history);
    }

    public History delete(Long id){
        History history = getById(id);
        historyRepository.delete(history);
        return history;
    }
}
