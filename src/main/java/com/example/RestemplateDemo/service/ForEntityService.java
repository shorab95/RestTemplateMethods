package com.example.RestemplateDemo.service;

import com.example.RestemplateDemo.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ForEntityService {

    Logger logger= LoggerFactory.getLogger(ForEntityService.class);

    @Autowired
    RestTemplate restTemplate;

    public List<Employee> getForEntityMethod() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/getAllEmployee",List.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        logger.info("Status Code:"+httpStatus);
        List employee = responseEntity.getBody();
        logger.info("body"+employee);
        HttpHeaders responseHeaders=responseEntity.getHeaders();
        logger.info("Header are "+responseHeaders);
        return employee;

    }
    public Employee addEmployee()
    {
        Employee e = new Employee();
        e.setEmpName("Ben Stokes");
        e.setSalary(200000);
        e.setEmpId(1);
        return e;

    }

    public Employee addForEntityMethod() {

        ResponseEntity<Employee> responseEntity = restTemplate.postForEntity("/addEmployee",addEmployee(),Employee.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        logger.info("Status Code:"+httpStatus);
        Employee employee = responseEntity.getBody();
        logger.info("body"+employee);
        HttpHeaders responseHeaders=responseEntity.getHeaders();
        logger.info("Header are "+responseHeaders);
        return employee;
    }

    public void deleteForEntityMethod() {
        restTemplate.delete("/deleteEmp/1");
        logger.info("User has been deleted");
    }

    public void updateForEntity() {
        restTemplate.put("/update/kjvgh",null);
        logger.info("User has been updated");
    }
}

