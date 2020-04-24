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
public class ExchangeMethodService {
    Logger logger= LoggerFactory.getLogger(ExchangeMethodService.class);

    @Autowired
    private RestTemplate restTemplate;

    public HttpEntity<Object> getRequestEntity(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(httpHeaders);
    }

    public List<Employee> useExchangeMethodOfRestTemplateToGetEmployee() {

        ResponseEntity<List> responseEntity = restTemplate.exchange("/getAllEmployee", HttpMethod.GET,getRequestEntity(), List.class);
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
        e.setEmpName("Eoin Morgan");
        e.setSalary(200000);
        return e;

    }

    public Employee exchangeMethodForPost() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity;
        Employee emp=addEmployee();
        requestEntity=new HttpEntity<>(emp,httpHeaders);
        ResponseEntity<Employee> responseEntity = restTemplate.exchange("/addEmployee", HttpMethod.POST, requestEntity, Employee.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        logger.info("Status Code:"+httpStatus);
        Employee employee = responseEntity.getBody();
        logger.info("body"+employee);
        HttpHeaders responseHeaders=responseEntity.getHeaders();
        logger.info("Header are "+responseHeaders);
        return employee;

    }

    public void exchangeForDelete() {

        ResponseEntity<Employee> responseEntity=restTemplate.exchange("/deleteEmp/0", HttpMethod.DELETE, getRequestEntity(), Employee.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        logger.info("Status Code:"+httpStatus);
    }
    public void exchangeForUpdate()
    {

        ResponseEntity<Employee> responseEntity=restTemplate.exchange("/update/Eoin Morgan/50000", HttpMethod.PUT, getRequestEntity(), Employee.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        logger.info("Status Code:"+httpStatus);
        Employee employee = responseEntity.getBody();
        logger.info("body"+employee);
        HttpHeaders responseHeaders=responseEntity.getHeaders();
        logger.info("Header are "+responseHeaders);

    }
}
