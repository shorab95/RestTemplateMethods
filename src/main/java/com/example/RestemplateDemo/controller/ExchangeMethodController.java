package com.example.RestemplateDemo.controller;

import com.example.RestemplateDemo.model.Employee;
import com.example.RestemplateDemo.service.ExchangeMethodService;
import com.example.RestemplateDemo.service.ForEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExchangeMethodController {

    @Autowired
    private ExchangeMethodService restDemoService;

    @GetMapping("/exchangeForGetDemo")
    public List<Employee> getAllEmployee()
    {
     return restDemoService.useExchangeMethodOfRestTemplateToGetEmployee();
    }


      @GetMapping("/exchangeForPost")
      public Employee exchangeForPost()
      {
          return restDemoService. exchangeMethodForPost();
      }
      @GetMapping("/exchangeForDelete")
      public void exchangeForDelete()
      {
          restDemoService.exchangeForDelete();
      }
    @GetMapping("/exchangeForUpdate")
    public void exchangeForUpdate()
    {
        restDemoService.exchangeForUpdate();
    }

}
