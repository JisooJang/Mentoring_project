package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource ds;
	
	public BoardDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	
	
	
	/**board table 생성**/
	public int create(Board board) throws SQLException {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO TB_BOARD_INFO VALUES ");
			insertQuery.append("('BOARD000' || BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");		
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(insertQuery.toString());
			//pstmt.setString(1, board.getBoard_code());
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getPw());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getRegdate());
			pstmt.setInt(6, board.getReadcount());
			pstmt.setInt(7, board.getReplycount());
			pstmt.setInt(8, board.getReccount());
			
			
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
	
	
	
	/**boardList 보여주기**/
	public List<Board> retrieveBoardList(int currentPage, int countPerPage) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				StringBuffer findQuery = new StringBuffer();
				findQuery.append("SELECT board_code, writer, pw, subject, content, regdate, readcount, replycount, reccount ");
				findQuery.append("FROM TB_BOARD_INFO ORDER BY regdate");
							
				con = ds.getConnection();
								
				pstmt = con.prepareStatement(findQuery.toString(),
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY );
				
			
				rs = pstmt.executeQuery();
				
				
				System.out.println("rs????   " + rs);
				int start = ((currentPage-1) * countPerPage) + 1;
				
				List<Board> boardList = null;
				if ((start >= 0) && rs.absolute(start)) {
					boardList = new ArrayList<Board>();
					do {
						Board board = new Board();
						board.setBoard_code(rs.getString("board_code"));
						board.setWriter(rs.getString("writer"));
						board.setPw(rs.getString("pw"));
						board.setSubject(rs.getString("subject"));
						board.setContent(rs.getString("content"));
						board.setRegdate(rs.getString("regdate"));
						board.setReadcount(rs.getInt("readcount"));
						board.setReplycount(rs.getInt("replycount"));
						board.setReccount(rs.getInt("reccount"));
						boardList.add(board);
					} while ((rs.next()) && (--countPerPage > 0));
				}
			
				return boardList;
			} finally {
				if ( pstmt != null ){
					pstmt.close();
				}			
				if ( con != null ){
					con.close();
				}
			}	
	}
	
	// board_view 보여주기
	public Board retrieveBoard(String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("writer, pw, subject, content, regdate, readcount, replycount, reccount ");
			findQuery.append("FROM TB_BOARD_INFO ");
			findQuery.append("WHERE board_code=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, board_code);
			
			rs = pstmt.executeQuery();
			
			Board board = null;
			if ( rs.next() ) {
				board = new Board();
				board.setBoard_code(board_code);
				board.setWriter(rs.getString("writer"));
				board.setPw(rs.getString("pw"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcount(Integer.parseInt(rs.getString("readcount")) + 1);
				board.setReplycount(Integer.parseInt(rs.getString("replycount")));
				int test = Integer.parseInt(rs.getString("reccount"));
				board.setReccount(Integer.parseInt(rs.getString("reccount")));
			}
			
//			//readcount +1
			con = null;
			pstmt = null;
			
				StringBuffer updateQuery = new StringBuffer();
				updateQuery.append("UPDATE TB_BOARD_INFO SET ");
				updateQuery.append("readcount=? ");
				updateQuery.append("WHERE board_code=? ");	
				
				con = ds.getConnection();
				pstmt = con.prepareStatement(updateQuery.toString());
				pstmt.setInt(1, board.getReadcount());
				pstmt.setString(2, board.getBoard_code());
				
				
				int result = pstmt.executeUpdate();
				
				
			return board;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
		
	}
	
	public Board retrieveBoardIn(String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("writer, pw, subject, content, regdate, readcount, replycount, reccount ");
			findQuery.append("FROM TB_BOARD_INFO ");
			findQuery.append("WHERE board_code=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, board_code);
			
			rs = pstmt.executeQuery();
			
			Board board = null;
			if ( rs.next() ) {
				board = new Board();
				board.setBoard_code(board_code);
				board.setWriter(rs.getString("writer"));
				board.setPw(rs.getString("pw"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcount(Integer.parseInt(rs.getString("readcount")));
				board.setReplycount(Integer.parseInt(rs.getString("replycount")));
				board.setReccount(Integer.parseInt(rs.getString("reccount")));
			}
			
//			
			con = null;
			pstmt = null;

			
			return board;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
		
	}
	
//// 추천수 높이기
//	public Board increaseReccount(String board_code) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			StringBuffer findQuery = new StringBuffer();
//			findQuery.append("SELECT ");
//			findQuery.append("writer, pw, subject, content, regdate, readcount, replycount, reccount ");
//			findQuery.append("FROM TB_BOARD_INFO ");
//			findQuery.append("WHERE board_code=? ");
//			
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(findQuery.toString());
//			pstmt.setString(1, board_code);
//			
//			rs = pstmt.executeQuery();
//			
//			Board board = null;
//			if ( rs.next() ) {
//				board = new Board();
//				board.setBoard_code(board_code);
//				board.setWriter(rs.getString("writer"));
//				board.setPw(rs.getString("pw"));
//				board.setSubject(rs.getString("subject"));
//				board.setContent(rs.getString("content"));
//				board.setRegdate(rs.getString("regdate"));
//				board.setReadcount(Integer.parseInt(rs.getString("readcount")));
//				board.setReplycount(Integer.parseInt(rs.getString("replycount")));
//				int test = Integer.parseInt(rs.getString("reccount"));
//				board.setReccount(Integer.parseInt(rs.getString("reccount")) + 1);
//			}
//			
////			//reccount +1
//			con = null;
//			pstmt = null;
//			
//				StringBuffer updateQuery = new StringBuffer();
//				updateQuery.append("UPDATE TB_BOARD_INFO SET ");
//				updateQuery.append("reccount=? ");
//				updateQuery.append("WHERE board_code=? ");	
//				
//				con = ds.getConnection();
//				pstmt = con.prepareStatement(updateQuery.toString());
//				pstmt.setInt(1, board.getReccount());
//				pstmt.setString(2, board.getBoard_code());
//				
//				
//				int result = pstmt.executeUpdate();
//				
//				
//			return board;
//		} finally {
//			if ( pstmt != null ){
//				pstmt.close();
//			}			
//			if ( con != null ){
//				con.close();
//			}
//		}
//	}
	
	public Board updateReccount(String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("writer, pw, subject, content, regdate, readcount, replycount, reccount ");
			findQuery.append("FROM TB_BOARD_INFO ");
			findQuery.append("WHERE board_code=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, board_code);
			
			rs = pstmt.executeQuery();
			
			Board board = null;
			if ( rs.next() ) {
				board = new Board();
				board.setBoard_code(board_code);
				board.setWriter(rs.getString("writer"));
				board.setPw(rs.getString("pw"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setReadcount(Integer.parseInt(rs.getString("readcount")));
				board.setReplycount(Integer.parseInt(rs.getString("replycount")));
				int test = Integer.parseInt(rs.getString("reccount"));
				board.setReccount(Integer.parseInt(rs.getString("reccount")) + 1);
			}
			
//			//reccount +1
			con = null;
			pstmt = null;
			
				StringBuffer updateQuery = new StringBuffer();
				updateQuery.append("UPDATE TB_BOARD_INFO SET ");
				updateQuery.append("reccount=? ");
				updateQuery.append("WHERE board_code=? ");	
				
				con = ds.getConnection();
				pstmt = con.prepareStatement(updateQuery.toString());
				pstmt.setInt(1, board.getReccount());
				pstmt.setString(2, board.getBoard_code());
				
				
				int result = pstmt.executeUpdate();
				
				
			return board;
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
		
	}
	
	public int updateReplycount(String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer updateQuery = new StringBuffer();
			updateQuery.append("UPDATE TB_BOARD_INFO SET ");
			updateQuery.append("replycount = replycount + 1 ");
			updateQuery.append("WHERE board_code=? ");	
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, board_code);
			
			int result = pstmt.executeUpdate();
			
			return result;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	//추천수에 따른 게시글 보기 3개만
	public List<Board> bestBoardByReccount() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT * FROM ( SELECT * FROM TB_BOARD_INFO ORDER BY RECCOUNT DESC ) WHERE ROWNUM <= 3 ");
						
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			
			rs = pstmt.executeQuery();
			
			List<Board> BoardList = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoard_code(rs.getString("board_code"));
				board.setContent(rs.getString("content"));
				board.setPw(rs.getString("pw"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReccount(rs.getInt("reccount"));
				board.setRegdate(rs.getString("regdate"));
				board.setReplycount(rs.getInt("replycount"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				
				BoardList.add(board);
			}
			
			return BoardList;
			
			
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	//조회수에 따른 게시글 보기 3개만
	public List<Board> bestBoardByreadcount() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT * FROM ( SELECT * FROM TB_BOARD_INFO ORDER BY RECCOUNT DESC ) WHERE ROWNUM <= 3 ");
						
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			
			rs = pstmt.executeQuery();
			
			List<Board> BoardList = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoard_code(rs.getString("board_code"));
				board.setContent(rs.getString("content"));
				board.setPw(rs.getString("pw"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReccount(rs.getInt("reccount"));
				board.setRegdate(rs.getString("regdate"));
				board.setReplycount(rs.getInt("replycount"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				
				BoardList.add(board);
			}
			
			return BoardList;
			
			
			
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	
	//게시글 지우기
	public int boardRemove(String board_code) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer deleteQuery = new StringBuffer();
			
			deleteQuery.append("DELETE FROM TB_BOARD_INFO ");
			deleteQuery.append("WHERE board_code=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(deleteQuery.toString());
			pstmt.setString(1, board_code);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	//게시글 수정
	public int boardModify(Board board) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer updateQuery = new StringBuffer();

			updateQuery.append("UPDATE TB_BOARD_INFO SET ");
			updateQuery.append("pw=?, subject=?, content=? ");
			updateQuery.append("WHERE board_code=? ");	
			
			String test = board.getBoard_code();
			String test2 = board.getSubject();
			String test3 = board.getRegdate();
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, board.getPw());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getBoard_code());
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	//게시글 검색 - 제목
	public List<Board> boardSearchBySubject(String searchText) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT * FROM TB_BOARD_INFO ");
			findQuery.append("WHERE subject=? ");
			
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, searchText);
			
			
			rs = pstmt.executeQuery();
			
			List<Board> BoardList = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoard_code(rs.getString("board_code"));
				board.setContent(rs.getString("content"));
				board.setPw(rs.getString("pw"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReccount(rs.getInt("reccount"));
				board.setRegdate(rs.getString("regdate"));
				board.setReplycount(rs.getInt("replycount"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				
				BoardList.add(board);
			}
			
			return BoardList;
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
	
	//게시글 검색 - 아이디
	public List<Board> boardSearchByWriter(String searchText) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT * FROM TB_BOARD_INFO ");
			findQuery.append("WHERE writer=? ");
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(2, searchText);
			
			rs = pstmt.executeQuery();
			
			List<Board> BoardList = new ArrayList<Board>();
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoard_code(rs.getString("board_code"));
				board.setContent(rs.getString("content"));
				board.setPw(rs.getString("pw"));
				board.setReadcount(rs.getInt("readcount"));
				board.setReccount(rs.getInt("reccount"));
				board.setRegdate(rs.getString("regdate"));
				board.setReplycount(rs.getInt("replycount"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				
				BoardList.add(board);
			}
			
			return BoardList;
			
			
			
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}
	
//	//게시판보면 조회수+1 증가하게 하기 
//	public int update(Board board) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			StringBuffer updateQuery = new StringBuffer();
//			updateQuery.append("UPDATE TB_BOARD_INFO SET ");
//			updateQuery.append("readcount=? ");
//			updateQuery.append("WHERE board_code=? ");	
//			
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(updateQuery.toString());
//			pstmt.setInt(1, board.getReadcount() + 1);
//			pstmt.setString(2, board.getBoard_code());
//			
//			
//			int result = pstmt.executeUpdate();
//			
//			System.out.println("UPDATE ::::::: READCOUNT :::::               " + board.getReadcount());
//			
//			return result;
//		
//		}  finally {
//			if ( pstmt != null ){
//				pstmt.close();
//			}
//			if ( con != null ){
//				con.close();
//			}
//		}
//	}




}
