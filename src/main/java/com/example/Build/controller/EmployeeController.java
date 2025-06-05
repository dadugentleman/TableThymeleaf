package com.example.Build.controller;

import ch.qos.logback.core.model.Model;
import com.example.Build.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import com.thymeleaf.demo.model.Employee;

@Controller
@RequestMapping("/employee")

public class EmployeeController {

    private List<Employee> listEmployees;

    @PostConstruct
    private void loadData() {
        Employee employee1 = new Employee(1, "Vasile", "Spinu", "vasile20@gmail.com");
        Employee employee2 = new Employee(2, "Maxim", "Dimitru", "maxim10@gmail.com");
        Employee employee3 = new Employee(3, "Ion", "Vataman", "ion39@gmail.com");
        Employee employee4 = new Employee(4, "Sandu", "Guzun", "sandu9@gmail.com");

        listEmployees = new ArrayList<>();

        listEmployees.add(employee1);
        listEmployees.add(employee2);
        listEmployees.add(employee3);
        listEmployees.add(employee4);


    }

    @GetMapping("/list")
    public String showEmployees(Model model) {
        model.addAttribute("employees", listEmployees);
        return "employees-list";
    }



}
