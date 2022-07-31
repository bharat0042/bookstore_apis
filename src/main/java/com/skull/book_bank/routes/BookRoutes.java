package com.skull.book_bank.routes;

import com.skull.book_bank.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BookRoutes {

    @Bean
    public RouterFunction<ServerResponse> bookRoute(BookHandler bookHandler) {
        return route().
                nest(path("/v1/book"), builder -> {
                    builder.GET("", bookHandler::getBooks);
                })
                .GET("/hello", (request -> ServerResponse.ok().bodyValue("Hello")))
                .build();
    }
}
