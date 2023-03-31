package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private MemberService memberService;
	
	public MemberController() {
		// TODO Auto-generated constructor stub
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
	public MemberVO addMember(String type) {
		return memberService.addMember(type);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(String type) {
		return memberService.updateMember(type);
	}
	
	@DeleteMapping("/member/{id}")
	public boolean deleteMember(@PathVariable Integer id, String type) {
		return memberService.deleteMember(id, type);
	}
	
}
