package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ApplyDAO {
	private DataSource ds;
	
	public ApplyDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	
	/**지원 테이블 생성**/
	public int create(Apply apply) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO APPLY VALUES ");
			insertQuery.append("(?, ?, ?)");
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, apply.getTeam_id());
			pstmt.setString(2, apply.getMember_id());
			pstmt.setString(3, apply.getState());
		
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
	}
	

	
	/**수락, 거절 버튼을 누르면 팀멤버가 되거나 안되거나 apply 테이블은 지워진다.**/
	/**팀 아이디를 이용해 삭제**/
	public int remove(String team_id, String member_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("DELETE FROM APPLY WHERE TEAM_ID=? AND MEMBER_ID=? ");
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, team_id);
			pstmt.setString(2, member_id);
			
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		
	}
	
	/**팀아이디를 이용해 지원자 목록을 가져온다. 멘토가 수락거절가능**/
	public List<Apply> retrieveApplyList(String team_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("member_id, state ");
			findQuery.append("FROM APPLY ");
			findQuery.append("WHERE team_id=? ");
			
			con = ds.getConnection();
			String test = findQuery.toString();
			
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, team_id);
			
			rs = pstmt.executeQuery();
			
			List<Apply> ApplyList = new ArrayList<Apply>();
			while(rs.next()) {
				Apply apply = new Apply();
				
				apply.setMember_id(rs.getString("member_id"));
				apply.setState(rs.getString("state"));
				apply.setTeam_id(team_id);
				
				ApplyList.add(apply);
			}
			
			return ApplyList;

		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	
	}
	
	
	/**본인 지원 현황보기**/
	public List<Apply> retrieveApplyListByMemeber_id(String member_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("team_id, state ");
			findQuery.append("FROM APPLY ");
			findQuery.append("WHERE member_id=? ");
			
			con = ds.getConnection();
			String test = findQuery.toString();
			
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, member_id);
			
			rs = pstmt.executeQuery();
			
			List<Apply> ApplyList = new ArrayList<Apply>();
			while(rs.next()) {
				Apply apply = new Apply();
				
				apply.setMember_id(member_id);
				apply.setState(rs.getString("state"));
				apply.setTeam_id(rs.getString("team_id"));
				
				ApplyList.add(apply);
			}
			
			return ApplyList;

		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
}
