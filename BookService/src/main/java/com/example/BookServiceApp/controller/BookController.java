package com.example.BookServiceApp.controller;

import com.example.BookServiceApp.entity.Book;
import com.example.BookServiceApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> getBookById()
    {
        return bookService.getAllBook();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        try {
            Book book = bookService.getBookById(id);
            if (book.getId() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such Student Found");
            }
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the Student: " + e.getMessage());
        }
    }


    @PostMapping("/books")
    public String createBook(@RequestBody Book student)
    {
        bookService.saveBook(student);
        return "Created Successfully";
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book student)
    {
       return bookService.updateBook(student);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return "Deleted Successfully";
    }
}
