package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Adress;
import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String name;
    private EnumGender gender;
    private Adress adress;
    private List<Contact> contactList;

    public StudentDTO(Student student){
        name = student.getName();
        gender = student.getEnumGender();
        adress = student.getAdress();
        contactList = student.getContact();
    }

}
