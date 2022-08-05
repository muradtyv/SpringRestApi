package com.company.springrestdemo.service;

import com.company.springrestdemo.rest.model.dto.EmployeeDto;
import com.company.springrestdemo.rest.model.response.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse getAllEmployees();

    EmployeeDto getEmployee(Long id);

    EmployeeResponse getEmployeeByNameAndSurname(String name, String surname);

    void insert(EmployeeDto employeeDto);

    void update(EmployeeDto employeeDto, long id);

    void updateSome(EmployeeDto employeeDto, Long id);

    void delete(long id);
}
