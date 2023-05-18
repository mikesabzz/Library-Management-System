package com.pers.library.Controller;
import org.springframework.web.bind.annotation.*;

import com.pers.library.Entity.Book;
import com.pers.library.Entity.Burrower;
import com.pers.library.Repository.BookRepository;
import com.pers.library.Repository.BurrowerRepository;

@RestController
@RequestMapping("/api")
public class LibraryController {
    
    private final BookRepository bookRepository;
    private final BurrowerRepository burrowerRepository;
    
    public LibraryController(BookRepository bookRepository, BurrowerRepository burrowerRepository) {
        this.bookRepository = bookRepository;
        this.burrowerRepository = burrowerRepository;
    }
    
    // Book Endpoints
    
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    return bookRepository.save(book);
                })
                .orElse(null);
    }
    
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
    
    // Burrower Endpoints
    
    @PostMapping("/burrowers")
    public Burrower createBurrower(@RequestBody Burrower burrower) {
        return burrowerRepository.save(burrower);
    }
    
    @GetMapping("/burrowers/{id}")
    public Burrower getBurrowerById(@PathVariable Long id) {
        return burrowerRepository.findById(id).orElse(null);
    }
    
    @PutMapping("/burrowers/{id}")
    public Burrower updateBurrower(@PathVariable Long id, @RequestBody Burrower updatedBurrower) {
        return burrowerRepository.findById(id)
                .map(burrower -> {
                    burrower.setName(updatedBurrower.getName());
                    burrower.setBook(updatedBurrower.getBook());
                    return burrowerRepository.save(burrower);
                })
                .orElse(null);
    }
    
    @DeleteMapping("/burrowers/{id}")
    public void deleteBurrower(@PathVariable Long id) {
        burrowerRepository.deleteById(id);
    }
}
