package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RecBoardDAO {
	private DataSource ds;
	
	public RecBoardDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	
	/**추천하기 테이블 만들기**/
	public int create(RecBoard recBoard) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO REC_BOARD VALUES ");
			insertQuery.append("('RB' || rec_board_seq.nextval, ?, ?)");
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, recBoard.getMember_id());
			pstmt.setString(2, recBoard.getBoard_code());
			
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
	
	
	/**추천하기 테이블을 만들기 전에 검색을 통해 해당 게시물을 추천했는지 확인한다
	 * String member_id 와  board_code를 이용**/
	public RecBoard recBoardInfo(String member_id, String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("rec_id ");
			findQuery.append("FROM REC_BOARD ");
			findQuery.append("WHERE board_code=? AND member_id=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, board_code);
			pstmt.setString(2, member_id);
			
			rs = pstmt.executeQuery();
			
			RecBoard recBoard = null;
			if (rs.next()) {
				recBoard = new RecBoard();
				recBoard.setBoard_code(board_code);
				recBoard.setMember_id(member_id);
				recBoard.setRec_id(rs.getString("recBoard"));
			}
			
			con = null;
			pstmt = null;

			
			return recBoard;
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
