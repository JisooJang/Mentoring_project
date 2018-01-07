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

public class TeamDAO {
	
	private DataSource ds;
	StringBuffer query = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void disconnect() throws SQLException{
		if ( pstmt != null ){
			pstmt.close();
		}
		if ( con != null ){
			con.close();
		}
	}
    public TeamDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
    public int create(Team team) throws SQLException{
    	try{
    		query = new StringBuffer();
    		String sql = "INSERT INTO TEAM VALUES ('TEAMID' || team_id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?) ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			
			pstmt.setString(1, team.getMento_id());
			pstmt.setInt(2, team.getNofp());
			pstmt.setString(3, team.getStart_date());
			pstmt.setString(4, team.getRecruit());
			pstmt.setString(5, team.getEnd_date());
			pstmt.setString(6, team.getTeam_name());
			pstmt.setString(7, team.getExtend());
			pstmt.setString(8, team.getField());
		
			int result = pstmt.executeUpdate();
			return result;
    	}finally{
    		disconnect();
    	}
    }
    public int update(Team team) throws SQLException{
    	try{
    		query = new StringBuffer();
    		String sql = "UPDATE TEAM SET mento_id=?, nofp=?, start_date=?, recruit=?, emd_date=?, team_name=?, extend=?, field=?";
    		query.append(sql);
			query.append("WHERE team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			
			pstmt.setString(1, team.getMento_id());
			pstmt.setInt(2, team.getNofp());
			pstmt.setString(3, team.getStart_date());
			pstmt.setString(4, team.getRecruit());
			pstmt.setString(5, team.getEnd_date());
			pstmt.setString(6, team.getTeam_name());
			pstmt.setString(7, team.getExtend());
			pstmt.setString(8, team.getField());
			pstmt.setString(9, team.getTeam_id());
			
			int result = pstmt.executeUpdate();
			return result;
    	}finally{
    		disconnect();
    	}
    }
    public int delete(String team_id) throws SQLException{
    	try{
    		query = new StringBuffer();
			String sql = "DELETE FROM TEAM WHERE team_id=? ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			int result = pstmt.executeUpdate();			
			return result;
    	}finally{
    		disconnect();
    	}
    }
    public List<Team> BelongToTeam(String member_id) throws SQLException{
    	try{
    		List<Team> team=new ArrayList<Team>();
    		query = new StringBuffer();
    		String sql = "select * from TEAM where team_id=(select team_id from TEAM_MEMBER where MEMBER_ID = ?)";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Team t = new Team();
				t.setTeam_id(rs.getString("TEAM_ID"));
				t.setMento_id(rs.getString("MENTO_ID"));
				t.setNofp(rs.getInt("NOFP"));
				t.setStart_date(rs.getString("START_DATE"));
				t.setRecruit(rs.getString("RECRUIT"));
				t.setTeam_name(rs.getString("TEAM_NAME"));
				t.setExtend(rs.getString("EXTEND"));
				team.add(t);
			}
			return team;
    	}finally{
    		disconnect();
    	}
    }
    public List<Team> BelongToMento(String member_id) throws SQLException{
    	try{
    		List<Team> team=new ArrayList<Team>();
    		query = new StringBuffer();
    		String sql = "select * from TEAM where MENTO_ID = ? ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Team t = new Team();
				t.setTeam_id(rs.getString("TEAM_ID"));
				t.setMento_id(rs.getString("MENTO_ID"));
				t.setNofp(rs.getInt("NOFP"));
				t.setStart_date(rs.getString("START_DATE"));
				t.setRecruit(rs.getString("RECRUIT"));
				t.setTeam_name(rs.getString("TEAM_NAME"));
				t.setExtend(rs.getString("EXTEND"));
				team.add(t);
			}
			return team;
    	}finally{
    		disconnect();
    	}
    }
    public List<Team> retrieveTeamList(String sessionId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("team_id, team_name, end_date, extend, nofp, recruit, start_date ");
			findQuery.append("FROM TEAM ");
			findQuery.append("WHERE mento_id=? ");
			
			con = ds.getConnection();
			String test = findQuery.toString();
			
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, sessionId);
			
			
			
		
			rs = pstmt.executeQuery();
			
			
			List<Team> TeamList = new ArrayList<Team>();
			while(rs.next()) {
				Team team = new Team();
				
				team.setEnd_date(rs.getString("end_date"));
				team.setExtend(rs.getString("extend"));
				team.setMento_id(sessionId);
				team.setNofp(rs.getInt("nofp"));
				team.setRecruit(rs.getString("recruit"));
				team.setStart_date(rs.getString("start_date"));
				team.setTeam_id(rs.getString("team_id"));
				team.setTeam_name(rs.getString("team_name"));
				
				TeamList.add(team);
			}
			
			return TeamList;
			
		} finally {
			disconnect();
		}
	}
    public int updateTeamNofp(String team_id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer updateQuery = new StringBuffer();
			updateQuery.append("UPDATE TEAM SET ");
			updateQuery.append("nofp = nofp + 1 ");
			updateQuery.append("WHERE team_id=? ");	
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, team_id);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} finally {
			disconnect();
		}
	}
}
