package com.skull.book_bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "bookstore")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    private Integer _id;

    private String title;

    private String isbn;

    private Integer pageCount;

    private String publishedDate;

    private String thumbnailUrl;

    private String shortDescription;

    private String longDescription;

    private String status;

    private List<String> authors;

    private List<String> categories;
}
