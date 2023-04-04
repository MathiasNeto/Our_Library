package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private EnumGender gender;
    private String road;
    private String number;
    private String city;
    private String uf;
    private String neighborhood;
    private String gmail;
    private String name_Course;
    private String area;
    private Course course;
    private Adress adress;
    private String telephone;
    private Contact contact;
    public UserDTO(Users users){
        name = users.getName_user();
        gender = users.getEnumGender();
        road = adress.getRoad();
        number = adress.getNumber();
        city = adress.getCity();
        uf = adress.getUf();
        neighborhood = adress.getNeighborhood();
        gmail = contact.getGmail();
        telephone = contact.getTelephone();
        area = String.valueOf(course.getArea());
        name_Course = course.getName_Course();
    }

}
