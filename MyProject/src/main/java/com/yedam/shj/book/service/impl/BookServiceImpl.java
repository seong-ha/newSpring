package com.yedam.shj.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.shj.book.mapper.BookMapper;
import com.yedam.shj.book.service.BookService;
import com.yedam.shj.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public List<BookVO> selectBookList() {
		return bookMapper.getBookList();
	}

}
