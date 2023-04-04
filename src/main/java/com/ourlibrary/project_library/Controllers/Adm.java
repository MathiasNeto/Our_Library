package com.ourlibrary.project_library.Controllers;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Librarian;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.services.LibrarianService;
import com.ourlibrary.project_library.services.LibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/Adm")
public class Adm {
    private final LibrarianService librarianService;
    private final LibraryService libraryService;
    @PostMapping(value = "/library")
    public ResponseEntity<Library> save(@RequestBody @Valid Library library) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryService.insert(library));
    }

    @GetMapping(value = "/getLibrary/{id}")
    public ResponseEntity<Library> getAllLibrary(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(libraryService.getAll(id));
    }

    @PostMapping(value = "/Librarian")
    public ResponseEntity<Librarian> save(@RequestBody Librarian librarian){
        return ResponseEntity.status(HttpStatus.OK).body(librarianService.insert(librarian));
    }

}
