package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Teacher;
import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.Data;

@Data
public class TeacherDTO {
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
    public TeacherDTO(Teacher teacher){
        name = teacher.getName_user();
        gender = teacher.getEnumGender();
        road = teacher.getAddress().getRoad();
        number = teacher.getAddress().getNumber();
        city = teacher.getAddress().getCity();
        uf = teacher.getAddress().getUf();
        neighborhood = teacher.getAddress().getNeighborhood();
        for (int i = 0; i < teacher.getContactList().size(); i++) {
            gmail = teacher.getContactList().get(i).getEmail();
            telephone = teacher.getContactList().get(i).getTelephone();
        }
        area = String.valueOf(teacher.getCourse().getArea());
        name_Course = teacher.getCourse().getName_Course();
    }
}
