package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Employee;
import Kelompok2.ProjectKPI.model.KPI;
import Kelompok2.ProjectKPI.model.dto.request.KPIRequest;
import Kelompok2.ProjectKPI.repository.KPIRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@AllArgsConstructor
@Service
public class KPIService {

    private KPIRepository kpiRepository;
    private EmployeeService employeeService;
    private ModelMapper modelMapper;
    private UserService userService;
    private JavaMailSender mailSender;

    public List<KPI> getAll(){

        return kpiRepository.findAll();
    }

    public KPI getById(Long id){
        return kpiRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"KPI is Not Found"));
    }

    public KPI create(KPIRequest kpiRequest) throws MessagingException{
        KPI kpi = new KPI();
        kpi.setCreated_at(LocalDate.now());
        kpi.setFirst_deadline(kpi.getCreated_at().plusYears(1));
        kpi.setSecond_deadline(kpi.getFirst_deadline().plusMonths(1));
        kpi.setYear(kpi.getCreated_at().getYear());
        kpi.setEmployee(employeeService.getById(kpiRequest.getEmployeeId()));
        kpi.setManager(employeeService.getById(kpiRequest.getManagerId()));
        
        MimeMessage MimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(MimeMessage, true);
        String text = "This is A new Assement";
        helper.setTo(userService.getById(kpiRequest.getEmployeeId()).getEmployee().getEmail());
        helper.setSubject("New Assesment");
        helper.setText(text, true);
        mailSender.send(MimeMessage);
        
        
        
        return kpiRepository.save(kpi);
    }

    public KPI update(KPIRequest kpiRequest, Long id) throws MessagingException{
        KPI kpi = getById(id);
        kpi.setId(id);
        kpi.setFinal_score(kpiRequest.getFinal_score());
        kpi.setManager(employeeService.getById(kpiRequest.getManagerId()));
        kpi.setEmployee(employeeService.getById(kpiRequest.getEmployeeId()));
        
        MimeMessage MimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(MimeMessage, true);
        String text = "This is A new Assement";
        helper.setTo(userService.getById(kpiRequest.getEmployeeId()).getEmployee().getEmail());
        helper.setSubject("New Assesment");
        helper.setText(text, true);
        mailSender.send(MimeMessage);
        
        
        return kpiRepository.save(kpi);
    }

    public KPI delete(Long id){
        KPI kpi = getById(id);
        kpiRepository.delete(kpi);
        return kpi;
    }

    public KPI addEmployee(Employee employee, Long id){
        KPI newKpi = getById(id);
        Employee employeeKPI = employeeService.getById(employee.getId());
        newKpi.setEmployee(employeeKPI);
        return kpiRepository.save(newKpi);
    }

    public KPI addManager(Employee manager, Long id){
        KPI newKpi = getById(id);
        Employee managerKPI = employeeService.getById(manager.getId());
        newKpi.setEmployee(managerKPI);
        return kpiRepository.save(newKpi);
    }

    public List<KPI> getMyKpi(Long id){
        return kpiRepository.getByMyKpi(id);
    }


}
