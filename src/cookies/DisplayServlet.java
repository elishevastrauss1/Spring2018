//elisheva strauss
package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String back=(String)session.getAttribute("back");
		String fore=(String)session.getAttribute("fore");
		
		synchronized(session) {
			String referer=request.getHeader("referer");
			
			if (referer!=null && referer.equals("http://localhost:8080/JaveEESchool/ChooseColor")) {
				back=request.getParameter("back");
				fore=request.getParameter("fore");
				session.setAttribute("back", back);
				session.setAttribute("fore", fore);
			}
			else if (back == null) {
				back="black";
				fore="yellow";
			}
			
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>\n" +
		           "<html lang='en'>\n" +
		           "<head><title>Display Servlet</title>");
		out.println("<body style='background-color:"+back+"'><h1 style=color:"+fore+">Display Servlet</h1>"
				+ "<p><a style=color:"+fore+" href=\"ChooseColor\">Click to choose your colors</a></p>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
