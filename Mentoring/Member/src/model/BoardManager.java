package model;

import java.sql.SQLException;
import java.util.List;

public class BoardManager {
	private static BoardManager boardMan = new BoardManager();
	private BoardDAO boardDAO;
	private BoardAnalysis boardAanlysis;
	
	private BoardManager() {
		try {
			boardDAO = new BoardDAO();
			boardAanlysis = new BoardAnalysis(boardDAO);
			
			System.out.println("boardManager::::     baordDAO°ª: " + boardDAO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardManager getInstance() {
		System.out.println("boardManager::::     getInstance IN");
		return boardMan;		
	}
	
	public int create(Board board) throws SQLException {
		System.out.println("boardManager::::     create IN");
		return boardDAO.create(board);
	}
	
	public List<Board> retrieveBoardList(int currentPage, int countPerPage) throws SQLException {
		System.out.println("boardManager::::          retrieveBoardList In : "  + boardDAO.retrieveBoardList(currentPage, countPerPage));
		
		
		return boardDAO.retrieveBoardList(currentPage, countPerPage);
	}
	
	public Board retrieveBoard(String board_code) throws SQLException {
		
		Board board = boardDAO.retrieveBoard(board_code);
		
		System.out.println("boardManager::::          retrieveBoard In  board_code : " + board_code);
		
		return board;
		
	}
	
	public Board retrieveBoardIn(String board_code) throws SQLException {
		
		Board board = boardDAO.retrieveBoardIn(board_code);
		
		return board;
		
	}
	
	public Board updateReccount(String board_code) throws SQLException {
		Board board = boardDAO.updateReccount(board_code);
		return board;
	}
	
	public int updateReplycount(String board_code) throws SQLException {
		return boardDAO.updateReplycount(board_code);
	}
	
	public List<Board> bestBoardByReccount() throws SQLException {
		return boardDAO.bestBoardByReccount();
	}
	
	public List<Board> bestBoardByreadcount() throws SQLException {
		return boardDAO.bestBoardByreadcount();
	}
	
	public int boardRemove(String board_code) throws SQLException {
		return boardDAO.boardRemove(board_code);
	}
	
	public int boardmodify(Board board) throws SQLException {
		return boardDAO.boardModify(board);
	}
	
	public List<Board> boardSearchBySubject(String searchText) throws SQLException {
		return boardDAO.boardSearchBySubject(searchText);
	}
	
	public List<Board> boardSearchByWriter(String searchText) throws SQLException {
		return boardDAO.boardSearchByWriter(searchText);
	}
	
	
	
	
//	public int update(Board board) throws SQLException {
//		System.out.println("readcount update board manager");
//		return boardDAO.update(board);
//	}
}
