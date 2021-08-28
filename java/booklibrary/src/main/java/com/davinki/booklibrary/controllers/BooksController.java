package com.davinki.booklibrary.controllers;

import com.davinki.booklibrary.models.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.io.InputStream;



@RestController
public class BooksController {

    final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/books")
    public String newBook(@RequestBody Book newBook) {
        Book book = new Book();
        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());
        book.setCategory(newBook.getCategory());
        book.setLanguage(newBook.getLanguage());
        book.setPublicationDate();
        book.setISBN();
        book.setGUID();
        try {
            InputStream inputStream = new FileInputStream("src/main/resources/books.json");
            TypeReference<List<Book>> typeReference = new TypeReference<>() {};
            List<Book> books = mapper.readValue(inputStream,typeReference);
            books.add(book);
            mapper.writeValue(new File("src/main/resources/books.json"), books);
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return "A new book has been successfully added to the list";
    }

}
