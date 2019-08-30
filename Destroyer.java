package Assignment15_2;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Destroyer
 */
@WebServlet("/Destroyer")
public class Destroyer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destroyer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		HttpSession session=request.getSession();
		session.setAttribute("SessC", "0");
		response.setContentType("text/html");
		response.getWriter().append("<form action=\"Handler\">\r\n" + 
				"Enter Name:<input type=\"text\" name=\"userName\"/><br>\r\n" + 
				"<input type=\"submit\" value=\"Create Session\"/>\r\n" + 
				"</form>\r\n" + 
				"<form action=\"Destroyer\">\r\n" + 
				"<input type=\"submit\" value=\"Invalidate\"/>\r\n" + 
				"\r\n" + 
				"</form>");
		
		response.getWriter().append("<h3>Session Information</h3>");
		response.getWriter().append("Session new:"+session.isNew()+"<br>");
		response.getWriter().append("Session id: "+session.getId()+"<br>");
		response.getWriter().append("Session created: "+new java.util.Date(session.getCreationTime())+ "<br>");
		response.getWriter().append("Session access time: "+new java.util.Date(session.getLastAccessedTime())+"<br>");
		response.getWriter().append("Session user name: "+session.getAttribute("uname")+"<br>");
		response.getWriter().append("Number of accesses:"+session.getAttribute("SessC"));	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
