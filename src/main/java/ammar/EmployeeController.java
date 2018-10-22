package ammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {


    @Autowired
    EmployeeRepository employeeRepository;

    //returns all employees and balances
    @GetMapping("/employee")
    public List<Employee> index(){
        return employeeRepository.findAll();
    }
    @Autowired
    RequestRepository requestRepository;

    //Returns balance of given id
    @GetMapping("/employee/query")
    public int show(@RequestParam int id){
        Employee e = employeeRepository.findOne(id);
        return e.getBalance();
    }

    //Given a request and id, checks to see if balance of given id is less than request, if true we add that request
    //and id to request table
    @PostMapping("/employee/request")
    public Employee search(@RequestParam int request, @RequestParam int id){
        Employee e = employeeRepository.findOne(id);
        int maxID = requestRepository.findAll().size();
        Request r = new Request(id, request, maxID+1);
        if(e.getBalance() >= request){
            e.setBalance(employeeRepository.findOne(id).getBalance() - request);
            requestRepository.save(r);
            return employeeRepository.save(e);
        }
        return employeeRepository.save(e);
    }

    //Used to list out Requests the have the correspoding id that is passed in
    public List<Request> requestList(List<Request> in, int id){
        List<Request> myList = new ArrayList<>();

        for(int i = 0; i < in.size();i++){
            if (in.get(i).getRequest_id() == id){
                myList.add(in.get(i));
            }
        }
        return myList;
    }

    //Calls requestList on a given list and id
    @GetMapping("/employee/list")
    public List<Request> listthing(@RequestParam int id){
        return requestList(requestRepository.findAll(), id);
    }

    //Extra function used to list out all requests
    @GetMapping("/employee/request")
    public List<Request> getRequest(){
        return requestRepository.findAll();
    }

}