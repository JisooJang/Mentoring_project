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


public class TeamBoardDAO {

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
	public TeamBoardDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}

	public int write(TeamBoard board) throws SQLException {
		try {
			StringBuffer query = new StringBuffer();
			//String insertQuery = "INSERT INTO TEAM_BOARD VALUES (board_num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?) ";	
			//query.append(insertQuery);

			query.append("INSERT INTO TEAM_BOARD VALUES ");
			query.append("(board_num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?) ");


			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());

			pstmt.setString(1, board.getTeam_id());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getB_date());
			pstmt.setString(4, board.getB_content());
			pstmt.setInt(5, board.getComment_count());
			pstmt.setInt(6, board.getHits());
			pstmt.setString(7, board.getWriter_id());
			pstmt.setString(8, board.getAdmin_id());
			int result = pstmt.executeUpdate();
			return result;
		} 
		finally {
			disconnect();
		}
	}

	public int update(TeamBoard board) throws SQLException {
		try {
			query = new StringBuffer();
			query.append("UPDATE TEAM_BOARD SET title=?, b_date=?, b_content=? ");
			query.append("WHERE board_num=? AND team_id=?");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getB_date());
			pstmt.setString(3, board.getB_content());
			pstmt.setInt(4, board.getBoard_num());
			pstmt.setString(5, board.getTeam_id());

			int result = pstmt.executeUpdate();

			return result;

		}
		finally {
			disconnect();
		}
	}

	public int remove(int board_num, String team_id) throws SQLException {
		try {
			query = new StringBuffer();
			query.append("DELETE FROM TEAM_BOARD WHERE board_num=? AND team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, board_num);
			pstmt.setString(2, team_id);
			int result = pstmt.executeUpdate();

			return result;
		}
		finally {
			disconnect();
		}
	}

	/*public List<TeamBoard> getBoardList(int currentPage, int countPerPage) throws SQLException {
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT * FROM TEAM_BOARD ORDER BY B_DATE ");
			query.append(findQuery);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			int start = ((currentPage-1) * countPerPage) + 1;
			List<TeamBoard> list = null;

			if ((start >= 0) && rs.absolute(start)) {
				list = new ArrayList<TeamBoard>();
				do {
					TeamBoard board = new TeamBoard();
					board.setBoard_num(rs.getInt("board_num"));
					board.setTeam_id(rs.getString("team_id"));
					board.setTitle(rs.getString("title"));
					board.setB_date(rs.getString("b_date"));
					board.setB_content(rs.getString("b_content"));
					board.setComment_count(rs.getInt("comment_count"));
					board.setHits(rs.getInt("hits"));
					board.setWriter_id(rs.getString("writer_id"));

					list.add(board);
				} while ((rs.next()) && (--countPerPage > 0));

			}

			return list;
		}
		finally {
			disconnect();
		}

	} */

	public List<TeamBoard> getBoardList(String team_id) throws SQLException {
		try {
			query = new StringBuffer();
			String findQuery = "SELECT * FROM TEAM_BOARD WHERE team_id=? ORDER BY board_num DESC ";
			query.append(findQuery);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			rs = pstmt.executeQuery();
			List<TeamBoard> list = new ArrayList<TeamBoard>();


			while (rs.next()) {
				TeamBoard board = new TeamBoard();
				board.setBoard_num(rs.getInt("board_num"));
				board.setTeam_id(rs.getString("team_id"));
				board.setTitle(rs.getString("title"));
				board.setB_date(rs.getString("b_date"));
				board.setB_content(rs.getString("b_content"));
				board.setComment_count(rs.getInt("comment_count"));
				board.setHits(rs.getInt("hits"));
				board.setWriter_id(rs.getString("writer_id"));

				list.add(board);
			}

			return list;
		}
		finally {
			disconnect();
		}

	} 

	public TeamBoard getBoard(int board_num, String team_id) throws SQLException {
		try {
			query = new StringBuffer();
			query.append("SELECT * FROM TEAM_BOARD WHERE board_num=? AND team_id=? ORDER BY board_num DESC ");

			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, board_num);
			pstmt.setString(2, team_id);
			rs = pstmt.executeQuery();

			TeamBoard board = null;

			while(rs.next()) {
				board = new TeamBoard();

				board.setBoard_num(rs.getInt("board_num"));
				board.setTeam_id(rs.getString("team_id"));
				board.setTitle(rs.getString("title"));
				board.setB_date(rs.getString("b_date"));
				board.setB_content(rs.getString("b_content"));
				board.setComment_count(rs.getInt("comment_count"));
				board.setHits(rs.getInt("hits"));
				board.setWriter_id(rs.getString("writer_id"));
			} 

			return board;
		}

		finally {
			disconnect();
		}
	}

	public String getTeam_name(String team_id) throws SQLException {
		try {
			String team_name = "";
			query = new StringBuffer();
			query.append("SELECT team_name FROM team WHERE team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {	// while문에 안들어감
				team_name = rs.getString("team_name");
			}

			return team_name;
		}
		finally {
			disconnect();
		}
	}

	public List<Team> getTeamList(String mbId) throws SQLException {
		try {
			List<Team> list = new ArrayList<Team>();

			query = new StringBuffer();
			query.append("SELECT t.team_id, t.mento_id, t.nofp, t.start_date, t.recruit, t.end_date, "
					+ "t.team_name, t.extend, t.field FROM team t, team_member m "
					+ "WHERE t.team_id = m.team_id AND m.member_id=?");

			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mbId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Team team = new Team();

				team.setTeam_id(rs.getString("team_id"));
				team.setMento_id(rs.getString("mento_id"));
				team.setNofp(rs.getInt("nofp"));
				team.setStart_date(rs.getString("start_date"));
				team.setRecruit(rs.getString("recruit"));
				team.setEnd_date(rs.getString("end_date"));
				team.setTeam_name(rs.getString("team_name"));
				team.setExtend(rs.getString("extend"));
				team.setField(rs.getString("field"));

				list.add(team);
			}

			return list;
		}
		finally {
			disconnect();
		}
	}
	
	public Team getTeam(String team_id) throws SQLException {
		try {		
			Team team = new Team();

			query = new StringBuffer();
			query.append("SELECT * FROM team WHERE team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				team.setTeam_id(rs.getString("team_id"));
				team.setMento_id(rs.getString("mento_id"));
				team.setNofp(rs.getInt("nofp"));
				team.setStart_date(rs.getString("start_date"));
				team.setRecruit(rs.getString("recruit"));
				team.setEnd_date(rs.getString("end_date"));
				team.setTeam_name(rs.getString("team_name"));
				team.setExtend(rs.getString("extend"));
				team.setField(rs.getString("field"));
			}
			
			return team;
		}
		finally {
			disconnect();
		}
	}

	public List<Member> getTeamMemberList(String team_id) throws SQLException {	//팀 주소록 출력
		try {
			List<Member> list = new ArrayList<Member>();

			query = new StringBuffer();
			query.append("SELECT UNIQUE d.member_id, d.m_name, d.age, d.email, d.phone, d.img FROM d_member d, team_member t WHERE d.member_id = t.member_id AND t.team_id=? ");

			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Member member = new Member();

				member.setMbID(rs.getString("member_id"));
				member.setMbName(rs.getString("m_name"));
				member.setAge(rs.getInt("age"));

				String[] email = rs.getString("email").split("@");
				member.setEmail(email);

				String[] phone=rs.getString("phone").split("-");
				member.setPhone(phone);

				member.setImg(rs.getString("img"));

				list.add(member);
			}

			return list;
		}
		finally {
			disconnect();
		}
	}


	public int calendar_write(TeamCalendar calendar) throws SQLException {
		try {
			query = new StringBuffer();
			query.append("INSERT INTO team_calendar VALUES ");
			query.append("(calendar_id_seq.nextval, ?, ?, ?, ?, ?, ?) ");	
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());

			pstmt.setString(1, calendar.getTeam_id());
			pstmt.setString(2, calendar.getWriter_id());
			pstmt.setString(3, calendar.getC_date());
			pstmt.setString(4, calendar.getC_content());
			pstmt.setString(5, calendar.getC_time());
			pstmt.setString(6, calendar.getC_spot());

			int result = pstmt.executeUpdate();

			return result;		
		}
		finally {
			disconnect();
		}
	}


	public int calendar_remove(int calendar_id, String team_id) throws SQLException {
		try {
			query = new StringBuffer();
			query.append("DELETE FROM team_calendar WHERE calendar_id=? AND team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, calendar_id);
			pstmt.setString(2, team_id);
			int result = pstmt.executeUpdate();

			return result;
		}
		finally {
			disconnect();
		}
	}

	public int calendar_update(TeamCalendar calendar) throws SQLException {
		try {
			query = new StringBuffer();
			String sql = "UPDATE team_calendar SET c_content=?, c_time=? ";
			query.append(sql);
			query.append("WHERE calendar_id=? AND team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());

			pstmt.setString(1, calendar.getC_content());
			pstmt.setString(2, calendar.getC_time());
			pstmt.setInt(3, calendar.getCalendar_id());
			pstmt.setString(4, calendar.getTeam_id());


			int result = pstmt.executeUpdate();

			return result;

		}
		finally {
			disconnect();
		}
	}

	public List<TeamCalendar> getCalendarList(String team_id) throws SQLException {
		try {
			List<TeamCalendar> list = new ArrayList<TeamCalendar>();
			query = new StringBuffer();
			query.append("SELECT * from team_calendar where team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				TeamCalendar c = new TeamCalendar();

				c.setCalendar_id(rs.getInt("calendar_id"));
				c.setTeam_id(rs.getString("team_id"));
				c.setWriter_id(rs.getString("writer_id"));
				c.setC_date(rs.getString("c_date"));
				c.setC_content(rs.getString("c_content"));
				c.setC_time(rs.getString("c_time"));
				c.setC_spot(rs.getString("c_spot"));

				list.add(c);
			}

			return list;
		}
		finally {
			disconnect();
		}
	}

	public TeamCalendar getCalendar(int calendar_id, String team_id) throws SQLException {
		try {
			query = new StringBuffer();
			query.append("SELECT * FROM team_calendar WHERE calendar_id=? AND team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, calendar_id);
			pstmt.setString(2, team_id);
			rs = pstmt.executeQuery();

			TeamCalendar cal = null;

			while(rs.next()) {

				cal = new TeamCalendar();
				cal.setCalendar_id(calendar_id);
				cal.setTeam_id(rs.getString("team_id"));
				cal.setWriter_id(rs.getString("writer_id"));
				cal.setC_date(rs.getString("c_date"));
				cal.setC_content(rs.getString("c_content"));
				cal.setC_time(rs.getString("c_time"));
				cal.setC_spot(rs.getString("c_spot"));

			}

			return cal;
		}
		finally {
			disconnect();
		}

	}

	public List<String> getTeamIdList(String team_id) throws SQLException {
		try {
			List<String> idList = new ArrayList<String>();
			query = new StringBuffer();
			query.append("SELECT member_id FROM team_member WHERE team_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, team_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String id =  rs.getString("member_id");
				idList.add(id);		
			}
			
			return idList;
		}
		finally {
			disconnect();
		}
	}

}
