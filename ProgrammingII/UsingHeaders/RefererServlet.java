//Elisheva Strauss
package httpRequestHeaders;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import firstServlet.ServletUtilities;

@WebServlet("/RefererServlet")
public class RefererServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String referer=request.getHeader("referer");
		
		if (referer!=null && referer.equals("http://localhost:8080/JaveEESchool/IndexServlet")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(ServletUtilities.headWithTitle("YOU MADE IT!!!!"));
			out.println("<body><h1>Great Job!!!</h1></body>");
			out.println("</html>");
		}
		
		else {
			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", "http://localhost:8080/JaveEESchool/IndexServlet");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
