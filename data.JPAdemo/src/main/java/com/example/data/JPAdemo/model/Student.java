package com.example.data.JPAdemo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
   @Id
    private int rollNo;
   @NotBlank(message="name cannot be empty")
    private String name;
    private String gender;
    private String tech;
    private String email;
    private String password;

}
