package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	private MemberService ms;
	
	private static final Logger Log = LoggerFactory.getLogger(MemberController.class); 
	
	public MemberController() throws Exception {
		Log.info("MemberController 생성자 호출");
		Log.error("Error Message 입니다.");
		Log.warn("Warn Message 입니다.");
		Log.info("Info Message 입니다.");
		Log.debug("Debug Message 입니다.");
		Log.trace("Trace Message 입니다.");
		ms = new MemberService();
		System.out.println("===> BoardController생성");
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return ms.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return ms.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		return ms.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO memberVO) {
		return ms.updateMember(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {
		return ms.removeMember(id);
	}
}
