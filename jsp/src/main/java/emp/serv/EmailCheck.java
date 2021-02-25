package emp.serv;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import emp.dao.EmpDAO;
import emp.dao.EmpVO;

public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpVO empVO=EmpDAO.getInstance().selectOneByEmail(request.getParameter("email"));
		
		/* gson으로 출력
		response.setCharacterEncoding("text/html; charset=UTF-8");
		Gson gson = new Gson();
		HashMap<String, Object> map = new HashMap<>();
		if(empVO == null) {
			map.put("email", true);
			response.getWriter().print(gson.toJson(map));
		}else {
			map.put("email", false);
			map.put("emp", empVO);
			response.getWriter().print(gson.toJson(map));
		}
		 * */
		
		/*xml으로 출력*/
		response.setCharacterEncoding("text/xml; charset=UTF-8");
		if(empVO == null) {
			response.getWriter().append("<email>")
								.append("true")
								.append("</email>");
		}else {
			response.getWriter().append("<email>")
								.append("false")
								.append("</email>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
