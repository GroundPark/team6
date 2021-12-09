package admin.act;

import javax.servlet.http.*;	// �̰ɷ� ������ �� �� ����
import java.io.*;
import admin.svc.AdminMemberStatSvc;
import vo.*;

public class AdminMemberStatAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdminMemStatsInfo mstat = new AdminMemStatsInfo();
		// ȸ�� ���� ��迡 �ʿ��� �����͵��� ���� �� �ν��Ͻ�
		
		request.setCharacterEncoding("utf-8");

		
		AdminMemberStatSvc memStatsSvc = new AdminMemberStatSvc();
		mstat = memStatsSvc.getMemStatsData();		
		
		request.setAttribute("mstat", mstat);
		// ������ �ν��Ͻ����� request��ü�� �Ӽ����� �����Ͽ� �̵��� �������� ������
		
		ActionForward forward = new ActionForward();
		forward.setPath("admin_member_stats.jsp");	// ȸ���� ���� ����
		
		return forward;
	}
}
