package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;
	
	public List<Board> getBoardList() {
		return (List<Board>) boardRepo.findAll();
	}
	
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	public Board insertBoard(Board board) {
		boardRepo.save(board);
		List<Board> boardList = (List<Board>) boardRepo.findAll();
		Board b = boardList.get(boardList.size() - 1);
		System.out.println(b.toString());
		return b;
	}
	
	public Board updateBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		
		b.setContent(board.getContent());
		b.setTitle(board.getTitle());
		boardRepo.save(b);
		
		return b;
	}
	
	public Board deleteBoard(Board board) {
		Board deletedBoard = boardRepo.findById(board.getSeq()).get();
		
		boardRepo.deleteById(board.getSeq());
		
		return deletedBoard;
	}
}
