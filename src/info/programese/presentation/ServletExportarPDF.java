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

import info.programese.model.AreaComputacao;
import info.programese.model.AssuntoPedagogico;
import info.programese.model.FormaAbordagem;
import info.programese.model.ObjetoAprendizado;
import info.programese.model.Usuario;
import info.programese.service.AreaComputacaoService;
import info.programese.service.AssuntoPedagogicoService;
import info.programese.service.FormaAbordagemService;
import info.programese.service.LoginService;
import info.programese.service.ObjetoAprendizadoService;
import info.programese.service.UsuarioService;


@WebServlet("/ServletExportarPDF")
public class ServletExportarPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletExportarPDF() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cadastro = "false";
		String nomeUsuario = LoginService.autenticaUsuario(login, senha);
		

		ServletContext context = getServletContext();

		if (nomeUsuario != null) {
			
			request.setAttribute("nomeUsuario", nomeUsuario);
			request.setAttribute("login", login);
			request.setAttribute("senha", senha);
			request.setAttribute("cadastro", cadastro);
			
			Integer idObjeto = Integer.parseInt(request.getParameter("idObjeto"));
			Usuario usuario = UsuarioService.getUsuarioCriadorObjeto(idObjeto);
			List<AreaComputacao> areas = AreaComputacaoService.getAreasEmObjetoAprendizagem(idObjeto);
			List<AssuntoPedagogico> assuntos = AssuntoPedagogicoService.getAssuntosEmObjetoAprendizagem(idObjeto);
			List<FormaAbordagem> formas = FormaAbordagemService.getFormasEmObjetoAprendizagem(idObjeto);
			ObjetoAprendizado objeto = ObjetoAprendizadoService.getObjetoById(idObjeto);
			objeto.setFormasAbordagens(formas);
			objeto.setAssuntosPedagogicos(assuntos);
			objeto.setAreasComputacao(areas);
			objeto.setUsuarioCriador(usuario);
			
			GeradorTXTDetalhesObjeto.main(objeto);
			
			RequestDispatcher rd = context.getRequestDispatcher("/authentication");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = context.getRequestDispatcher("/detalhesObjeto.jsp");
			rd.forward(request, response);
		}
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