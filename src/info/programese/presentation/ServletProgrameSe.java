package info.programese.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletProgrameSe")
public class ServletProgrameSe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletProgrameSe() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}
}