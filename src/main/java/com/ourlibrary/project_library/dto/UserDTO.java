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
    private String telephone;
    public UserDTO(Student student){
        name = student.getName_user();
        gender = student.getEnumGender();
        road = student.getAdress().getRoad();
        number = student.getAdress().getNumber();
        city = student.getAdress().getCity();
        uf = student.getAdress().getUf();
        neighborhood = student.getAdress().getNeighborhood();
        for (int i = 0; i < student.getContactList().size(); i++) {
            gmail = student.getContactList().get(i).getGmail();
            telephone = student.getContactList().get(i).getTelephone();
        }
        area = String.valueOf(student.getCourse().getArea());
        name_Course = student.getCourse().getName_Course();
    }

}
