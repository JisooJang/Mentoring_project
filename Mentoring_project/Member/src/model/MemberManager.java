package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Member;

public class MemberManager {
	private static MemberManager member = new MemberManager();
	private MemberDAO memberDAO;

	private MemberManager() {
		try {
			memberDAO = new MemberDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	public static MemberManager getInstance() {
		return member;
	}
	public int create(Member member) throws SQLException, ExistedMemberException{
		if(memberDAO.existedMember(member.getMbID())){
			throw new ExistedMemberException(member.getMbID()+"�� �����ϴ� ���̵��Դϴ�.");
		}
		return memberDAO.create(member);
	}
	public int update(Member member) throws SQLException{
		return memberDAO.update(member);
	}
	public int remove(String mbId) throws SQLException{
		return memberDAO.remove(mbId);
	}
	public Member findMember(String mbId) throws SQLException, MemberNotFoundException{
		Member mb = memberDAO.findMember(mbId);
		if(mb == null){
			throw new MemberNotFoundException(mbId+"�� �������� �ʴ� ���̵��Դϴ�.");
		}
		return mb;
	}
	public boolean existedMember(String mbId) throws SQLException{
		return memberDAO.existedMember(mbId);
	}
	public List<Member> findUserList(int currentPage, int countPerPage)
			throws SQLException {
		return memberDAO.findUserList(currentPage, countPerPage);
	} 

	public List<Member> findMemberList() throws SQLException{
		return memberDAO.findMemberList();
	} 

	public List<Team> SearchPartnerList(Search search) throws SQLException {
		return memberDAO.SearchPartnerList(search);
	}
	
	public List<Member> findTeamMemberList() throws SQLException{
		return memberDAO.findTeamMemberList();
	}
	public boolean login(String mbId, String password) throws SQLException, MemberNotFoundException, PasswordMismatchException{
		Member mb = findMember(mbId);

		if(existedMember(mbId)==false){
			throw new MemberNotFoundException("�������� �ʴ� ���̵�");
		}else if(!mb.getPwd().equals(password)){
			throw new PasswordMismatchException("��й�ȣ ����ġ");
		}
		return true;
	}

	public MemberDAO getMemberDAO(){
		return this.memberDAO;
	}

	public List<Member> RandomList(String mbId) throws SQLException, MemberNotFoundException{
		List<Member> mblist = findMemberList();
		List<Member> rdmblist = new ArrayList<Member>();
		List<Member> flist = new ArrayList<Member>();
		Member mb = findMember(mbId);
		Random rd = new Random();
		TeamManager manager = TeamManager.getInstance();
		
		for(int i=0;i<mblist.size();i++){
			if(manager.BelongToMento(mblist.get(i).getMbID()).size()!=0){
				flist.add(mblist.get(i));
			}
		}
		int randomi[] = new int[flist.size()];
		
		for(int j=0;j<randomi.length;j++){
			randomi[j] = rd.nextInt(flist.size());
			for(int x=0;x<j;x++){
				if(randomi[j]==randomi[x]){
					j--;
					break;
				}
			}
		}
		for(int j=0;j<randomi.length;j++){
			int count=0;
		    for(int x=0;x<mb.getField().length;x++){
		    	for(int z=0;z<flist.get(randomi[j]).getField().length;z++){
		    		if(mb.getField()[x].equals(flist.get(randomi[j]).getField()[z])){
		    			if(!mb.getMbID().equals(flist.get(randomi[j]).getMbID())){
		    				count++;
		    			}
		    		}
		    	}
		    }
		    if(count!=0){
		    	if(rdmblist.size()==3){
		    		break;
		    	}else{
		    		rdmblist.add(flist.get(randomi[j]));
		    	}
		    }
		}
		
		return rdmblist;
	}

	public String[] change_keyword(String[] keyword) {	//keyword�� 
		String[] change = null;
		char[] field = {'0', '1'};
		char[] region = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'};
		boolean isField = false;
		boolean isRegion = false;


		for(int i=0 ; i<field.length ; i++) {
			if(keyword[0].charAt(0) == field[i]) {
				isField = true;
			}
		}

		if(isField == false) {
			for(int j=0 ; j<region.length ; j++) {
				if(keyword[0].charAt(0) == region[j]) {
					isRegion = true;
				}
			}

		}



		if(isField == true) {
			change = new String[keyword.length];
			for(int i=0 ; i<keyword.length ; i++) {
				switch(keyword[i]) {
				case "01" :
					change[i] = "������";
					break;
				case "02" :
					change[i] = "IT/���α׷���";
					break;
				case "03" :
					change[i] = "�/������";
					break;
				case "04" :
					change[i] = "�ƿ�����/����";
					break;
				case "05" :
					change[i] = "���/�ܱ���";
					break;
				case "06" :
					change[i] = "����";
					break;
				case "07" :
					change[i] = "��Ƽ";
					break;
				case "08" :
					change[i] = "�ǰ�/����";
					break;
				case "09" :
					change[i] = "����/å";
					break;
				case "10" :
					change[i] = "����/�Ǳ�";
					break;
				case "11" :
					change[i] = "��";
					break;
				case "12" :
					change[i] = "����";
					break;
				case "13" :
					change[i] = "����/����";
					break;
				case "14" :
					change[i] = "�丮";
					break;
				case "15" :
					change[i] = "����/�ֽ�";
					break;

				}
			}
		}
		if(isRegion == true) {
			change = new String[keyword.length];
			for(int i=0 ; i<keyword.length ; i++) {
				switch(keyword[i]) {
				case "a1" :
					change[i] = "����-������";
					break;
				case "a2" :
					change[i] = "����-������";
					break;
				case "a3" :
					change[i] = "����-���ϱ�";
					break;
				case "a4" :
					change[i] = "����-������";
					break;

				case "b1" :
					change[i] = "���-����";
					break;
				case "b2" :
					change[i] = "���-�Ϻ�";
					break;
				case "b3" :
					change[i] = "���-����";
					break;


				case "c1" :
					change[i] = "��õ-���, ����";
					break;
				case "c2" :
					change[i] = "��õ-����, ����";
					break;
				case "c3" :
					change[i] = "��õ-������";
					break;
				case "c4" :
					change[i] = "��õ-����";
					break;
				case "c5" :
					change[i] = "��õ-������";
					break;
				case "c6" :
					change[i] = "��õ-�߱�, ��ȭ";
					break;


				case "d1" :
					change[i] = "����-����, ����";
					break;
				case "d2" :
					change[i] = "����-����, ��ô";
					break;
				case "d3" :
					change[i] = "����-����, �¹�";
					break;
				case "d4" :
					change[i] = "����-����, ��â";
					break;
				case "d5" :
					change[i] = "����-��õ, ȫõ";
					break;
				case "d6" :
					change[i] = "����-ȭõ, �籸";
					break;


				case "e1" :
					change[i] = "����-�����";
					break;
				case "e2" :
					change[i] = "����-����";
					break;
				case "e3" :
					change[i] = "����-����";
					break;
				case "e4" :
					change[i] = "����-������";
					break;
				case "e5" :
					change[i] = "����-�߱�, ������";
					break;


				case "f1" :
					change[i] = "����";
					break;


				case "g1" :
					change[i] = "�泲-���, �ݻ�, ���";
					break;
				case "g2" :
					change[i] = "�泲-����";
					break;
				case "g3" :
					change[i] = "�泲-����, ��õ";
					break;
				case "g4" :
					change[i] = "�泲-�ο�, ����";
					break;
				case "g5" :
					change[i] = "�泲-����, �¾�";
					break;
				case "g6" :
					change[i] = "�泲-õ��, �ƻ�";
					break;
				case "g7" :
					change[i] = "�泲-ȫ��, ����, û��";
					break;


				case "h1" :
					change[i] = "���-����, ����";
					break;
				case "h2" :
					change[i] = "���-�ܾ�, ��õ";
					break;
				case "h3" :
					change[i] = "���-����, ����, ��õ";
					break;
				case "h4" :
					change[i] = "���-��õ, ����";
					break;
				case "h5" :
					change[i] = "���-û��";
					break;
				case "h6" :
					change[i] = "���-����";
					break;


				case "i1" :
					change[i] = "�λ�-������";
					break;
				case "i2" :
					change[i] = "�λ�-�漺��, ����";
					break;
				case "i3" :
					change[i] = "�λ�-����, ����";
					break;
				case "i4" :
					change[i] = "�λ�-�λ��, ����";
					break;
				case "i5" :
					change[i] = "�λ�-���, �ϱ�";
					break;
				case "i6" :
					change[i] = "�λ�-����, ����";
					break;
				case "i7" :
					change[i] = "�λ�-����, ����";
					break;
				case "i8" :
					change[i] = "�λ�-����, ����";
					break;
				case "i9" :
					change[i] = "�λ�-�ؿ��, ����";
					break;


				case "j1" :
					change[i] = "���-����, ����";
					break;
				case "j2" :
					change[i] = "���-����";
					break;
				case "j3" :
					change[i] = "���-�ϱ�";
					break;
				case "j4" :
					change[i] = "���-�߱�, ���ֱ�";
					break;


				case "k1" :
					change[i] = "�泲-����, ����";
					break;
				case "k2" :
					change[i] = "�泲-�о�, ���";
					break;
				case "k3" :
					change[i] = "�泲-�Ƿ�, â��, �Ծ�";
					break;
				case "k4" :
					change[i] = "�泲-����, ��û";
					break;
				case "k5" :
					change[i] = "�泲-â��, ����, ����";
					break;
				case "k6" :
					change[i] = "�泲-�뿵, ����";
					break;
				case "k7" :
					change[i] = "�泲-�ϵ�, ����";
					break;
				case "k8" :
					change[i] = "�泲-��õ, ��â ��";
					break;


				case "l1" :
					change[i] = "���-���, û��";
					break;
				case "l2" :
					change[i] = "���-����, ���׳���";
					break;
				case "l3" :
					change[i] = "���-���, ����, ĥ��";
					break;
				case "l4" :
					change[i] = "���-��õ, ����";
					break;
				case "l5" :
					change[i] = "���-����, ��õ, ����";
					break;
				case "l6" :
					change[i] = "���-����";
					break;
				case "l7" :
					change[i] = "���-�ȵ�, �Ǽ�, û��";
					break;
				case "l8" :
					change[i] = "���-����, ���׺ϱ�";
					break;
				case "l9" :
					change[i] = "���-����, ����, ��ȭ";
					break;
				case "l10" :
					change[i] = "���-��õ, ����";
					break;


				case "m1" :
					change[i] = "�뱸-�޼���, ���� ";
					break;
				case "m2" :
					change[i] = "�뱸-�޼���";
					break;
				case "m3" :
					change[i] = "�뱸-����, �Ȱ�";
					break;
				case "m4" :
					change[i] = "�뱸-�ϱ�, ĥ��";
					break;
				case "m5" :
					change[i] = "�뱸-������";
					break;
				case "m6" :
					change[i] = "�뱸-�߱�, ����";
					break;


				case "n1" :
					change[i] = "����-���걸 ";
					break;
				case "n2" :
					change[i] = "����-����, ����";
					break;
				case "n3" :
					change[i] = "����-�ϱ�";
					break;
				case "n4" :
					change[i] = "����-���� ";
					break;


				case "o1" :
					change[i] = "����-�, ����";
					break;
				case "o2" :
					change[i] = "����-����, ����, ����";
					break;
				case "o3" :
					change[i] = "����-����, �ž�";
					break;
				case "o4" :
					change[i] = "����-����, ����, ȭ��";
					break;
				case "o5" :
					change[i] = "����-����, ��õ, ����";
					break;
				case "o6" :
					change[i] = "����-����, �强, ���";
					break;
				case "o7" :
					change[i] = "����-����, ����, ����";
					break;
				case "o8" :
					change[i] = "����-�س�, ����, �ϵ�";
					break;


				case "p1" :
					change[i] = "����-��â, �ξ�, ����";
					break;
				case "p2" :
					change[i] = "����-����, �ͻ�";
					break;
				case "p3" :
					change[i] = "����-����, ��â, �ӽ�";
					break;
				case "p4" :
					change[i] = "����-����, ���, ����";
					break;
				case "p5" :
					change[i] = "����-����, ����, ���� ";
					break;


				case "q1" :
					change[i] = "����-�������� ";
					break;
				case "q2" :
					change[i] = "����-���ֽ�";
					break;
				}
			}


		}

		return change;
	}
	public String change_keyword(String keyword) {
	      String change = null;

	      switch(keyword) {
	      case "01" :
	         change = "������";
	         break;
	      case "02" :
	         change = "IT/���α׷���";
	         break;
	      case "03" :
	         change = "�/������";
	         break;
	      case "04" :
	         change = "�ƿ�����/����";
	         break;
	      case "05" :
	         change = "���/�ܱ���";
	         break;
	      case "06" :
	         change = "����";
	         break;
	      case "07" :
	         change = "��Ƽ";
	         break;
	      case "08" :
	         change = "�ǰ�/����";
	         break;
	      case "09" :
	         change = "����/å";
	         break;
	      case "10" :
	         change = "����/�Ǳ�";
	         break;
	      case "11" :
	         change = "��";
	         break;
	      case "12" :
	         change = "����";
	         break;
	      case "13" :
	         change = "����/����";
	         break;
	      case "14" :
	         change = "�丮";
	         break;
	      case "15" :
	         change = "����/�ֽ�";
	         break;
	      }

	      return change;
	}
}
