package com.task.Library.Management.System.repositories;

import com.task.Library.Management.System.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Long> {
}
