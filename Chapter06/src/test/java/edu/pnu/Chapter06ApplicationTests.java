package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class Chapter06ApplicationTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	@Test
	void contextLoads() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board);
		Member member = memberRepo.findById("member1").get();
		System.out.println(member);
		
		List<Board> list = (List<Board>) boardRepo.findAll();
		
		for (Board b : list) {
			System.out.println(b);
		}
		
	}
	
	@Test 
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("memeber111");
		member1.setName("둘리");
		member1.setRole("User");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		memberRepo.save(member2);
		
		
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("둘리가 등록한 게시글: " + i);
			board.setContent("둘리가 등록한 게시글 내용: " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("도우너가 등록한 게시글: " + i);
			board.setContent("도우너가 등록한 게시글 내용: " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);
		}
		
	}

}
