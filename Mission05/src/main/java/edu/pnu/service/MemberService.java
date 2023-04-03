package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberInterface memberDao;
	
	@Autowired
	private LogDao logDao;
	
	public MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<MemberVO> getMembers() {
		Map<String, Object> map = memberDao.getMembers();
		List<MemberVO> list = (List<MemberVO>) map.get("data");
		if (list != null) 
			logDao.addLog("get", (String) map.get("sql"), true);
		else 
			logDao.addLog
	}
	
	
}
