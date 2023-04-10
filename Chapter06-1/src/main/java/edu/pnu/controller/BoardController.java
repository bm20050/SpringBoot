package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.DBoard;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public void getBoardList(Model model) { 
		List<DBoard> list = boardService.getBoardList();
		model.addAttribute("boardlist", list);
	}
	
	@GetMapping("/board")
	public List<DBoard> getBoardList() {
		return boardService.getBoardList();
	}
	
	@GetMapping("/board")
	public List<DBoard> getBoard(Long seq) {
		if (seq == null) {
			System.out.println("getBoard : All");
			return boardService.getBoardList();
		}
			
		
		List<DBoard> list = new ArrayList<>();
		list.add(boardService.getBoard(seq));
		return list;
	}
	
	@GetMapping("/board/{seq}")
	public DBoard getBoardbyPath(@PathVariable Long seq) {
		System.out.println("getBoard : PathVariable");
		return boardService.getBoard(seq);
	}
}
