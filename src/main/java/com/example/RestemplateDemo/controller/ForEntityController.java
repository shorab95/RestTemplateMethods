package com.example.RestemplateDemo.controller;

import com.example.RestemplateDemo.model.Employee;
import com.example.RestemplateDemo.service.ForEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ForEntityController {

    @Autowired
    private ForEntityService forEntityService;

    @GetMapping("/getForEntityMethod")
    public List<Employee> getForEntityMethod()
    {
        return  forEntityService. getForEntityMethod();
    }

    @GetMapping("/addForEntityMethod")
    public Employee addForEntityMethod()
    {
        return  forEntityService. addForEntityMethod();
    }
    @GetMapping("/deleteForEntityMethod")
    public void deleteForEntityMethod()
    {
        forEntityService.deleteForEntityMethod();
    }
    @GetMapping("/updateForEntity")
    public void updateForEntity()
    {
        forEntityService.updateForEntity();
    }
}
