package emp.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dao.EmpVO;

public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpVO empVO=EmpDAO.getInstance().selectOneByEmail(request.getParameter("email"));
		response.setCharacterEncoding("utf-8");
		if(empVO == null) {
			response.getWriter().print("사용가능한 이메일");
		}else {
			response.getWriter().print("사용불가");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
