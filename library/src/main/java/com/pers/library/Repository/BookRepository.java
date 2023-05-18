package com.pers.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pers.library.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

