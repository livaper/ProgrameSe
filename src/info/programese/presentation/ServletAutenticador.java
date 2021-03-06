package info.programese.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.programese.model.ObjetoAprendizado;
import info.programese.service.LoginService;
import info.programese.service.ObjetoAprendizadoService;



@WebServlet("/ServletAutenticador")
public class ServletAutenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAutenticador() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nomeUsuario = LoginService.autenticaUsuario(login, senha);
		ServletContext context = getServletContext();

		if (nomeUsuario != null) {
			List<ObjetoAprendizado> objetos = ObjetoAprendizadoService.getTodosObjetos();

			RequestDispatcher rd = context.getRequestDispatcher("/sucesso.jsp");
			request.setAttribute("nomeUsuario", nomeUsuario);
			request.setAttribute("login", login);
			request.setAttribute("senha", senha);
			request.setAttribute("objetos", objetos);

			rd.forward(request, response);

		} else if (request.getParameter("cadastro").equals("true")) {
			RequestDispatcher rd = context.getRequestDispatcher("/cadastroUsuario.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
			request.setAttribute("loginInvalido", true);
			rd.forward(request, response);

		}
		// out.close();

	}
}