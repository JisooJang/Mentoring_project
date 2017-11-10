package model;

import java.sql.SQLException;

public class RecBoardManager {
	private static RecBoardManager recBoardMan = new RecBoardManager();
	private RecBoardDAO recBoardDAO;
	private RecBoardAnalysis recBoardAnaylsis;
	
	private RecBoardManager() {
		try {
			recBoardDAO = new RecBoardDAO();
			recBoardAnaylsis = new RecBoardAnalysis(recBoardDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static RecBoardManager getInstance() {
		return recBoardMan;
	}
	
	public int create(RecBoard recBoard)  throws SQLException {
		return recBoardDAO.create(recBoard);
	}
}
