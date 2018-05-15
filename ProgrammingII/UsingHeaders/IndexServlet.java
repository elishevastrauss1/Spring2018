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

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(ServletUtilities.headWithTitle("Index"));
		out.println("<body><table class=\"title\">\r\n" + 
				"  <tr><th>This is the Index Page</th></tr>\r\n" + 
				"</table>\r\n" + 
				"<p>\r\n" + 
				"<fieldset>\r\n" + 
				"<legend>FirstServlet</legend>\r\n" + 
				"<ul>\r\n" + 
				"  <li><a href=\"firstServlet\">firstServlet</a> My first Servlet.</li>\r\n" + 
				"</ul>\r\n" + 
				"</fieldset>\r\n"+
				"<p>\r\n" + 
				"<fieldset>\r\n" + 
				"<legend>HTTP Request Headers</legend>\r\n" + 
				"<ul>\r\n" + 
				"  <li><a href=\"RefererServlet\">Referer Servlet</a> The referer servlet which can only be accessed from this page</li>\r\n" + 
				"</ul>\r\n" + 
				"</fieldset>\r\n" + 
				"<p>");
		out.println("</body></html>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
