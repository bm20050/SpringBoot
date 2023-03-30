package edu.pnu.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	
	private List<MemberVO> list;
	private Map<String, Object> map;
	public MemberDaoListImpl() {
		list = new ArrayList<>();
	}
	
	public Map<String, Object> getMembers() {
		map.put("list", list);
		map.put("query", "");
		
		if (list.size() == 0) 
			map.put("bool", true);
		else 
			map.put("bool", false);
		
		return map;
	}
	
	public Map<String, Object> getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				map.put("m", m);
				map.put("query", "");
				map.put("bool", true);
				return map;
			}
				
		}
		map.put("m", null);
		map.put("query", "");
		map.put("bool", false);
		return map;
	}
	
	public Map<String, Object> addMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId() == memberVO.getId()) {
				map.put("m", null);
				map.put("query", "");
				map.put("bool", false);
				return map;
			}	
		}
		list.add(memberVO);
		map.put("m", memberVO);
		map.put("query", "");
		map.put("bool", true);
		return map;
	}
	
	public Map<String, Object> updateMember(MemberVO memberVO) {
		for (MemberVO m: list) {
			if (m.getId() == memberVO.getId()) {
				m.setPass(memberVO.getPass());
				m.setName(memberVO.getName());
				map.put("m", m);
				map.put("query", "");
				map.put("bool", true);
				return map;
			}
		}
		map.put("m", null);
		map.put("query", "");
		map.put("bool", false);
		return map;
	}
	
	public Map<String, Object> deleteMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				map.put("query", "");
				map.put("bool", true);
				return map;
			}
		}
		map.put("query", "");
		map.put("bool", false);
		return map;
	}
}
