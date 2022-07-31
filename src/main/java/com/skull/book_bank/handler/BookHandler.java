package com.skull.book_bank.handler;

import com.skull.book_bank.entity.Book;
import com.skull.book_bank.repository.BookReactiveRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookHandler {
    final private BookReactiveRepository bookReactiveRepository;

    public BookHandler(BookReactiveRepository bookReactiveRepository) {
        this.bookReactiveRepository = bookReactiveRepository;
    }

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> getBooks(@NotNull ServerRequest serverRequest) {
        var title = serverRequest.queryParam("title");
        var isbn = serverRequest.queryParam("isbn");

        if(title.isPresent()) {
            var books = bookReactiveRepository.findReviewsByTitle(title.get());
            return buildReviewsResponse(books);
        }
        else if (isbn.isPresent()) {
            var books = bookReactiveRepository.findReviewsByIsbn(isbn.get());
            return buildReviewsResponse(books);
        }
        else{
            var books = bookReactiveRepository.findAll();
            return buildReviewsResponse(books);
        }
    }

    private @NotNull Mono<ServerResponse> buildReviewsResponse(Flux<Book> books) {
        return ServerResponse.ok()
                .body(books, Book.class);
    }
}
