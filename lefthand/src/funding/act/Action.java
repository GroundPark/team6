package funding.act;

import javax.servlet.http.*;
import funding.vo.*;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
