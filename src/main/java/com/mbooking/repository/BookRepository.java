package com.mbooking.repository;

import com.mbooking.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
}
