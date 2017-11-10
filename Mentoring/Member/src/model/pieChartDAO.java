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
			System.out.println("DB ���� ���� : " + ex);
			return;
		}

	}

	public String change_keyword(String keyword) {

		String change = null;
		switch (keyword) {
		case "01":change = "������";break;
		case "02":change = "IT/���α׷���";break;
		case "03":change = "�/������";break;
		case "04":change = "�ƿ�����/����";break;
		case "05":change = "���/�ܱ���";break;
		case "06":change = "����";break;
		case "07":change = "��Ƽ";break;
		case "08":change = "�ǰ�/����";break;
		case "09":change = "����/å";break;
		case "10":change = "����/�Ǳ�";break;
		case "11":change = "��";break;
		case "12":change = "����";break;
		case "13":change = "����/����";break;
		case "14":change = "�丮";break;
		case "15":change = "����/�ֽ�";break;
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
			System.out.println("statistics count ���� : " + ex);
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
