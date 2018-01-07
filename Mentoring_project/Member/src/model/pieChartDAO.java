package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//import model.pieChartData.KeyValue;

public class pieChartDAO {

	DataSource ds;
	Connection con;
	Statement stmt;
	ResultSet rs;
	List<pieChartData> pieDataList;

	public pieChartDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}

	}

	public String change_keyword(String keyword) {

		String change = null;
		switch (keyword) {
		case "01":change = "디자인";break;
		case "02":change = "IT/프로그래밍";break;
		case "03":change = "운동/스포츠";break;
		case "04":change = "아웃도어/여행";break;
		case "05":change = "언어/외국어";break;
		case "06":change = "봉사";break;
		case "07":change = "뷰티";break;
		case "08":change = "건강/의학";break;
		case "09":change = "문학/책";break;
		case "10":change = "음악/악기";break;
		case "11":change = "댄스";break;
		case "12":change = "사진";break;
		case "13":change = "게임/오락";break;
		case "14":change = "요리";break;
		case "15":change = "경제/주식";break;
		}

		return change;
	}

	public List<pieChartData> getPieDataList() throws Exception {

		pieDataList = new ArrayList<pieChartData>();
		pieChartData pData;
		try {
			con = ds.getConnection();
			String query = "select field, count(*) as count_team  from team group by field";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) 
			{
				int value = rs.getInt("count_team");
				String key = "";
				
				if (rs.getString("field") != null) 
				{
					key = change_keyword((String) rs.getString("field"));
				}
				else 
				{
					continue;
				}
				pData = new pieChartData(key, Integer.toString(value));

				pieDataList.add(pData);
			}

			return pieDataList;

		} catch (Exception ex) {
			System.out.println("statistics count 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}

}
