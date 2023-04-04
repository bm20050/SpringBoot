package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Board1;


public class JPAClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04_mysql");
		
		insertBoard(emf);
//		findBoardOne(emf, 34L);
//		findBoardManyJPAQuery(emf);
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
			for (int i = 1; i <= 10; i++) {
				Board board = Board.builder()
								.title("title" + i)
								.content("content" + i)
								.writer("writer" + i)
								.build();
				em.persist(board);
			}
			tx.commit();
			
			tx.begin();
			for (int i = 1; i <= 10; i++) {
				Board1 board1 = Board1.builder()
									.title("title" + i)
									.content("content" + i)
									.writer("writer" + i)
									.createDate(new Date())
									.build();
				em.persist(board1);				
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
	}  
	

}
