package com.ourlibrary.project_library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_librarian")

public class Librarian extends Users {



}
