package Assignment15_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Handler
 */
@WebServlet("/Handler")
public class Handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Handler() {
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
		String count;
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("userName");
		HttpSession session=request.getSession();
		DateFormat df=new SimpleDateFormat("EEE MMM dd HH:mm:ss zyyyy");
		
		
		response.getWriter().append("<form action=\"Handler\">\r\n" + 
				"Name:<input type=\"text\" name=\"userName\"/><br>\r\n" + 
				"<input type=\"submit\" value=\"Create Session\"/>\r\n" + 
				"</form>\r\n" + 
				"<form action=\"Destroyer\">\r\n" + 
				"<input type=\"submit\" value=\"Invalidate\"/>\r\n" + 
				"\r\n" + 
				"</form>");
		out.append("<h1> Session Created</h1><br> Look at the OC4J Console to see whether HttpSessionEvent was invoked");
		count=(String) session.getAttribute("SessC");
		session.setAttribute("uname", n);
		if(count ==null) {
	    	session.setAttribute("SessC","0");
	    }
	    else {
	    	int ic=Integer.parseInt(count);
	    	session.setAttribute("SessC",Integer.toString(++ic));
	    }
		
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
