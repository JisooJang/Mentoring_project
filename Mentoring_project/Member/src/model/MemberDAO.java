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

import model.Member;


public class MemberDAO {
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

	public MemberDAO() throws Exception {
		Context init = new InitialContext();
		ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
	}
	public int create(Member mb) throws SQLException{
		try {
			query = new StringBuffer();
			String sql = "INSERT INTO D_MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			
			pstmt.setString(1, mb.getMbID());
			pstmt.setString(2, mb.getMbName());
			pstmt.setInt(3, mb.getAge());
			pstmt.setString(4, mb.getPwd());
			pstmt.setString(5, mb.getJob());
			pstmt.setString(6, mb.getAddress());
			String email="";
			for(int i=0; i<mb.getEmail().length; i++){
				if(i==mb.getEmail().length-1){
					email+=mb.getEmail()[i];
				}else{
					email+=mb.getEmail()[i]+"@";
				}
			}
			pstmt.setString(7, email);
			 String birth = "";
	         for(int i=0 ; i<mb.getBirth().length ; i++) {
	        	 if(i==mb.getBirth().length-1){
	        		 birth+= mb.getBirth()[i]; 
	        	 }else{
	        		 birth+=mb.getBirth()[i]+"/";
	        	 }
	         }
			pstmt.setString(8, birth);
			String phone="";
			for(int i=0; i<mb.getPhone().length; i++){
				if(i==mb.getPhone().length-1){
					phone+=mb.getPhone()[i];
				}else{
					phone+=mb.getPhone()[i]+"-";
				}
			}
			pstmt.setString(9, phone);
			String field="";
			for(int i=0; i<mb.getField().length; i++){
				if(i==mb.getField().length-1){
					field+=mb.getField()[i];
				}else{
					field+=mb.getField()[i]+"-";
				}
			}
			pstmt.setString(10, field);
			String region="";
			for(int i=0; i<mb.getRegion().length; i++){
				if(i==mb.getRegion().length-1){
					region+=mb.getRegion()[i];
				}else{
					region+=mb.getRegion()[i]+"-";
				}
			}
			pstmt.setString(11, region);
			pstmt.setString(12, mb.getGender());
			pstmt.setString(13, mb.getAdmin_Id());
			pstmt.setString(14, mb.getImg());
			int result = pstmt.executeUpdate();
			return result;
		}finally {
			disconnect();
		}
	}
	public int update(Member mb) throws SQLException{
		try {
			query = new StringBuffer();
			String sql = "UPDATE D_MEMBER SET member_id=?, m_name=?, age=?, passwd=?, m_job=?, address=?, email=?, birth=?";
			sql += ", phone=?, m_field=?, region=?, gender=?, admin_id=?, img=? ";
			query.append(sql);
			query.append("WHERE member_id=? ");
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			
			pstmt.setString(1, mb.getMbID());
			pstmt.setString(2, mb.getMbName());
			pstmt.setInt(3, mb.getAge());
			pstmt.setString(4, mb.getPwd());
			pstmt.setString(5, mb.getJob());
			pstmt.setString(6, mb.getAddress());
			String email="";
			for(int i=0; i<mb.getEmail().length; i++){
				if(i==mb.getEmail().length-1){
					email+=mb.getEmail()[i];
				}else{
					email+=mb.getEmail()[i]+"@";
				}
			}
			pstmt.setString(7, email);
			 String birth = "";
	         for(int i=0 ; i<mb.getBirth().length ; i++) {
	        	 if(i==mb.getBirth().length-1){
	        		 birth+= mb.getBirth()[i]; 
	        	 }else{
	        		 birth+=mb.getBirth()[i]+"/";
	        	 }
	         }
			pstmt.setString(8, birth);
			String phone="";
			for(int i=0; i<mb.getPhone().length; i++){
				if(i==mb.getPhone().length-1){
					phone+=mb.getPhone()[i];
				}else{
					phone+=mb.getPhone()[i]+"-";
				}
			}
			pstmt.setString(9, phone);
			String field="";
			for(int i=0; i<mb.getField().length; i++){
				if(i==mb.getField().length-1){
					field+=mb.getField()[i];
				}else{
					field+=mb.getField()[i]+"-";
				}
			}
			pstmt.setString(10, field);
			String region="";
			for(int i=0; i<mb.getRegion().length; i++){
				if(i==mb.getRegion().length-1){
					region+=mb.getRegion()[i];
				}else{
					region+=mb.getRegion()[i]+"-";
				}
			}
			pstmt.setString(11, region);
			pstmt.setString(12, mb.getGender());
			pstmt.setString(13, mb.getAdmin_Id());
			pstmt.setString(14, mb.getImg());
			pstmt.setString(15, mb.getMbID());
			int result = pstmt.executeUpdate();
			return result;
		}finally {
			disconnect();
		}
	}
	public int remove(String mbId) throws SQLException{
		try {
			query = new StringBuffer();
			String sql = "DELETE FROM D_MEMBER WHERE member_id=? ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mbId);
			int result = pstmt.executeUpdate();			
			return result;
		}finally {
			disconnect();
		}
	}
	public Member findMember(String mbId) throws SQLException{
		try{
			Member mb = new Member();
			query = new StringBuffer();
			String sql = "SELECT * FROM D_MEMBER WHERE member_id=? ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mbId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				mb.setMbID(mbId);
				mb.setMbName(rs.getString("m_name"));
				mb.setAge(rs.getInt("age"));
				mb.setPwd(rs.getString("passwd"));
				mb.setJob(rs.getString("m_job"));
				mb.setAddress(rs.getString("address"));
				String[] email = rs.getString("email").split("@");
				mb.setEmail(email);
				String[] birth = rs.getString("birth").split("/");
				mb.setBirth(birth);
				String[] phone=rs.getString("phone").split("-");
				mb.setPhone(phone);
				String[] field=rs.getString("m_field").split("-");
				mb.setField(field);
				String[] region=rs.getString("region").split("-");
				mb.setRegion(region);
				mb.setGender(rs.getString("gender"));
				mb.setAdmin_Id(rs.getString("admin_id"));
				mb.setImg(rs.getString("img"));
			}
			
			return mb;
		}finally {
			disconnect();
		}
	}
	public List<Member> findMemberList() throws SQLException{
		try{
			List<Member> mblist = new ArrayList<Member>();
			query = new StringBuffer();
			String sql = "SELECT * FROM D_MEMBER ORDER BY member_id";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			rs.next();
			do{
				Member mb = new Member();
				mb.setMbID(rs.getString("member_id"));
				mb.setMbName(rs.getString("m_name"));
				mb.setAge(rs.getInt("age"));
				mb.setPwd(rs.getString("passwd"));
				mb.setJob(rs.getString("m_job"));
				mb.setAddress(rs.getString("address"));
				String[] email = rs.getString("email").split("@");
				mb.setEmail(email);
				String[] birth = rs.getString("birth").split("/");
				mb.setBirth(birth);
				String[] phone=rs.getString("phone").split("-");
				mb.setPhone(phone);
				String[] field=rs.getString("m_field").split("-");
				mb.setField(field);
				String[] region=rs.getString("region").split("-");
				mb.setRegion(region);
				mb.setGender(rs.getString("gender"));
				mb.setAdmin_Id(rs.getString("admin_id"));
				mb.setImg(rs.getString("img"));
				mblist.add(mb);
			}while(rs.next());
			
			return mblist;
		}finally {
			disconnect();
		}
	}

	public boolean existedMember(String mbId) throws SQLException{
		try{
			query = new StringBuffer();
			String sql = "SELECT count(*) FROM D_MEMBER WHERE member_id=? ";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, mbId);
			rs = pstmt.executeQuery();

			int count = 0;
			if ( rs.next() ){
				count = rs.getInt(1);
			}
			if ( count == 1 ) {
				return true;
			} else {
				return false;
			}
		}finally {
			disconnect();
		}
	}

	public List<Member> findUserList(int currentPage, int countPerPage) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT member_id, passwd, m_name, email ");
			findQuery.append("FROM USERINFO ORDER BY member_id");

			con = ds.getConnection();
			pstmt = con.prepareStatement(findQuery.toString(),
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY );

			rs = pstmt.executeQuery();

			int start = ((currentPage-1) * countPerPage) + 1;

			List<Member> userList = null;
			if ( (start >= 0) && rs.absolute(start) ) {
				userList = new ArrayList<Member>();

				do {
					Member user = new Member();
					user.setMbID(rs.getString("mbID"));
					user.setPwd(rs.getString("pwd"));
					user.setMbName(rs.getString("mbName"));
					// user.setEmail(rs.getString("email"));

					userList.add(user);					
				} while ( (rs.next()) && (--countPerPage > 0));				
			}
			return userList;
		} finally {
			if ( pstmt != null ){
				pstmt.close();
			}			
			if ( con != null ){
				con.close();
			}
		}
	}

	public List<Team> SearchPartnerList(Search search) throws SQLException {
		// TODO Auto-generated method stubearch search

		query = new StringBuffer();
		int age = search.getAge();
		String[] field = search.getField().split("-");
		String region = search.getRegion();
		String total = search.getTotal();
		List<Member> list = new ArrayList<Member>();
		List<Team> tlist = new ArrayList<Team>(); 
		List<Team> finalList = new ArrayList<Team>();
		try{
			StringBuffer query2 = new StringBuffer();
			String sql2 = "SELECT * FROM D_MEMBER ";
		
			if(total.equals("agefieldregion")) {
				if(age == 20) {
					sql2 += "WHERE age >= 20 AND age <= 29 ";
					}
					else if(age == 30) {
						sql2 += "WHERE age >= 30 AND age <= 39 ";	
					}
					else if(age == 40) {
						sql2 += "WHERE age >= 40 AND age <= 49 ";	
					}
					else if(age == 50) {
						sql2 += "WHERE age >= 50 AND age <= 59 ";	
					}
				
				sql2 += "AND region=? ";
			}

			
				query2.append(sql2);
				con = ds.getConnection();
				pstmt = con.prepareStatement(query2.toString());
				pstmt.setString(1, region);
				
				rs = pstmt.executeQuery();

				while(rs.next()) {
					Member mb = new Member();
					mb.setMbID(rs.getString("member_id"));
					mb.setMbName(rs.getString("m_name"));
					mb.setAge(rs.getInt("age"));
					mb.setPwd(rs.getString("passwd"));
					mb.setJob(rs.getString("m_job"));
					mb.setAddress(rs.getString("address"));
					String[] email = rs.getString("email").split("@");
					mb.setEmail(email);
					String[] birth = rs.getString("birth").split("/");
					mb.setBirth(birth);
					String[] phone=rs.getString("phone").split("-");
					mb.setPhone(phone);
					String[] field1=rs.getString("m_field").split("-");
					mb.setField(field1);
					String[] region1=rs.getString("region").split("-");
					mb.setRegion(region1);
					mb.setGender(rs.getString("gender"));
					mb.setAdmin_Id(rs.getString("admin_id"));
					mb.setImg(rs.getString("img"));
					list.add(mb);
				}
		}finally{
			disconnect();
		}
		try{
			String sql2 = "select * from TEAM where field=? ";
			query.append(sql2);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			for(int i=0;i<field.length;i++){
				pstmt.setString(1, field[i]);
				rs = pstmt.executeQuery();
				while(rs.next()){
					Team t = new Team();
					t.setTeam_id(rs.getString("team_id"));
					t.setMento_id(rs.getString("mento_id"));
					t.setNofp(rs.getInt("nofp"));
					t.setStart_date(rs.getString("start_date"));
					t.setRecruit(rs.getString("recruit"));
					t.setEnd_date(rs.getString("end_date"));
				    t.setTeam_name(rs.getString("team_name"));
				    t.setExtend(rs.getString("extend"));
				    t.setField(rs.getString("field"));
	                tlist.add(t);
				}
			}
				for(int i=0;i<list.size();i++){
					for(int j=0;j<tlist.size();j++){
						if(list.get(i).getMbID().equals(tlist.get(j).getMento_id())){
								finalList.add(tlist.get(j));
							
						}
					}
				}
				

				return finalList;
		}finally{
			disconnect();
		}
		}
	
	public List<Member> findTeamMemberList() throws SQLException {
		try {
			List<Member> mblist = new ArrayList<Member>();
			query = new StringBuffer();
			String sql = "SELECT * FROM D_MEMBER, TEAM_MEMBER "
					+ "WHERE D_MEMBER.MEMBER_ID = TEAM_MEMBER.MEMBER_ID ORDER BY member_id";
			query.append(sql);
			con = ds.getConnection();
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member mb = new Member();
				mb.setMbID(rs.getString("member_id"));
				mb.setMbName(rs.getString("m_name"));
				mb.setAge(rs.getInt("age"));
				mb.setPwd(rs.getString("passwd"));
				mb.setJob(rs.getString("m_job"));
				mb.setAddress(rs.getString("address"));
				String[] email = rs.getString("email").split("@");
				mb.setEmail(email);
				String[] birth = rs.getString("birth").split("/");
				mb.setBirth(birth);
				String[] phone=rs.getString("phone").split("-");
				mb.setPhone(phone);
				String[] field=rs.getString("m_field").split("-");
				mb.setField(field);
				String[] region=rs.getString("region").split("-");
				mb.setRegion(region);
				mb.setGender(rs.getString("gender"));
				mb.setAdmin_Id(rs.getString("admin_id"));
				mb.setImg(rs.getString("img"));
				mblist.add(mb);
			}
			return mblist;
		}
		finally {
			
		}
		
		
	}
}
