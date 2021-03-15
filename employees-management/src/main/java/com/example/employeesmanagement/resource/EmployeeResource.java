package com.example.employeesmanagement.resource;

import com.example.employeesmanagement.common.Utility;
import com.example.employeesmanagement.services.EmployeeService;
import com.example.employeesmanagement.services.dto.EmployeeDTO;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Controller API resources
 */
@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private final Logger log = LoggerFactory.getLogger(EmployeeResource.class);

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * @param pageable paging configuration
     * @param request Client request
     * @return JSON Object
     */
    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> getAllEmployees(Pageable pageable, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

            Page<EmployeeDTO> pageEmployees = null;

            if (request.getParameter("size") == null || Integer.parseInt(request.getParameter("size")) <= 0) {
                pageable = Pageable.unpaged();
            }
            String aggregationType = request.getParameter("aggregationType");
            String aggregationValue = request.getParameter("aggregationValue");

            if(aggregationType !=null && !aggregationType.isEmpty() && aggregationValue !=null && !aggregationValue.isEmpty()){
                pageEmployees = employeeService.findAllEmployees(pageable);
                switch (aggregationType.toLowerCase()) {
                    case "age":
                        pageEmployees = employeeService.findAllByAge(Integer.parseInt(aggregationValue), pageable);
                        break;
                    case "education_level_id":
                        pageEmployees = employeeService.findAllByEducationLevel(Integer.parseInt(aggregationValue), pageable);
                        break;
                    case "occupation_id":
                        pageEmployees = employeeService.findAllByOccupation(Integer.parseInt(aggregationValue), pageable);
                        break;
                    default:
                        pageEmployees = employeeService.findAllEmployees(pageable);
                        break;

                }

            }else {
                pageEmployees = employeeService.findAllEmployees(pageable);
            }


            employees = pageEmployees.getContent();

            response.put("aggregationType", aggregationType==null? "No Parameter": aggregationType);
            response.put("aggregationFilter", aggregationValue==null? "No Parameter": aggregationValue);
            response.put("capital_gain_sum", employees.stream().mapToInt(EmployeeDTO::getCapital_gain).sum());
            response.put("capital_gain_avg", employees.stream().mapToInt(EmployeeDTO::getCapital_gain).average());
            response.put("capital_loss_sum", employees.stream().mapToInt(EmployeeDTO::getCapital_loss).sum());
            response.put("capital_loss_avg", employees.stream().mapToInt(EmployeeDTO::getCapital_loss).average());
            response.put("over_50k_count", employees.stream().filter(employeeDTO -> employeeDTO.isOver_50k()).count());
            response.put("under_50k_count", employees.stream().filter(employeeDTO -> !employeeDTO.isOver_50k()).count());
            return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Server Error with error is " + e.getMessage());
            return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @param pageable paging configuration
     * @param request Client request
     * @return
     */
    @GetMapping("/employees/csv")
    public ResponseEntity<Object> getAllEmployeesCSV(Pageable pageable, HttpServletRequest request) {
        try {

            if (request.getParameter("size") == null || Integer.parseInt(request.getParameter("size")) <= 0) {
                pageable = Pageable.unpaged();
            }
            List<EmployeeDTO> employeesData = new ArrayList<EmployeeDTO>();

            Page<EmployeeDTO> pageEmployees = null;

            pageEmployees = employeeService.findAllEmployees(pageable);

            employeesData = pageEmployees.getContent();

            if (Utility.writeDataToFile(employeesData)) {
                InputStreamResource resource = new InputStreamResource(new FileInputStream(Utility.file));
                DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
                String currentDateTime = dateFormatter.format(new Date());
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=EmployeesData_" + currentDateTime + ".csv")
                        .contentType(MediaType.parseMediaType("application/csv"))
                        .body(resource);
            } else {
                return new ResponseEntity<>("{}", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
