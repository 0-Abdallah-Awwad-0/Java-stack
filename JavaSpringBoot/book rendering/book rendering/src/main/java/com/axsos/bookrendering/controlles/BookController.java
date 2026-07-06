package com.axsos.bookrendering.controlles;


import com.axsos.bookrendering.models.Book;
import com.axsos.bookrendering.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService =bookService;
    }
//    we should add the final of the book service and add the constracter

    @RequestMapping("")
    public String index(){
        return "index";
    }
// insted of the model atttribute we should add the path varibale
    @RequestMapping("/book/{id}")
    public String show(@PathVariable("id")Long id , Model model ){
        Book book = bookService.findBook(id);
        model.addAttribute("book",book);
    return "index";
    }

}
