package emp.serv;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DateUtil;
import emp.dao.DeptDAO;
import emp.dao.DeptVO;
import emp.dao.EmpDAO;
import emp.dao.EmpVO;
import emp.dao.JobDAO;
import emp.dao.JobVO;

/**
 * Servlet implementation class EmpInsert
 */
public class EmpInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<JobVO> jobList = JobDAO.getInstance().selectList();
			ArrayList<DeptVO> deptList = DeptDAO.getInstance().selectList();
			request.setAttribute("jobList", jobList);
			request.setAttribute("deptList", deptList);
			request.getRequestDispatcher("/emp/empInsert.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//파라미터 VO담기 EmpVO에 builder해줘야함
//			String hire_date = request.getParameter("hire_date");
//			EmpVO empVO = EmpVO.builder().commission_pct(request.getParameter("commission_pct"))
//										 .department_id(request.getParameter("department_id"))
//										 .email(request.getParameter("email"))
//										 .employee_id(request.getParameter("employee_id"))
//										 .hire_date(DateUtil.toDate(hire_date))
//										 .job_id(request.getParameter("job_id"))
//										 .build();
//			EmpDAO.getInstance().insert(empVO);
//			request.getRequestDispatcher("EmpList").forward(request, response);
			response.sendRedirect("EmpList");
	}

}
