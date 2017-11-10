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

public class TeamMemberDAO {
private DataSource ds;
	
	public TeamMemberDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	
	/**apply�� state�� Y�� �ٲ�� ����� ����**/
	public int create(TeamMember team_member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO TEAM_MEMBER VALUES ");
			insertQuery.append("('TM' || team_member_seq.NEXTVAL, ?, ?)");
			
			con = ds.getConnection();

			String test1 = team_member.getMember_id();
			String test2 = team_member.getTeam_id();
			
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, team_member.getMember_id());
			pstmt.setString(2, team_member.getTeam_id());
		
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
	
	/**������Ϻҷ�����**/
	public List<TeamMember> retrieveTeamMemberList(String team_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("member_id, tm_id ");
			findQuery.append("FROM TEAM_MEMBER ");
			findQuery.append("WHERE team_id=? ");
			
			con = ds.getConnection();
			String test = findQuery.toString();
			
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, team_id);
			
			rs = pstmt.executeQuery();
			
			List<TeamMember> TeamMemberList = new ArrayList<TeamMember>();
			while(rs.next()) {
				TeamMember teamMem = new TeamMember();
				
				teamMem.setMember_id(rs.getString("member_id"));
				teamMem.setTm_id(rs.getString("tm_id"));
				teamMem.setTeam_id(team_id);
				
				TeamMemberList.add(teamMem);
			}
			
			return TeamMemberList;
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	
	/**���� �Ⱓ�� ������ �� ���� (team_id)�̿�**/
}
