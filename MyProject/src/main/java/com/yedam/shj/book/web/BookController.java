package com.yedam.shj.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.shj.book.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("list", bookService.selectBookList());
		return "book/list";
	}
}
