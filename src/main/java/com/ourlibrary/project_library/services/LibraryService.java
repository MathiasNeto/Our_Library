package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Library;
import com.ourlibrary.project_library.entities.Loan;
import com.ourlibrary.project_library.repositories.LibraryRepository;
import com.ourlibrary.project_library.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private LoanRepository loanRepository;

    public Library insert(Library library){
//        Loan loan = loanRepository.findById()
//        if (!book.getIsAvailable()){
//            return "the book not is available";
//        }
        return libraryRepository.save(library);
    }

    public Library getAll(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(()->new ObjectNotFoundException("id "+ id +" not found"));
    }
}
