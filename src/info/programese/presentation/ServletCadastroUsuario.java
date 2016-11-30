package info.programese.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.programese.model.Usuario;
import info.programese.service.UsuarioService;

@WebServlet("/ServletCadastroUsuario")
public class ServletCadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastroUsuario() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String tipo = request.getParameter("tipo");
		
		Usuario usuario = new Usuario(nome, email, login, senha, tipo.charAt(0), cidade, estado);
		
		Boolean cadastroSucesso = UsuarioService.cadastraUsuario(usuario);
		ServletContext context = getServletContext();

		if (cadastroSucesso) {
			RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
			request.setAttribute("loginExistente", false);
			rd.forward(request, response);

		}
		else {
			RequestDispatcher rd = context.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("loginExistente", true);
			rd.forward(request, response);

		}
	}
}
