package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.dto.LoanDTO;
import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.services.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Loan;
import com.ourlibrary.project_library.entities.Student;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.repositories.DevolutionRepository;
import com.ourlibrary.project_library.repositories.LoanRepository;
import com.ourlibrary.project_library.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;
    private final DevolutionRepository devolutionRepository;

    public LoanDTO insert(Loan loan){

        Book book = bookRepository.findByIsbn(loan.getBook().getIsbn())
                .orElseThrow(()-> new ObjectNotFoundException("Book not found"));
        Student student = studentRepository.findById(loan.getStudent().getId()).orElseThrow(()->new ObjectNotFoundException("Student which id = "+ loan.getStudent()
                .getId()+" not found"));
        loan.setStudent(student);
        if (!book.getIsAvailable()){ //Verifica se o livro nao esta disponivel, se tiver disponivel o if nao entra
            throw new ObjectNotFoundException("Book is not available for loan");
        }
        loan.setBook(book);
        loan.setLoanDate(LocalDate.now());
        loan.setDate_devolution(loan.getLoanDate().plusDays(5));
        book.setIsAvailable(false);
        bookRepository.save(book);
        loan.setStatus("loaned");
        loanRepository.save(loan);
        return new LoanDTO(loan);

    }
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Loan findById( Long id) {
        return loanRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id not found"));
    }
    public void delete(Long id){
        if(loanRepository.findById(id).isPresent()){
            loanRepository.deleteById(id);
        }else{
            throw new ObjectNotFoundException("Id not found");
        }

    }
}
