package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Service.MemoryBookService;
import pl.coderslab.model.Book;

import java.util.List;

@RestController
//@RequestMapping("/books")
public class BookController {
//    @GetMapping("/hello")
//    public String hello(){
//        return "{hello: World}";
//    }
//
//    @RequestMapping("/helloBook")
//    public Book helloBook(){
//        return new Book(1L,"9788324631766","Thinking in Java",
//                "Bruce Eckel","Helion","programming");
//    }

    private MemoryBookService memoryBookService;

    @Autowired      // po co to sie robi  ten konstruktor to jest to wstrzykniecie ?
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("/books")  // tu nie musi byc zadnego Responsebody ?
    public List<Book> viewBooks (){
        return memoryBookService.getList();
    }

    @GetMapping("/books/{id}")
    public Book showBook (@PathVariable long id ){
        return memoryBookService.getBook(id);
    }

    @PostMapping("/books/")    // on oczekuje booka skad ja mam mu tu przekazac booka  ? na slajdzie pisze z formularza ??>
    public Book addBook (@RequestBody Book book){
          memoryBookService.addBook(book);
        return book;
    }

    @DeleteMapping("/books/{id}")    // tu do tego delete ma byc Get czy inaczej ?
    public String deleteBook (@PathVariable long id ){
         memoryBookService.deleteBook(id);
         return "deleted";
    }


    @PutMapping("/books/{id}")     // tego booka  skad wziac!?
    public Book updateBook (@RequestBody Book book, @PathVariable long id){
        book.setId(id);
        memoryBookService.updateBook(book);
        return book;
    }




}
