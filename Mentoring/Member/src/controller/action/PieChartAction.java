package controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.pieChartDAO;
import model.pieChartData;

public class PieChartAction implements Action{
	public ActionForward execute(
			HttpServletRequest request,	HttpServletResponse response)
			throws Exception{
		pieChartDAO pdao = new pieChartDAO();
        List<pieChartData> pieDataList = null;
		try {
			pieDataList = pdao.getPieDataList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //System.out.println(pieDataList.get(0).getValue());
        request.setAttribute("pieDataList", pieDataList);
        ActionForward forward = new ActionForward();
        forward.setPath("/pServlet.jsp");
		forward.setRedirect(false);
				
		return forward;
	}
}
