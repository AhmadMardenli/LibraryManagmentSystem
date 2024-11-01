package com.task.Library.Management.System.repositories;

import com.task.Library.Management.System.models.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowingRecord,Long> {
}
