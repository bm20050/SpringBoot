package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;
import edu.pnu.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BoardController {
	BoardService b = new BoardService();

	public BoardController() {
		System.out.println("===> BoardController생성");
		// log.info("===> BoardController생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@PostMapping("/hello")
	public String posthello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "백수", "악플");
	}
	
	
	// @Autowired
	// BoardService b;
	
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		return b.getPersons();
		//return null;
	}
}
