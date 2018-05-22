//elisheva strauss
package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ChooseColor")
public class ChooseColor extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\n" +
		           "<html lang='en'>\n" +
		           "<head><title>Choose Color</title>\r\n" +
		           "");
		out.println("<body><h1>Choose Your Color</h1>"
				+ "<form action='/JaveEESchool/DisplayServlet'>"
				+ "<p>Background Color</p>"
				+ "<input type='text' name='back'/>"
				+ "<p>Foreground Color</p>"
				+ "<input type='text' name='fore'/>"
				+ "<p></p>"
				+ "<input type='submit' value='Submit Colors' />"
				+ "</form>");
		out.println("</body></html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
