package challenge.act;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import challenge.svc.*;
import vo.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.ServletContext;
import java.time.LocalDateTime;

public class ChallengeInProcAct implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		 ChallengeList challenge = new ChallengeList();
		// 사용자가 입력한 글의 정보들을 저장할 인스턴스 생성
		 
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo)session.getAttribute("memberInfo");
		
	
		String ourPath = "C:\\team6\\lefthand\\WebContent\\page\\challenge\\userimg";
		
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;	
		
		MultipartRequest multi = new MultipartRequest(request, ourPath, maxSize, encType, new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		
		String name = "", title = "", edate;	
		
		name = multi.getParameter("ci_title");
		title = multi.getParameter("ci_content");
		edate = multi.getParameter("edate");
		
		System.out.println(memberInfo.getMi_id() + " 유저가 도전펀딩 글을 등록함");
		
		challenge.setMi_id(memberInfo.getMi_id());
		
		challenge.setCi_title(name.trim().replace("'", "''"));
		challenge.setCi_content(title.trim().replace("'", "''"));
		challenge.setCi_edate(edate);
		challenge.setCi_img(image);
		challenge.setCi_thum_img(image);
		// form의 enctype를 "multipart/form-data'로 지정하면 request 객체로는 데이터를 받을 수 없고 반드시 업로드 객체를 통해서 받아야 함
		
		//challenge.setCi_title(request.getParameter("ci_title").trim().replace("'", "''"));
		//challenge.setCi_content(request.getParameter("ci_content").trim().replace("'", "''"));
		//challenge.setCi_edate(request.getParameter("edate"));
		//challenge.setCi_img(image);
		// 등록할 게시글 데이터를 받아와 challenge인스턴스에 담음(매개변수로 사용하기 편하기 때문)
		
		ChallengeInProcSvc challengeInProcSvc = new ChallengeInProcSvc();
		
		int result = challengeInProcSvc.challengeInsert(challenge);
		
		if (result == 0) {	// 글 등록에 실패했으면
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 등록에 실패했습니다.\n다시 시도해 주십시오');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);	// dispatch가 아닌 sendRedirect 방식으로 이동
		// forward.setPath("/page/challenge/chal_view.chal?cpage=1&ciidx=" + result);
		forward.setPath("/lefthand/chal_view.chal?cpage=1&ciidx=" + result);
		
		return forward;
	}
}