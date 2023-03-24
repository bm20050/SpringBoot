package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDao {

	private Connection con = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;

	public MemberDao() throws Exception {
		Class.forName("org.h2.Driver");
		con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
	}

	public List<MemberVO> getMembers() {
		try {
			List<MemberVO> list = new ArrayList<>();
			String query = "select * from member";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"), rs.getDate("regidate")));
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public MemberVO getMember(Integer id) {
		try {
			String query = "select * from member where id = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			rs = psmt.executeQuery();
			MemberVO memberVO = new MemberVO();
			while (rs.next()) {
				memberVO.setId(rs.getInt("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setRegidate(rs.getDate("regidate"));
			}
			
			return memberVO;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public MemberVO addMember(MemberVO m) {
		try {
			String query = "insert into member(pass, name) values(?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, m.getPass());
			psmt.setString(2, m.getName());
			
			psmt.executeUpdate();
			List<MemberVO> l = getMembers();
			return getMember(l.get(l.size() - 1).getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public MemberVO updateMember(MemberVO m) {
		try {
			if (m.getName() == null) {
				String query = "update member set pass = ? where id = ?";
				psmt = con.prepareStatement(query);
				psmt.setString(1, m.getPass());
				psmt.setInt(2, m.getId());
			}
			else if (m.getPass() == null) {
				String query = "update member set name = ? where id = ?";
				psmt = con.prepareStatement(query);
				psmt.setString(1, m.getName());
				psmt.setInt(2, m.getId());
			}
			else {
				String query = "update member set pass = ?, name = ? where id = ?";
				psmt = con.prepareStatement(query);
				psmt.setString(1, m.getPass());
				psmt.setString(2, m.getName());
				psmt.setInt(3, m.getId());
			}
			
			
			psmt.executeUpdate();
			return getMember(m.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public MemberVO removeMember(Integer id) {
		try {
			MemberVO memberVO = getMember(id);
			String query = "delete from member where id = ?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			
			psmt.executeUpdate();
			
			return memberVO;
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
