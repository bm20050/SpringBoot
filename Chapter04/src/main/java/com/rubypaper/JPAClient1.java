package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.domain.Board1;

public class JPAClient1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		
		
//		insertBoard(emf);
//		findBoardOne(emf, 34L);
		findBoardManyJPAQuery(emf);
//		findBoardManyNativeQuery(emf);
//		
//		updateBoard(emf, 38L);
//		findBoardOne(emf, 34L);
//		
//		deleteBoard(emf, 35L);
//		findBoardManyJPAQuery(emf);
		
		emf.close();

	}
	public static void insertBoard(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			int a = 10;
			for (int i = 1; i <= 10; i++) {
//				if (i == 10) 
//					a /= 0;
				Board1 board = new Board1(); 
				board.setTitle("JPA 제목" + i);
				board.setWriter("관리자"+ i);
				board.setContent("JPA 글 등록 잘 되네요." + i);
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				em.persist(board);
			}
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void findBoardOne(EntityManagerFactory emf, Long seq) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Board1 searchBoard = em.find(Board1.class, seq);
			System.out.println("---> " + searchBoard);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public static void findBoardManyJPAQuery(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			String jpql = "select b from Board b order by b.seq asc";
			// List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
			TypedQuery<Board1> query = em.createQuery(jpql, Board1.class);
			List<Board1> boardList = query.getResultList();
			for (Board1 brd : boardList) {
				System.out.println("---> " + brd);
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		
		EntityManager em = emf.createEntityManager();
		
		List<?> list1 = em.createNativeQuery("select * from board", Board1.class).getResultList();
		
		for (Object b : list1) {
			System.out.println("---> " + b);
		}
		
		System.out.println("-".repeat(100));
		
		@SuppressWarnings("unchecked")
		List<Object[]> list2 = em.createNativeQuery("select * from board").getResultList();
		
		for (Object[] b : list2) {
			for (int i = 0; i < b.length; i++) {
				if (i != 0)
					System.out.print(", ");
				System.out.print(b[i]);
			}
			System.out.println();
		}
		System.out.println("-".repeat(100));		
		
		em.close();
	}
	
	public static void updateBoard(EntityManagerFactory emf, Long seq) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Board1 board = em.find(Board1.class, seq);
			board.setTitle("검색한 게시글의 제목 수정");
			
//			em.persist(board);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void deleteBoard(EntityManagerFactory emf, Long seq) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			Board1 board = em.find(Board1.class, seq);
//			board.setSeq(seq);

			board.setSeq(seq);
			em.remove(board);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	
}
