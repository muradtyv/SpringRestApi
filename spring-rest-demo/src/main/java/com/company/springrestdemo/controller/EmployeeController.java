package com.company.springrestdemo.controller;

import com.company.springrestdemo.rest.model.dto.EmployeeDto;
import com.company.springrestdemo.rest.model.response.EmployeeResponse;
import com.company.springrestdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/employees")
//@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public EmployeeResponse getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") long id){
       return employeeService.getEmployee(id);
    }

    @GetMapping("/search")
    public EmployeeResponse getEmployeeNameAndSurname(@RequestParam("name") String name,
                                                      @RequestParam("surname") String surname){
       return employeeService.getEmployeeByNameAndSurname(name,surname);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody @Valid EmployeeDto employeeDto){
        employeeService.insert(employeeDto);
    }

    @PutMapping("/{id}")
    public void updateAll(@RequestBody EmployeeDto employeeDto,
                       @PathVariable("id") Long id){
    employeeService.update(employeeDto,id);
    }
    @PatchMapping("/{id}")
    public void updatePatch(@RequestBody EmployeeDto employeeDto,
                       @PathVariable("id") Long id){
        employeeService.updateSome(employeeDto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        employeeService.delete(id);

    }
}
