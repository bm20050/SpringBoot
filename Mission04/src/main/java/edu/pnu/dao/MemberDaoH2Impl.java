package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl extends DaoH2 implements MemberDao  {
	private Connection con = null;
	private Map<String, Object> map;
	
	public MemberDaoH2Impl() {
		super();
	}
	
	@Override
	public Map<String, Object> getMembers() {
		Statement st = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<>();
		map = new HashMap<>();
		try {
			String query = "select * from member order by id asc";
			st = getConnection().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
			map.put("list", list);
			map.put("query", query);
			map.put("bool", true);
		} catch (Exception e) {
			map.put("query", e.getMessage());
			map.put("bool", false);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		map = new HashMap<>();
		try {
			String query = "select * from member where id=?";
			st = getConnection().prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			
			map.put("m", m);
			map.put("query", query);
			map.put("bool", true);
			
			return map;
		} catch (Exception e) {
			map.put("query", e.getMessage());
			map.put("bool", false);
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private int getNextId() {
		Statement st = null;
		ResultSet rs = null;
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("select max(id) from member");
			rs.next();
			return rs.getInt(1) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;		
	}
	
	@Override
	public Map<String, Object> addMember(MemberVO member) {
		
		int id = getNextId();
		
		PreparedStatement st = null;
		map = new HashMap<>();
		try {
			String query = "insert into member (id,name,pass,regidate) values (?,?,?,?)";
			st = getConnection().prepareStatement(query);
			st.setInt(1, id);
			st.setString(2, member.getName());
			st.setString(3, member.getPass());
			st.setDate(4, new Date(System.currentTimeMillis()));
			st.executeUpdate();
			
			map.put("m", (MemberVO) getMember(id).get("m"));
			map.put("query", query);
			map.put("bool", true);
			
			return map;
		} catch (Exception e) {
			map.put("query", e.getMessage());
			map.put("bool", false);
			e.printStackTrace();
		} finally {
			try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		PreparedStatement st = null;
		map = new HashMap<>();
		try {
			String query = "update member set name=?,pass=? where id=?";
			st = getConnection().prepareStatement(query);
			st.setString(1, member.getName());
			st.setString(2, member.getPass());
			st.setInt(3, member.getId());
			st.executeUpdate();
			
			map.put("m", (MemberVO) getMember(member.getId()).get("m"));
			map.put("query", query);
			map.put("bool", true);
			return map;
		} catch (Exception e) {
			map.put("query", e.getMessage());
			map.put("bool", false);
			e.printStackTrace();
		} finally {
			try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		PreparedStatement st = null;
		map = new HashMap<>();
		try {
			String query = "delete from member where id=?";
			st = con.prepareStatement(query);
			st.setInt(1, id);
			if (st.executeUpdate() == 1)
				map.put("bool", true);
			map.put("query", query);
		} catch (Exception e) {
			map.put("query", e.getMessage());
			map.put("bool", false);
			e.printStackTrace();
		} finally {
			try {
				if (st != null) st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
