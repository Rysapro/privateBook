//package com.example.demo.securityconfig;
//
//import com.example.demo.Author;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//public class AdminController {
//    @PostMapping("/addAuthor")
//    public String addAuthor(@RequestBody Author author) {
//        // Логика для добавления автора
//        return "Author added successfully";
//    }
//
//    @PutMapping("/editAuthor/{id}")
//    public String editAuthor(@PathVariable int id, @RequestBody Author updatedAuthor) {
//        // Логика для редактирования автора по id
//        return "Author updated successfully";
//    }
//}
