package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardServiceImpl;

@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member, Model model) {
		if (member.getId() == null)
			return "redirect:login";
		
		List<Board> boardList = boardService.getBoardList();
		
		model.addAttribute("boardList", boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member) {
		if (member.getId() == null)
			return "redirect:login";
		return "insertBoard";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null)
			return "redirect:login";
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null)
			return "redirect:login";
		boardService.updateBoard(board);
		return "redirect:getBoardList";
	}
		
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		if (member.getId() == null)
			return "redirect:login";
		boardService.deleteBoard(board);
		return "redirect:getBoardList";
	}
	
	
	
	
}
