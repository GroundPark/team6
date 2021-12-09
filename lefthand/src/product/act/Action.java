package product.act;

import javax.servlet.http.*;
import vo.*;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
