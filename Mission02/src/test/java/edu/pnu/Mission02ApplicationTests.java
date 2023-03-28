package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@SpringBootTest
class Mission02ApplicationTests {
	

	@Test
	void contextLoads() {
		System.out.println("이것은 테스트입니다.");
	}
	
	@Test
	void testMemberDao() throws Exception {
		System.out.println("이것은 Dao테스트입니다.");
		MemberDao memberDao = new MemberDao();
		
		List<MemberVO> list = memberDao.getMembers();
		for (MemberVO m : list) {
			System.out.println(m);
		}
	}

}
