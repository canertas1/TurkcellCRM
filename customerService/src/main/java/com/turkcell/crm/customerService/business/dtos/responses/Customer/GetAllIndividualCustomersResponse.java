package com.turkcell.crm.customerService.business.dtos.responses.Customer;

import com.turkcell.crm.customerService.entities.concretes.enums.Gender;
import com.turkcell.crm.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllIndividualCustomersResponse {
    private int id;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate birthDate;

    private Gender gender;

    private String fatherName;

    private String motherName;

    private String motherMaidenName;

    private String nationalityNumber;

    private List<Address> addresses;

//    private List<Account> accounts;

//    private Contact contactInfo;
}
