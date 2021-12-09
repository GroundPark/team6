package admin.act;

import javax.servlet.http.*;	// �̰ɷ� ������ �� �� ����
import java.io.*;
import admin.svc.AdminMemberStatSvc;
import vo.*;

public class AdminPeriodStatAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdminPeriodStatsInfo pstat = new AdminPeriodStatsInfo();
		// ȸ�� ���� ��迡 �ʿ��� �����͵��� ���� �� �ν��Ͻ�
		
		request.setCharacterEncoding("utf-8");

		
		AdminPeriodStatSvc periodStatsSvc = new AdminPeriodStatSvc();
		pstat = periodStatsSvc.getPriodStatsData();		
		
		request.setAttribute("pstat", pstat);
		// ������ �ν��Ͻ����� request��ü�� �Ӽ����� �����Ͽ� �̵��� �������� ������
		
		ActionForward forward = new ActionForward();
		forward.setPath("admin_priod_stats.jsp");	// ȸ���� ���� ����
		
		return forward;
	}
}
