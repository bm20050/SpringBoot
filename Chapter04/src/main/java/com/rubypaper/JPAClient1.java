package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		
		
		insertBoard(emf);
		
	}
	public static void insertBoard(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			for (int i = 1; i <= 10; i++) {
				if (i == 10) 
					em.close();
				Board board = new Board(); 
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
			emf.close();
		}
	}

}
