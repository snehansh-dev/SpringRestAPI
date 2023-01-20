package com.snehansh.SpringRestAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    @NotNull(message = "First Name required")
    private String personFirstName;
    @NotNull(message = "Last Name required")
    private String personLastName;
    @NotNull(message = "Address is required")
    private String personAddress;
    @Email(message = "Provide valid email")
    private String personEmail;
    private String personContact; //contact
}
