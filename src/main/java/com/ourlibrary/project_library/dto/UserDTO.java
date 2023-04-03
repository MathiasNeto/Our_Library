package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Adress;
import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.entities.Users;
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
    private Adress adress;
    private List<Contact> contactList;

    public UserDTO(Users users){
        name = users.getName_user();
        gender = users.getEnumGender();
        adress = users.getAdress();
        contactList = users.getContactList();
    }

}
