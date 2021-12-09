package challenge.act;

import javax.servlet.http.*;
import vo.*;
import java.util.*;

public class ChallengeInAct implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		forward.setPath("/page/challenge/chal_funding_in_form.jsp");
		
		return forward;
	}
}