package com.company.springrestdemo.rest.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private long id;

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private int age;
    private double salary;
}
