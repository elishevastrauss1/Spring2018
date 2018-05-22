package firstServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstServlet")
public class FirstServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(ServletUtilities.headWithTitle("First Servlet"));
		out.println("<body><table>");
		
		for(int rows=1;rows<=25;rows++) {
			out.println("<tr>");
			for(int columns=1;columns<=10;columns++) {
				out.println("<td>Row"+rows+", Col"+columns +"</td>");
			}
			out.println("</tr>");
		}
		out.println("</table></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	

}
