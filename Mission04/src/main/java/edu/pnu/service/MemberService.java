package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoListImpl;
import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.log.LogDaoFileImpl;
import edu.pnu.dao.log.LogDaoH2Impl;
import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberDao memberDaoH2;
	private MemberDao memberDaoList;
	private Map<String, Object> map;
	private LogDao logDao;
	
	
	public MemberService() {
		map = new HashMap<>();
		logDao = new LogDaoH2Impl();
		memberDaoH2 = new MemberDaoH2Impl();
		memberDaoList = new MemberDaoListImpl();
		// logDao = new LogDaoFileImpl();
	}
	
	private MemberDao getDao(String type) {
		map.put("h2", memberDaoH2);
		map.put("list", memberDaoList);
		return (MemberDao) map.get(type);
	}
	
	public List<MemberVO> getMembers(String type) {
		map = getDao(type).getMembers();
		@SuppressWarnings("unchecked")
		List<MemberVO> list = (List<MemberVO>) map.get("list");
		logDao.addLog("GET", map.get("query"), map.get("bool"));
		return list;
	}

	public MemberVO getMember(Integer id, String type) {
		map = getDao(type).getMember(id);
		MemberVO m = (MemberVO) map.get("m");
		logDao.addLog("GET", map.get("query"), map.get("bool"));
		return m;
	}

	public MemberVO addMember(MemberVO member, String type) {
		map = getDao(type).addMember(member);
		MemberVO m = (MemberVO) map.get("m");
		logDao.addLog("POST", map.get("query"), map.get("bool"));
		return m;
	}

	public MemberVO updateMember(MemberVO member, String type) {
		map = getDao(type).updateMember(member);
		MemberVO m = (MemberVO) map.get("m");
		logDao.addLog("PUT", map.get("query"), map.get("bool"));
		return m;
	}

	public boolean deleteMember(Integer id, String type) {
		map = getDao(type).deleteMember(id);
		boolean bool = (boolean) map.get("bool");
		logDao.addLog("DELETE", map.get("query"), map.get("bool"));
		return bool;
	}

}
