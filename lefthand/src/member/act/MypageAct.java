package member.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import vo.*;

public class MypageAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath("/page/member/mypage.jsp");

		return forward;
	}

}
