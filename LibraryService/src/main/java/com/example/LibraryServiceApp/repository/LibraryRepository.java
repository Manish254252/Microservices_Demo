package com.example.LibraryServiceApp.repository;

import com.example.LibraryServiceApp.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer> {
}
