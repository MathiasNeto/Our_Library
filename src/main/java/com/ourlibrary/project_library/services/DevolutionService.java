package com.ourlibrary.project_library.services;

import com.ourlibrary.project_library.entities.Book;
import com.ourlibrary.project_library.entities.Devolution;
import com.ourlibrary.project_library.entities.Excetions.ObjectNotFoundException;
import com.ourlibrary.project_library.entities.Loan;
import com.ourlibrary.project_library.repositories.BookRepository;
import com.ourlibrary.project_library.repositories.DevolutionRepository;
import com.ourlibrary.project_library.repositories.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DevolutionService {

    private final DevolutionRepository devolutionRepository;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    public Devolution insert(Devolution devolution){
        Loan loan = loanRepository.findById(devolution.getLoan().getId())
                .orElseThrow(()->new ObjectNotFoundException("Loan not found"));
        Book book = loan.getBook();
        devolution.setLoan(loan);
//        devolution.setDevolution_date(LocalDate.now());
        Period period = Period.between(loan.getDate_devolution(), devolution.getDevolution_date());
        Double price_final = period.getDays() * devolution.getAddition();
        devolution.setPrice_Final(
            price_final
        );

        book.setIsAvailable(true);
        loan.setStatus("returned");
        devolution.setStatus("returned");
        return devolutionRepository.save(devolution);
    }

    public List<Devolution> findAll() {
        return devolutionRepository.findAll();
    }

    public Devolution findById( Long id) {
        return devolutionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Id not found"));
    }
}
