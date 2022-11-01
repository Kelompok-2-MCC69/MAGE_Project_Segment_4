package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.dto.request.AssessmentRequest;
import Kelompok2.ProjectKPI.repository.AssessmentsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
@AllArgsConstructor
public class AssessmentService {

    private ModelMapper modelMapper;
    private KPIService kpiService;
    private AssessmentsRepository assessmentsRepository;
    private UserService userService;
    private JavaMailSender mailSender;
    private EmployeeService employeeService;

    public List<Assessment> getAll(){
        return assessmentsRepository.findAll();
    }

    public Assessment getById(Long id){
        return assessmentsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Assessment is Not Found"));
    }

    public List<Assessment> getByKPI(Long id){
        return assessmentsRepository.getByKPI(id);
    }

    public Assessment create(AssessmentRequest assessmentRequest) throws MessagingException{
        Assessment assessment = modelMapper.map(assessmentRequest,Assessment.class);
        assessment.setKpi(kpiService.getById(assessmentRequest.getKpiId()));
        
        MimeMessage MimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(MimeMessage, true);
        
        String text = "This is A new Assement";
        
        helper.setTo(userService.getById(kpiService.getById(assessmentRequest.getKpiId()).getEmployee().getId()).getEmployee().getEmail());
        helper.setSubject("New Assesment");
        helper.setText(text, true);
        mailSender.send(MimeMessage);
        return assessmentsRepository.save(assessment);
    }

    public Assessment update(AssessmentRequest assessmentRequest, Long id) throws MessagingException{
        Assessment assessment = modelMapper.map(assessmentRequest,Assessment.class);
        getById(id);
        assessment.setId(id);
        assessment.setKpi(kpiService.getById(assessmentRequest.getKpiId()));
        
        MimeMessage MimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(MimeMessage, true);
        
        String text = "This is Update Assesment";
        
        helper.setTo(userService.getById(kpiService.getById(assessmentRequest.getKpiId()).getEmployee().getId()).getEmployee().getEmail());
        helper.setSubject("New Assesment");
        helper.setText(text, true);
        mailSender.send(MimeMessage);
        
        
        
        return assessmentsRepository.save(assessment);
    }

    public Assessment delete(Long id){
        Assessment assessment = getById(id);
        assessmentsRepository.delete(assessment);
        return assessment;
    }

    public Integer sumScore(Long id){
        return assessmentsRepository.sumScore(id);
    }

}

