package edu.pnu;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepo;
	
	@Test
	public void BoardInsertTest() {
		for (int i = 1; i <= 100; i++) {
			long n = (long) (Math.random() * 101);
			Board b = new Board();
			b.setTitle("title" + i);
			b.setContent("content" + i);
			b.setWriter("writer" + i);
			b.setCreateDate(new Date());
			b.setCnt(n);
			
			boardRepo.save(b);
		}
	}
	
	@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(5L).get();
		System.out.println(board.toString());
	}
	
	@Test
	public void testUpdateBoard() {
		System.out.println("=== 1번 게시글 조회 ===");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 제목 수정 ===");
		board.setTitle("제목을 수정했습니다.");
		boardRepo.save(board);
	}
	
	@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(8L);
	}
	
	@Test
	public void testByTitleContaining() {
		List<Board> boardList = boardRepo.findByTitleContaining("1");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	public void testByTitleContainingAndCntGreaterThan() {
		List<Board> boardList = boardRepo.findByTitleContainingAndCntGreaterThan("1", (long) 50);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test 
	public void testByCntBetweenOrderBySeq() {
		List<Board> boardList = boardRepo.findByCntBetweenOrderBySeq((long) 10, (long) 50);
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	public void testByTitleContainingOrContentContainingOrderBySeqDesc() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		
		System.out.println("검색 결과");
		for (Board board : boardList) {
			System.out.println("---> " + board);
		}
	}
	
	@Test
	public void test() {
		Pageable paging = PageRequest.of(0,  3, Sort.Direction.DESC, "seq");
		List<Board> list = boardRepo.queryAnnotationTest(paging);
		
		for (Board board : list) {
			System.out.println(board);
		}
	}
	
	@Test
	public void test2() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest2("title10");
		System.out.println("검색 결과");
		
		for (Object[] row : boardList) {
			System.out.println("---> " + Arrays.toString(row));			
		}
	}
	
	@Test
	public void test3() {
		List<Object[]> boardList = boardRepo.queryAnnotationTest3("title1");
		System.out.println("검색 결과");
		
		for (Object[] row : boardList) {
			System.out.println("---> " + Arrays.toString(row));
		}
	}
}
