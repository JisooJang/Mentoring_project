package controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Team;
import model.MemberManager;
import model.Search;

public class SearchPartnerAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		Search search = new Search();
		
		HttpSession session = request.getSession();
		String[] field = (String[])session.getAttribute("field");
		String[] region = request.getParameterValues("region");
		int age = Integer.parseInt(session.getAttribute("age").toString());
		String fs = "";
		String rs = "";
		String total = "";
		
		if(age != 1) {
			total += "age";
			search.setAge(age);
	
		}
		if(field != null) {
			total += "field";
			for(int i=0 ; i<field.length ; i++) {
				if(i == field.length-1) {
					fs += field[i];
					break;
				}
				 fs += field[i] + "-";
			}
			
			search.setField(fs);
		}
		if(region != null) {
			total += "region";
			for(int i=0 ; i<region.length ; i++) {
				if(i == region.length-1) {
					rs += region[i];
					break;
				}
				 rs += region[i] + "-";
			}
			
			search.setRegion(rs);
		}
		
		
		
		search.setTotal(total);
		
		MemberManager manager = MemberManager.getInstance();
		List<Team> list = manager.SearchPartnerList(search);
		List<String> img=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			img.add(manager.findMember(list.get(i).getMento_id()).getImg());
		}
		request.setAttribute("img", img);
		request.setAttribute("searchList", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("SearchList.jsp");
		
		session.removeAttribute("field");
		session.removeAttribute("age");
				
		return forward;
	}

}
