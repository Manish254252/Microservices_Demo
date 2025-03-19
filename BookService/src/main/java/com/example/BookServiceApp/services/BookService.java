package com.example.BookServiceApp.services;

import com.example.BookServiceApp.entity.Book;
import com.example.BookServiceApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook()
    {
       return bookRepository.findAll();
    }
    public Book getBookById(Integer id)
    {
      return bookRepository.findById(id).orElseGet(Book::new);
    }

    public void saveBook(Book book)
    {
       bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Optional<Book> existingStudent = bookRepository.findById(book.getId());

        if (existingStudent.isPresent()) {
            Book book1 = existingStudent.get();
            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            book1.setIsbn(book.getIsbn());
            return bookRepository.save(book1);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteBook(Integer id)
    {
        bookRepository.deleteById(id);

    }
}
