package com.bookstoreapp.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

    @Id
    private int id;
    
    // The title should not be empty and should not exceed 100 characters
    @NotEmpty(message ="The title should not be empty")
    @Size(max = 100,message = "Title should not exceed 100 characters")
    private String title;

    // The author should not be empty and should not exceed 200 characters
    @NotEmpty(message = "The author should not be empty")
    @Size(max = 200,message = "Author should not exceed 200 characters")
    private String author;

    // The publication year should be a valid year
    @Min(value = 1000,message ="The publication year should be a valid year")
    @Max(value = 2100,message ="The publication year should be a valid year")
    private int publicationYear;

    // The ISBN should be a valid 10- or 13-digit number.
    @Min(value = 1000000000L)
    @Max(value = 9999999999999L)
    private long isbn;

    // The price should be a positive decimal value.
    @Positive(message = "The price should be a positive decimal value")
    private double price;

}
