package edu.pnu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.MBService;

@RestController
public class MBController {
	
	@Autowired
	MBService service;

	
	@GetMapping("/member")
	public List<Member> getMembers() {
		return service.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public Member getMember(@PathVariable String id) {
		return service.getMember(id);
	}
	
	@GetMapping("/board") 
	public List<Board> getBoards() {
		return service.getBoards();
	}
	
	@GetMapping("/board/{id}")
	public Board getBoard(@PathVariable Long seq) {
		return service.getBoard(seq);
	}
}
