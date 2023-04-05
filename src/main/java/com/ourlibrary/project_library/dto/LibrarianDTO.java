package com.ourlibrary.project_library.dto;

import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.entities.Teacher;
import com.ourlibrary.project_library.enuns.EnumGender;
import lombok.Data;

@Data
public class LibrarianDTO {
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
    public LibrarianDTO(Librarian librarian){
        name = librarian.getName_user();
        gender = librarian.getEnumGender();
        road = librarian.getAdress().getRoad();
        number = librarian.getAdress().getNumber();
        city = librarian.getAdress().getCity();
        uf = librarian.getAdress().getUf();
        neighborhood = librarian.getAdress().getNeighborhood();
        for (int i = 0; i < librarian.getContactList().size(); i++) {
            gmail = librarian.getContactList().get(i).getGmail();
            telephone = librarian.getContactList().get(i).getTelephone();
        }
    }
}
