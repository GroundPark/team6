package member.act;

import javax.servlet.http.*;
import member.vo.*;

public interface Action {
// ���� ��û�� ���� ó���� ������ ������� ó���ǰԲ� implement ��ų �������̽�
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// �� ��û�� ó���ϴ� Action Ŭ�������� ���������� �����ؾ� �ϴ� �޼ҵ�ν� ����� �޼ҵ�(public abstract)
}
