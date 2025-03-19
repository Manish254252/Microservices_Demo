package com.example.LibraryServiceApp.controller;

import com.example.LibraryServiceApp.entity.Book;
import com.example.LibraryServiceApp.entity.Library;
import com.example.LibraryServiceApp.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/libraries")
    public List<Library> getLibraryById()
    {
        return libraryService.getAllLibrary();
    }

    @GetMapping("/libraries/{id}")
    public ResponseEntity<?> getLibraryById(@PathVariable Integer id) {
        try {
            Book book = restTemplate.getForObject("http://localhost:9092/books/books/"+id, Book.class);
            Library library = libraryService.getLibraryById(id);
            if (library.getId() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such Library Found");
            }
            library.setBook(book);
            return ResponseEntity.ok(library);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while retrieving the Library: " + e.getMessage());
        }
    }


    @PostMapping("/libraries")
    public String createLibrary(@RequestBody Library library)
    {
        libraryService.saveLibrary(library);
        return "Created Successfully";
    }

    @PutMapping("/libraries/{id}")
    public Library updateLibrary(@RequestBody Library library)
    {
        System.out.println(library);
       return libraryService.updateLibrary(library);
    }

    @DeleteMapping("/libraries/{id}")
    public String deleteLibrary(@PathVariable Integer id)
    {
        libraryService.deleteLibrary(id);
        return "Deleted Successfully";
    }
}
