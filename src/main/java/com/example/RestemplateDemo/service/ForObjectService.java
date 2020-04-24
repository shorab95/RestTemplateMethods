package com.example.RestemplateDemo.service;

import com.example.RestemplateDemo.model.Employee;
import com.sun.jndi.toolkit.url.Uri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ForObjectService {

    Logger logger= LoggerFactory.getLogger(ForObjectService.class);
    
    @Autowired
    RestTemplate restTemplate;

    public List<Employee> getForObjectMethod() {
        List emp= restTemplate.getForObject("/getAllEmployee",List.class);
        System.out.println("User"+emp);
        return emp;
    }
    public Employee addEmployee()
    {
        Employee e = new Employee();
        e.setEmpName("Joe Root");
        e.setSalary(200000);
        e.setEmpId(2);
        return e;

    }
    public Employee addForObjectMethod() {

        Employee employee = restTemplate.postForObject("/addEmployee", addEmployee(), Employee.class);
        return employee;
    }

    public void deleteForObjectMethod() {
        restTemplate.delete("/deleteEmp/1");
        logger.info("User has been deleted");
    }

    public void updateForObject() {
        restTemplate.put("/update/kjvgh",null);
        logger.info("User has been updated");
    }
}
