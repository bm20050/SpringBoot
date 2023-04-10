package edu.pnu.service;

import java.util.List;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;


import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@Service
public class MBService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
		
 	public List<Member> getMembers() {
 		return (List<Member>) memberRepo.findAll();
 	}
 	
 	public Member getMember(String id) {
 		return memberRepo.findById(id).get();
 	}
 	
 	public List<Board> getBoards() {
 		return (List<Board>) boardRepo.findAll();
 	}
 	
 	public Board getBoard(Long seq) {
 		return boardRepo.findById(seq).get();
 	}
}
