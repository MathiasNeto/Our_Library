package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Contact;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Loan;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    public Loan insert(Loan loan){
        Book book = bookRepository.findByIsbn(loan.getBook().getIsbn())
                .orElseThrow(()-> new ObjectNotFoundException("Book not found"));
        loan.setBook(book);
        book.setIsAvailable(false);
        return loanRepository.save(loan);
    }
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Loan findById( Long id) {

        return loanRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id not found"));
    }
//    public void delete(Long id){
//        if(loanRepository.findById(id).isPresent()){
//            loanRepository.deleteById(id);
//        }else{
//            throw new ObjectNotFoundException("Id not found");
//        }
//
//    }
}
