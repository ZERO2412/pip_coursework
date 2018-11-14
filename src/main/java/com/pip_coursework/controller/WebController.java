package com.pip_coursework.controller;

import com.pip_coursework.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pip_coursework.entity.Customer;

@RestController
public class WebController {
    @Autowired
    CustomerRepository repository;

    @RequestMapping("/save")
    public String process(){
        // save a single Customer
        repository.save(new Customer("Jack", "Smith"));

        return "Done";
    }


    @RequestMapping("/findall")
    public String findAll(){
        String result = "";

        for(Customer cust : repository.findAll()){
            result += cust.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findById(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "";

        for(Customer cust: repository.findByLastName(lastName)){
            result += cust.toString() + "<br>";
        }

        return result;
    }
}
