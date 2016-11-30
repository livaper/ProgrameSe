package info.programese.presentation;

import java.io.IOException;
import java.util.ArrayList;
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
import info.programese.service.ObjetoAprendizadoService;
import info.programese.service.UsuarioService;

@WebServlet("/ServletCadastraObjeto")
public class ServletCadastraObjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastraObjeto() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String loginUsuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nomeUsuario = request.getParameter("nomeUsuario");

		Usuario usuario = UsuarioService.getUsuarioByLogin(loginUsuario);
		
		//recupera forma abordagem uma a uma
		List<AssuntoPedagogico> assuntosObjeto = new ArrayList<AssuntoPedagogico>();
		String[] assuntoPedagogicoIds = request.getParameterValues("assuntoPedagogicoIds");
		if (assuntoPedagogicoIds != null && assuntoPedagogicoIds.length != 0) {
			for (int i = 0; i < assuntoPedagogicoIds.length; i++) {
				AssuntoPedagogico assunto = AssuntoPedagogicoService
						.getAssuntoById(Integer.parseInt(assuntoPedagogicoIds[i]));
				assuntosObjeto.add(assunto);
			}
		}

		// recupera forma abordagem uma a uma
		List<FormaAbordagem> formasAbordagens = new ArrayList<FormaAbordagem>();
		String[] formasAbordagensIds = request.getParameterValues("formaAbordagem");
		if (formasAbordagensIds != null && formasAbordagensIds.length != 0) {
			for (int i = 0; i < formasAbordagensIds.length; i++) {
				FormaAbordagem forma = FormaAbordagemService
						.getFormaAbordagemById(Integer.parseInt(formasAbordagensIds[i]));
				formasAbordagens.add(forma);
			}
		}
		
		// recupera area computação uma a uma
		List<AreaComputacao> areasComputacao = new ArrayList<AreaComputacao>();
		String[] areaComputacaoIds = request.getParameterValues("areaComputacao");
		if (areaComputacaoIds != null && areaComputacaoIds.length != 0) {
			for (int i = 0; i < areaComputacaoIds.length; i++) {
				AreaComputacao area= AreaComputacaoService
						.getAreaComputacaoById(Integer.parseInt(areaComputacaoIds[i]));
				areasComputacao.add(area);
			}
		}
		String titulo = request.getParameter("titulo");
		String objetivo = request.getParameter("objetivo");
		String quantidadeMinimaPessoas = request.getParameter("quantidadeMinimaPessoas");
		String quantidadeMaximaPessoas = request.getParameter("quantidadeMaximaPessoas");
		String descricao = (request.getParameter("descricao"));
		String feedback = request.getParameter("feedback");
		String referencias = request.getParameter("referencias");

		ObjetoAprendizado objetoAprendizado = new ObjetoAprendizado();
		objetoAprendizado.setUsuarioCriador(usuario);
		objetoAprendizado.setTitulo(titulo);
		objetoAprendizado.setAssuntosPedagogicos(assuntosObjeto);
		objetoAprendizado.setFormasAbordagens(formasAbordagens);
		objetoAprendizado.setAreasComputacao(areasComputacao);
		objetoAprendizado.setObjetivo(objetivo);
		objetoAprendizado.setQuantidadeMinimaPessoas(Integer.parseInt(quantidadeMinimaPessoas));
		objetoAprendizado.setQuantidadeMaximaPessoas(Integer.parseInt(quantidadeMaximaPessoas));
		objetoAprendizado.setDescricao(descricao);
		objetoAprendizado.setFeedback(feedback);
		objetoAprendizado.setReferencias(referencias);
		
		Boolean sucesso = ObjetoAprendizadoService.cadastraNovoObjeto(objetoAprendizado);
		if(sucesso) {
			request.setAttribute("entradaSucesso", true);
		}
		else {
			request.setAttribute("entradaSucesso", false);
		}

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/sucesso.jsp");
		request.setAttribute("login", loginUsuario);
		request.setAttribute("senha", senha);
		request.setAttribute("nomeUsuario", nomeUsuario);
		request.setAttribute("inclusao", true);

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
