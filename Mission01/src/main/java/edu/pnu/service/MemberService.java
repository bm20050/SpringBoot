package edu.pnu.service;

import java.util.ArrayList;
// import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	private List<MemberVO> list;
	
	public MemberService() {		
		list = new ArrayList<>();
	}
	
	public List<MemberVO> getMembers() {
		return list;
	}
	
	public MemberVO getMember(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id.intValue()) {
				return list.get(i);
			}
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO m) {
		// MemberVO m = new MemberVO(me.getId(), me.getPass(), me.getName(), new Date());
	
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == m.getId())
				return null;
		}
		list.add(m);
		return m;
	}
	
	public MemberVO updateMember(MemberVO m) {
		// MemberVO m = new MemberVO(me.getId(), me.getPass(), me.getName(), new Date());
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == m.getId()) {
				list.get(i).setName(m.getName());
				list.get(i).setPass(m.getPass());
				return m;
			}
		}
		return null;
	}
	
	public MemberVO removeMember(Integer id) {
		MemberVO m = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id.intValue()) {
				m = list.get(i);
				list.remove(i);
			}
		}
		return m;
	}
}
