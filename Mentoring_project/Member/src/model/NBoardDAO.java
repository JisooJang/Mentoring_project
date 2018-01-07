package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NBoardDAO {

	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	public NBoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");

		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}

	}

	// ���� ���� ���ϱ�
	public int getListCount() {
		int x = 0;

		try {

			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("getListCount ����: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return x;
	}

	// �� ��� ����
	public List getBoardList(int page, int limit) {

		String board_list_sql = "select * from " + "(select rownum rnum,NOTI_NUM,NOTI_SUBJECT,"
				+ "NOTI_CONTENT,NOTI_DATE,NOTI_READCOUNT from " + "(select * from noti)) "
				+ "where rnum>=? and rnum<=?";

		List list = new ArrayList();

		int startrow = (page - 1) * 10 + 1; // �б� ������ row ��ȣ.
		int endrow = startrow + limit - 1; // ���� ������ row ��ȣ.
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			System.out.println("execute");
			while (rs.next()) {
				NBoardBean nboard = new NBoardBean();
				nboard.setNOTI_NUM(rs.getInt("NOTI_NUM"));
				nboard.setNOTI_SUBJECT(rs.getString("NOTI_SUBJECT"));
				nboard.setNOTI_CONTENT(rs.getString("NOTI_CONTENT"));
				nboard.setNOTI_DATE(rs.getDate("NOTI_DATE"));
				nboard.setNOTI_READCOUNT(rs.getInt("NOTI_READCOUNT"));
				System.out.println(nboard.getNOTI_SUBJECT());

				list.add(nboard);
			}

			return list;
		} catch (Exception ex) {
			System.out.println("getBoardList ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
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

	// �� ���� ����.
	public NBoardBean getDetail(int num) throws Exception {

		NBoardBean nboard = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from noti where NOTI_NUM = ?");
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				nboard = new NBoardBean();
				nboard.setNOTI_NUM(rs.getInt("NOTI_NUM"));
				nboard.setNOTI_SUBJECT(rs.getString("NOTI_SUBJECT"));
				nboard.setNOTI_CONTENT(rs.getString("NOTI_CONTENT"));
				nboard.setNOTI_DATE(rs.getDate("NOTI_DATE"));
				nboard.setNOTI_READCOUNT(rs.getInt("NOTI_READCOUNT"));

				System.out.println(nboard.getNOTI_SUBJECT());
			}
			System.out.println(nboard.getNOTI_SUBJECT() + "!!!");
			return nboard;
		} catch (Exception ex) {
			System.out.println("getDetail ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
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

	// �� ���
	public boolean boardInsert(NBoardBean nboard) {

		int num = 0;
		String sql = "";

		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();

			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into noti (NOTI_NUM,NOTI_SUBJECT,";
			sql += "NOTI_CONTENT, NOTI_DATE, NOTI_READCOUNT)" + " values(NOTI_NUM_SEQ.NEXTVAL,?,?,sysdate,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nboard.getNOTI_SUBJECT());
			pstmt.setString(2, nboard.getNOTI_CONTENT());
			pstmt.setInt(3, nboard.getNOTI_READCOUNT());

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("boardInsert ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	// �� ����
	public boolean boardModify(NBoardBean modifyboard) throws Exception {

		String sql = "update noti set NOTI_SUBJECT=?,NOTI_CONTENT=? where NOTI_NUM=?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getNOTI_SUBJECT());
			pstmt.setString(2, modifyboard.getNOTI_CONTENT());
			pstmt.setInt(3, modifyboard.getNOTI_NUM());
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("boardModify ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	// �� ����
	public boolean boardDelete(int num) {

		String board_delete_sql = "delete from noti where NOTI_NUM=?";

		int result = 0;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("boardDelete ���� : " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}

		}

		return false;
	}

	// ��ȸ�� ������Ʈ
	public void setReadCountUpdate(int num) throws Exception {

		String sql = "update noti set NOTI_READCOUNT = " + "NOTI_READCOUNT+1 where NOTI_NUM = " + num;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("setReadCountUpdate ���� : " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}

		}
	}

	// �۾������� Ȯ��
	public boolean isBoardWriter(String check){
			
//			String check_admin = "select * from d_member where PASSWD=?";
//			
//			try{
//				con = ds.getConnection();
//				stmt=con.createStatement();
//				rs=pstmt.executeQuery(check_admin);
//				
//				rs.next();
//			}catch(SQLException ex){
//				System.out.println("isBoardWriter ���� : "+ex);
//			}
//		finally{
//				try{
//				if(pstmt!=null)pstmt.close();
//				if(con!=null) con.close();
//				}
//				catch(Exception ex){}
//			
//		}

		/*  ������ �н������� ���� */
		if(check == null){
			return true;
		}
			return false;
		}
}
