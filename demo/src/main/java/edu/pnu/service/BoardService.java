package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Person;

@Service
public class BoardService {
	private List<Person> list = new ArrayList<>();
	
	
	public BoardService() {
		System.out.println("===> BoardService생성");
		list.add(new Person("홍길동", 2000, "백수", "악플"));
		list.add(new Person("홍길동", 2000, "백수", "악플"));
		list.add(new Person("홍길동", 2000, "백수", "악플"));
	}
	
	public List<Person> getPersons() {
		return list;
	}
}
