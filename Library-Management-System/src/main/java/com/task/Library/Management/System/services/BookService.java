package com.task.Library.Management.System.services;

import com.task.Library.Management.System.models.Book;
import com.task.Library.Management.System.repositories.BookRepository;

import com.task.Library.Management.System.response.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public ApiResponse create(String title, String author, String isbn, int publication_year) {
        Book book = new Book(title, author, publication_year, isbn);
        try {
            bookRepository.save(book);
            return new ApiResponse(true, "Book created successfully.");
        } catch (Exception e) {
            return new ApiResponse(false, "Failed to create book: " + e.getMessage());
        }
    }

    @Transactional
    public ApiResponse update(long id, String title, String author, String isbn, int publication_year) {
        return bookRepository.findById(id)
                .map(book -> {
                    try {
                        book.setAuthor(author);
                        book.setTitle(title);
                        book.setPublication_year(publication_year);
                        book.setIsbn(isbn);
                        bookRepository.save(book);
                        return new ApiResponse(true, "Book updated successfully.");
                    } catch (Exception e) {
                        return new ApiResponse(false, "Failed to update book: " + e.getMessage());
                    }
                })
                .orElse(new ApiResponse(false, "Book not found."));
    }

    @Transactional
    public ApiResponse delete(long id) {
        try {
            if (!bookRepository.existsById(id)) {
                return new ApiResponse(false, "Book not found.");
            }
            bookRepository.deleteById(id);
            return new ApiResponse(true, "Book deleted successfully.");
        } catch (Exception e) {
            return new ApiResponse(false, "Failed to delete book: " + e.getMessage());
        }
    }
}
