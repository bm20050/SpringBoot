package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	// private MemberDao memberDao;
	private Map<String, MemberDao> map;

	public MemberService() {
		map = new HashMap<>();
		map.put("h2", new MemberDaoH2Impl());
		map.put("list", new MemberDaoListImpl());
	}
	
	private MemberDao getDao(String type) {
		return map.get(type);
	}
	
	public List<MemberVO> getMembers(String type) {
		return getDao(type).getMembers();
	}

	public MemberVO getMember(Integer id, String type) {
		return getDao(type).getMember(id);
	}

	public MemberVO addMember(MemberVO member, String type) {
		return getDao(type).addMember(member);
	}

	public MemberVO updateMember(MemberVO member, String type) {
		return getDao(type).updateMember(member);
	}

	public boolean deleteMember(Integer id, String type) {
		return getDao(type).deleteMember(id);
	}

}
