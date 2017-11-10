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
			throw new ExistedMemberException(member.getMbID()+"는 존재하는 아이디입니다.");
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
			throw new MemberNotFoundException(mbId+"는 존재하지 않는 아이디입니다.");
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
			throw new MemberNotFoundException("존재하지 않는 아이디");
		}else if(!mb.getPwd().equals(password)){
			throw new PasswordMismatchException("비밀번호 불일치");
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

	public String[] change_keyword(String[] keyword) {	//keyword는 
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
					change[i] = "디자인";
					break;
				case "02" :
					change[i] = "IT/프로그래밍";
					break;
				case "03" :
					change[i] = "운동/스포츠";
					break;
				case "04" :
					change[i] = "아웃도어/여행";
					break;
				case "05" :
					change[i] = "언어/외국어";
					break;
				case "06" :
					change[i] = "봉사";
					break;
				case "07" :
					change[i] = "뷰티";
					break;
				case "08" :
					change[i] = "건강/의학";
					break;
				case "09" :
					change[i] = "문학/책";
					break;
				case "10" :
					change[i] = "음악/악기";
					break;
				case "11" :
					change[i] = "댄스";
					break;
				case "12" :
					change[i] = "사진";
					break;
				case "13" :
					change[i] = "게임/오락";
					break;
				case "14" :
					change[i] = "요리";
					break;
				case "15" :
					change[i] = "경제/주식";
					break;

				}
			}
		}
		if(isRegion == true) {
			change = new String[keyword.length];
			for(int i=0 ; i<keyword.length ; i++) {
				switch(keyword[i]) {
				case "a1" :
					change[i] = "서울-강남구";
					break;
				case "a2" :
					change[i] = "서울-강동구";
					break;
				case "a3" :
					change[i] = "서울-강북구";
					break;
				case "a4" :
					change[i] = "서울-강서구";
					break;

				case "b1" :
					change[i] = "경기-남부";
					break;
				case "b2" :
					change[i] = "경기-북부";
					break;
				case "b3" :
					change[i] = "경기-서부";
					break;


				case "c1" :
					change[i] = "인천-계양, 서구";
					break;
				case "c2" :
					change[i] = "인천-남구, 동구";
					break;
				case "c3" :
					change[i] = "인천-남동구";
					break;
				case "c4" :
					change[i] = "인천-부평";
					break;
				case "c5" :
					change[i] = "인천-연수구";
					break;
				case "c6" :
					change[i] = "인천-중구, 강화";
					break;


				case "d1" :
					change[i] = "강원-강릉, 속초";
					break;
				case "d2" :
					change[i] = "강원-동해, 삼척";
					break;
				case "d3" :
					change[i] = "강원-영월, 태백";
					break;
				case "d4" :
					change[i] = "강원-원주, 평창";
					break;
				case "d5" :
					change[i] = "강원-춘천, 홍천";
					break;
				case "d6" :
					change[i] = "강원-화천, 양구";
					break;


				case "e1" :
					change[i] = "대전-대덕구";
					break;
				case "e2" :
					change[i] = "대전-동구";
					break;
				case "e3" :
					change[i] = "대전-서구";
					break;
				case "e4" :
					change[i] = "대전-유성구";
					break;
				case "e5" :
					change[i] = "대전-중구, 서대전";
					break;


				case "f1" :
					change[i] = "세종";
					break;


				case "g1" :
					change[i] = "충남-논산, 금산, 계룡";
					break;
				case "g2" :
					change[i] = "충남-당진";
					break;
				case "g3" :
					change[i] = "충남-보령, 서천";
					break;
				case "g4" :
					change[i] = "충남-부여, 공주";
					break;
				case "g5" :
					change[i] = "충남-서산, 태안";
					break;
				case "g6" :
					change[i] = "충남-천안, 아산";
					break;
				case "g7" :
					change[i] = "충남-홍성, 예산, 청양";
					break;


				case "h1" :
					change[i] = "충북-괴산, 증평";
					break;
				case "h2" :
					change[i] = "충북-단양, 제천";
					break;
				case "h3" :
					change[i] = "충북-보은, 영동, 옥천";
					break;
				case "h4" :
					change[i] = "충북-진천, 음성";
					break;
				case "h5" :
					change[i] = "충북-청주";
					break;
				case "h6" :
					change[i] = "충북-충주";
					break;


				case "i1" :
					change[i] = "부산-강서구";
					break;
				case "i2" :
					change[i] = "부산-경성대, 광안";
					break;
				case "i3" :
					change[i] = "부산-남포, 영도";
					break;
				case "i4" :
					change[i] = "부산-부산대, 동래";
					break;
				case "i5" :
					change[i] = "부산-사상, 북구";
					break;
				case "i6" :
					change[i] = "부산-서구, 사하";
					break;
				case "i7" :
					change[i] = "부산-서면, 동구";
					break;
				case "i8" :
					change[i] = "부산-연산, 거제";
					break;
				case "i9" :
					change[i] = "부산-해운대, 기장";
					break;


				case "j1" :
					change[i] = "울산-남구, 울산대";
					break;
				case "j2" :
					change[i] = "울산-동구";
					break;
				case "j3" :
					change[i] = "울산-북구";
					break;
				case "j4" :
					change[i] = "울산-중구, 울주군";
					break;


				case "k1" :
					change[i] = "경남-김해, 장유";
					break;
				case "k2" :
					change[i] = "경남-밀양, 양산";
					break;
				case "k3" :
					change[i] = "경남-의령, 창녕, 함안";
					break;
				case "k4" :
					change[i] = "경남-진주, 사청";
					break;
				case "k5" :
					change[i] = "경남-창원, 마산, 진해";
					break;
				case "k6" :
					change[i] = "경남-통영, 거제";
					break;
				case "k7" :
					change[i] = "경남-하동, 남해";
					break;
				case "k8" :
					change[i] = "경남-합천, 거창 외";
					break;


				case "l1" :
					change[i] = "경북-경산, 청도";
					break;
				case "l2" :
					change[i] = "경북-경주, 포항남구";
					break;
				case "l3" :
					change[i] = "경북-고령, 성주, 칠곡";
					break;
				case "l4" :
					change[i] = "경북-김천, 구미";
					break;
				case "l5" :
					change[i] = "경북-문경, 예천, 영주";
					break;
				case "l6" :
					change[i] = "경북-상주";
					break;
				case "l7" :
					change[i] = "경북-안동, 의성, 청송";
					break;
				case "l8" :
					change[i] = "경북-영덕, 포항북구";
					break;
				case "l9" :
					change[i] = "경북-영양, 울진, 봉화";
					break;
				case "l10" :
					change[i] = "경북-영천, 군위";
					break;


				case "m1" :
					change[i] = "대구-달서구, 서구 ";
					break;
				case "m2" :
					change[i] = "대구-달성군";
					break;
				case "m3" :
					change[i] = "대구-동구, 팔공";
					break;
				case "m4" :
					change[i] = "대구-북구, 칠곡";
					break;
				case "m5" :
					change[i] = "대구-수성구";
					break;
				case "m6" :
					change[i] = "대구-중구, 남구";
					break;


				case "n1" :
					change[i] = "광주-광산구 ";
					break;
				case "n2" :
					change[i] = "광주-남구, 동구";
					break;
				case "n3" :
					change[i] = "광주-북구";
					break;
				case "n4" :
					change[i] = "광주-서구 ";
					break;


				case "o1" :
					change[i] = "전남-곡성, 구례";
					break;
				case "o2" :
					change[i] = "전남-나주, 함평, 무안";
					break;
				case "o3" :
					change[i] = "전남-목포, 신안";
					break;
				case "o4" :
					change[i] = "전남-보성, 고흥, 화순";
					break;
				case "o5" :
					change[i] = "전남-여수, 순천, 광양";
					break;
				case "o6" :
					change[i] = "전남-영광, 장성, 담양";
					break;
				case "o7" :
					change[i] = "전남-영암, 강진, 장흥";
					break;
				case "o8" :
					change[i] = "전남-해남, 진도, 완도";
					break;


				case "p1" :
					change[i] = "전북-고창, 부안, 정읍";
					break;
				case "p2" :
					change[i] = "전북-군산, 익산";
					break;
				case "p3" :
					change[i] = "전북-남원, 순창, 임실";
					break;
				case "p4" :
					change[i] = "전북-무주, 장수, 진안";
					break;
				case "p5" :
					change[i] = "전북-전주, 완주, 김제 ";
					break;


				case "q1" :
					change[i] = "제주-서귀포시 ";
					break;
				case "q2" :
					change[i] = "제주-제주시";
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
	         change = "디자인";
	         break;
	      case "02" :
	         change = "IT/프로그래밍";
	         break;
	      case "03" :
	         change = "운동/스포츠";
	         break;
	      case "04" :
	         change = "아웃도어/여행";
	         break;
	      case "05" :
	         change = "언어/외국어";
	         break;
	      case "06" :
	         change = "봉사";
	         break;
	      case "07" :
	         change = "뷰티";
	         break;
	      case "08" :
	         change = "건강/의학";
	         break;
	      case "09" :
	         change = "문학/책";
	         break;
	      case "10" :
	         change = "음악/악기";
	         break;
	      case "11" :
	         change = "댄스";
	         break;
	      case "12" :
	         change = "사진";
	         break;
	      case "13" :
	         change = "게임/오락";
	         break;
	      case "14" :
	         change = "요리";
	         break;
	      case "15" :
	         change = "경제/주식";
	         break;
	      }

	      return change;
	}
}
