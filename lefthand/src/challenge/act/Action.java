package challenge.act;
import javax.servlet.http.*;
import challenge.vo.*;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
