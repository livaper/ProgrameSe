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
import info.programese.service.AreaComputacaoService;
import info.programese.service.AssuntoPedagogicoService;
import info.programese.service.FormaAbordagemService;
import info.programese.service.LoginService;

@WebServlet("/ServletRedirecionaMaisDetalhesObjeto")
public class ServletRedirecionaMaisDetalhesObjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletRedirecionaMaisDetalhesObjeto() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nomeUsuario = LoginService.autenticaUsuario(login, senha);
		

		ServletContext context = getServletContext();

		if (nomeUsuario != null) {
			
			request.setAttribute("nomeUsuario", nomeUsuario);
			request.setAttribute("login", login);
			request.setAttribute("senha", senha);
			
			Integer idObjeto = Integer.parseInt(request.getParameter("idObjeto"));
			List<AreaComputacao> areas = AreaComputacaoService.getAreasEmObjetoAprendizagem(idObjeto);
			List<AssuntoPedagogico> assuntos = AssuntoPedagogicoService.getAssuntosEmObjetoAprendizagem(idObjeto);
			List<FormaAbordagem> formas = FormaAbordagemService.getFormasEmObjetoAprendizagem(idObjeto);
			
			String titulo =  request.getParameter("tituloObjeto");
			String objetivo = request.getParameter("objetivoObjeto");
			String minimo = request.getParameter("quantidadeMinimaObjeto");
			String maximo = request.getParameter("quantidadeMaximaObjeto");
			String descricao = request.getParameter("descricaoObjeto");
			String feedback = request.getParameter("feedbackObjeto");
			String referencias= request.getParameter("referenciasObjeto");
			
			request.setAttribute("idObjeto",idObjeto);
			request.setAttribute("tituloObjeto", titulo);
			request.setAttribute("objetivoObjeto", objetivo);
			request.setAttribute("areasObjeto", areas);
			request.setAttribute("assuntosObjeto", assuntos);
			request.setAttribute("formasObjeto", formas);
			request.setAttribute("quantidadeMinimaObjeto", minimo);
			request.setAttribute("quantidadeMaximaObjeto", maximo);
			request.setAttribute("descricaoObjeto", descricao);
			request.setAttribute("feedbackObjeto", feedback);
			request.setAttribute("referenciasObjeto", referencias);
			
			RequestDispatcher rd = context.getRequestDispatcher("/detalhesObjeto.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = context.getRequestDispatcher("/detalhesObjeto.jsp");
			request.setAttribute("loginInvalido", true);
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
