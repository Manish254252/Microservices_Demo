package com.example.LibraryServiceApp.services;

import com.example.LibraryServiceApp.entity.Library;
import com.example.LibraryServiceApp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllLibrary()
    {
       return libraryRepository.findAll();
    }
    public Library getLibraryById(Integer id)
    {
      return libraryRepository.findById(id).orElseGet(Library::new);
    }

    public void saveLibrary(Library library)
    {
       libraryRepository.save(library);
    }

    public Library updateLibrary(Library library) {
        Optional<Library> existingLibrary = libraryRepository.findById(library.getId());

        if (existingLibrary.isPresent()) {
            Library LibraryToUpdate = existingLibrary.get();
            LibraryToUpdate.setName(library.getName());
            LibraryToUpdate.setLocation(library.getLocation());
            return libraryRepository.save(LibraryToUpdate);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteLibrary(Integer id)
    {
        libraryRepository.deleteById(id);

    }
}
