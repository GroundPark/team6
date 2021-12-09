package admin.act;

import javax.servlet.http.*;	// �̰ɷ� ������ �� �� ����
import java.util.*;
import java.io.*;				// PrintWriter �����
import admin.svc.*;
import vo.*;

public class AdminScheduleAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();					// ���� ����
		AdminInfo adminInfo = (AdminInfo)session.getAttribute("adminInfo");
		if (adminInfo == null) {
			response.setContentType("utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�α��� �� ����ϼ���.');");
			out.println("location.href='admin_login.jsp';");
			out.println("</script>");
			out.close();
		}
		
		int year, month, cYear, cMonth, cDay;
		Calendar sdate = Calendar.getInstance();			// ������
		cYear = sdate.get(Calendar.YEAR);					// ���� ����
		cMonth = sdate.get(Calendar.MONTH) + 1;				// ���� ��
		cDay = sdate.get(Calendar.DATE);					// ���� ��
		
		if (request.getParameter("y") == null) {			// �˻��� ������ ���� ������
			year = cYear;			month = cMonth;			// ���� ������ ���� �˻��ϰ� ��
			
		}else {														// �˻��� ������ ���� ������
			year = Integer.parseInt(request.getParameter("y"));		// ������ ������ year�� ����
			month = Integer.parseInt(request.getParameter("m"));	// ������ ���� month�� ����
		}
				
		ScheduleInfo si = new ScheduleInfo();				// ���� ������ �޷¿��� �ʿ��� �������� ���� �� �ν��Ͻ�
		si.setYear(year);			si.setMonth(month);			si.setcYear(cYear);
		si.setcMonth(cMonth);		si.setcDay(cDay);
		// �˻� ����, �˻� ��, ���� ����, ���� ��, ���� �� ���� si�ν��ͽ��� ����
		
		request.setAttribute("si", si);
		
		// �۾� �� �̵� �� ��ġ�� ����� ���� �����ϴ� ActionForward �ν��Ͻ� ����
		ActionForward forward = new ActionForward();
		forward.setPath("admin/schedule.jsp");	
		
		return forward;
	}
}
		// * sendRedirect ����� request ��ü�� �������� ����(dispatch�� request��ü�� �����ؼ� setAttribute�� ������)


