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

import info.programese.model.AssuntoPedagogico;
import info.programese.service.AssuntoPedagogicoService;

@WebServlet("/ServletRedirecionaCadastroObjeto")
public class ServletRedirecionaCadastroObjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRedirecionaCadastroObjeto() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginOperador = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nomeUsuario = request.getParameter("nomeUsuario");
		List<AssuntoPedagogico> assuntos = AssuntoPedagogicoService.recuperarListaAssuntos(); 
		
		ServletContext context = getServletContext();

		RequestDispatcher rd = context.getRequestDispatcher("/cadastroObjetoAprendizado.jsp");
		request.setAttribute("login", loginOperador);
		request.setAttribute("senha", senha);
		request.setAttribute("nomeUsuario", nomeUsuario);
		request.setAttribute("assuntos", assuntos);
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}