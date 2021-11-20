package funding.act;

import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import funding.vo.*;
import funding.svc.*;
import java.util.*;

public class FundingListAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
        ActionForward forward = new ActionForward();
		forward.setPath("/page/funding/funding_list.jsp");
		
		return forward;
	}
}
