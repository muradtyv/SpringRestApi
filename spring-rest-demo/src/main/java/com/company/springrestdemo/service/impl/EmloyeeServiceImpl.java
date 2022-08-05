package com.company.springrestdemo.service.impl;

import com.company.springrestdemo.enums.ErrorCodeEnum;
import com.company.springrestdemo.exception.CustomRestException;
import com.company.springrestdemo.model.Employee;
import com.company.springrestdemo.repository.EmployeeRepository;
import com.company.springrestdemo.rest.model.dto.EmployeeDto;
import com.company.springrestdemo.rest.model.response.EmployeeResponse;
import com.company.springrestdemo.service.EmployeeService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class EmloyeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse getAllEmployees() {
          List<EmployeeDto> employeeDtoList = employeeRepository.findAll()
                    .stream()
                    .map(employee -> convertDto(employee))
                    .collect(Collectors.toList());

          return makeEmployyeresponse(employeeDtoList);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        return employeeRepository.findById(id)
                .map(employee -> convertDto(employee))
                .orElseThrow(() -> new CustomRestException(ErrorCodeEnum.CAN_NOT_FIND_EMPLOYEE));
    }

    @Override
    public EmployeeResponse getEmployeeByNameAndSurname(String name, String surname) {
      List<EmployeeDto> employees =  employeeRepository.findByNameAndSurname(name,surname)
                .stream()
                .map(employee -> convertDto(employee))
                .collect(Collectors.toList());

      return makeEmployyeresponse(employees);

    }

    @Override
    public void insert(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employeeRepository.save(employee);
    }

    @Override
    public void update(EmployeeDto employeeDto, long id) {
       Employee employee = getEmployeeId(id);

//        BeanUtils.copyProperties(employeeDto,employee);
//        employee.setId(id);
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setAge(employeeDto.getAge());
        employee.setSalary(employeeDto.getSalary());
        employeeRepository.save(employee);
    }

    @Override
    public void updateSome(EmployeeDto employeeDto, Long id) {
        Employee employee = getEmployeeId(id);

//        BeanUtils.copyProperties(employeeDto,employee);
//        employee.setId(id);

        if(employeeDto.getName()!=null )
        employee.setName(employeeDto.getName());

        if(employeeDto.getSurname()!=null)
        employee.setSurname(employeeDto.getSurname());

        if(employeeDto.getAge() > 0)
        employee.setAge(employeeDto.getAge());

        if(employeeDto.getSalary() > 0)
        employee.setSalary(employeeDto.getSalary());

        employeeRepository.save(employee);

    }

    @Override
    public void delete(long id) {
        Employee employee = getEmployeeId(id);
        employeeRepository.delete(employee);
    }

    private Employee getEmployeeId(long id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new CustomRestException(ErrorCodeEnum.CAN_NOT_FIND_EMPLOYEE));
    }

    private EmployeeDto convertDto(Employee employee){
//        return EmployeeDto.builder()
//                .id(employee.getId())
//                .name(employee.getName())
//                .surname(employee.getSurname())
//                .age(employee.getAge())
//                .salary(employee.getSalary())
//                .build();

        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return  employeeDto;
    }

    private EmployeeResponse makeEmployyeresponse(List<EmployeeDto> employees){
       return EmployeeResponse.builder()
                .employess(employees)
                .build();
    }
}
