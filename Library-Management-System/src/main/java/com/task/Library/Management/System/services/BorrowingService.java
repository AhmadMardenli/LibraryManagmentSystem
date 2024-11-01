package com.task.Library.Management.System.services;

import com.task.Library.Management.System.models.BorrowingRecord;
import com.task.Library.Management.System.repositories.BorrowRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

@Service
public class BorrowingService {
    BorrowRepository borrowRepository;

    public BorrowingService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }
//    public String borrow(long bookId,long patronId){
//        borrowRepository.findBy();
//    }
}
