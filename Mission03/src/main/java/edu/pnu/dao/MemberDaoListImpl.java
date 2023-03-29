package edu.pnu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	
	List<MemberVO> list;
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
	}
	
	public List<MemberVO> getMembers() {
		return list;
	}
	
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) 
				return m;
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) 
				return null;
		}
		list.add(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMember(MemberVO memberVO) {
		for (MemberVO m: list) {
			if (m.getId() == memberVO.getId()) {
				m.setPass(memberVO.getPass());
				m.setName(memberVO.getName());
				return m;
			}
		}
		return null;
	}
	
	public boolean deleteMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				return true;
			}
		}
		return false;
	}
}
