package com.example.RestemplateDemo.controller;

import com.example.RestemplateDemo.model.Employee;
import com.example.RestemplateDemo.service.ForEntityService;
import com.example.RestemplateDemo.service.ForObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ForObjectController {
    @Autowired
    private ForObjectService forObjectService;

    @GetMapping("/getForObjectMethod")
    public List<Employee> getForObjectMethod()
    {
        return  forObjectService. getForObjectMethod();
    }

    @GetMapping("/addForObjectMethod")
    public Employee addForObjectMethod()
    {
        return  forObjectService. addForObjectMethod();
    }
    @GetMapping("/deleteForObjectMethod")
    public void deleteForObjectMethod()
    {
        forObjectService.deleteForObjectMethod();
    }
    @GetMapping("/updateForObject")
    public void updateForObject()
    {
        forObjectService.updateForObject();
    }
}
