package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter06ThApplicationTests {

	@Autowired
	BoardRepository boardRepo;
	
	@Test
	void contextLoads() {
		
	}

}
