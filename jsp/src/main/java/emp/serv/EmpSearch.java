package emp.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDAO;
import emp.dao.EmpVO;

/**
 * Servlet implementation class EmpList
 */
public class EmpSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<EmpVO> list = EmpDAO.getInstance().selectList();
		//EmpVO list = EmpDAO.getInstance().selectOneByManagerId(request.getParameter("manager_id"));
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/empSearch.jsp").forward(request, response);
	}

}
