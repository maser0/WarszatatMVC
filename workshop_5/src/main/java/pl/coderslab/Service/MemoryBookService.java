package pl.coderslab.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
//sesyjny


public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }


    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getBook(Long id) {
        return this.list.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void addBook(Book book) {
        book.setId(book.nextId);
        this.list.add(book);
    }

    public void deleteBook(long id) {
        Book bookById = getBook(id);
        list.remove(bookById);

    }

    public List<Book> updateBook(Book book) {
        Book bookById = getBook(book.getId());
        list.remove(bookById);
        list.add(book);
        return list;
    }



}



