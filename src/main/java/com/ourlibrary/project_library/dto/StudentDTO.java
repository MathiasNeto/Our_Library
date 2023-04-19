package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.*;
import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private EnumGender gender;
    private String period_Course;
    private String road;
    private String number;
    private String city;
    private String uf;
    private String neighborhood;
    private String gmail;
    private String name_Course;
    private String area;
    private String telephone;
    public StudentDTO(Student student){
        name = student.getName_user();
        gender = student.getEnumGender();
        road = student.getAddress().getRoad();
        number = student.getAddress().getNumber();
        city = student.getAddress().getCity();
        uf = student.getAddress().getUf();
        neighborhood = student.getAddress().getNeighborhood();
        for (int i = 0; i < student.getContactList().size(); i++) {
            gmail = student.getContactList().get(i).getEmail();
            telephone = student.getContactList().get(i).getTelephone();
        }
        period_Course = student.getPeriod_course();
        area = String.valueOf(student.getCourse().getArea());
        name_Course = student.getCourse().getName();
    }
}
