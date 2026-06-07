package com.example.data.JPAdemo.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDto {
    private int rno;
    private String name;
    private String gender;
    private String tech;
    private String email;

}
