package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	MemberDao md;
	
	public MemberService() throws Exception {		
		md = new MemberDao();
	}
	
	public List<MemberVO> getMembers() {
		return md.getMembers();
	}
	
	public MemberVO getMember(Integer id) {
		return md.getMember(id);
	}
	
	public MemberVO addMember(MemberVO m) {
		return md.addMember(m);
	}
	
	public MemberVO updateMember(MemberVO m) {
		return md.updateMember(m);
	}
	
	public MemberVO removeMember(Integer id) {
		return md.removeMember(id);
	}
}
