package com.task.Library.Management.System.repositories;

import com.task.Library.Management.System.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
