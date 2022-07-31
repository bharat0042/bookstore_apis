package com.skull.book_bank.repository;

import com.skull.book_bank.entity.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface BookReactiveRepository extends ReactiveMongoRepository<Book, Long> {
    Flux<Book> findReviewsByTitle(String title);
    Flux<Book> findReviewsByIsbn(String isbn);
    Flux<Book> findAll();
}
