    package com.example.demo.service;

    import com.example.demo.Author;
    import com.example.demo.Book;
    import com.example.demo.repository.AuthorRepository;
    import com.example.demo.repository.BookRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class BookService {

        private BookRepository bookRepository;
        private AuthorRepository authorRepository;

        @Autowired
        public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
            this.bookRepository = bookRepository;
            this.authorRepository = authorRepository;
        }

//        private List<Book> books = new ArrayList<Book>();
//        private int nextId = 1;

        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        public Book addBook(Book book) {
            Optional<Author> existingAuthor = authorRepository.findByNameAndSurname(
                    book.getAuthor().getName(), book.getAuthor().getSurname()
            );
//            Author author = authorRepository.findById(book.getAuthor().getId())
//                    .orElseThrow(() -> new RuntimeException("Author not found"));

            Author author;
            if (existingAuthor.isPresent()) {
                author = existingAuthor.get();
            } else {
                author = authorRepository.save(book.getAuthor());
            }

            book.setAuthor(author);
            return bookRepository.save(book);
//            book.setId(nextId++);
//            books.add(book);
//            return book;
        }

        public Book updateBook(int id, Book updatedBook) {
            Optional<Book> existingBook = bookRepository.findById(id);
                if (existingBook.isPresent()) {
                    Book book = existingBook.get();
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setYear(updatedBook.getYear());
                    book.setPages(updatedBook.getPages());
                    book.setCost(updatedBook.getCost());

                    return bookRepository.save(book);
                }
            return null;
        }


        public boolean deleteBook(int id) {
            if (bookRepository.existsById(id)) {
                bookRepository.deleteById(id);
                return true;
            //return books.removeIf(book -> book.getId() == id);
        }
            return false;

    }
    }

