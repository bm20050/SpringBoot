package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	
	private MemberService memberService;
	// private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(String type) {
		return memberService.getMembers(type);
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id, String type) {
		return memberService.getMember(id, type);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO, String type) {
		return memberService.addMember(memberVO, type);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO memberVO, String type) {
		return memberService.updateMember(memberVO, type);
	}
	
	@DeleteMapping("/member/{id}")
	public boolean deleteMember(@PathVariable Integer id, String type) {
		return memberService.deleteMember(id, type);
	}
	
}
