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

import info.programese.model.AssuntoPedagogico;
import info.programese.model.FormaAbordagem;
import info.programese.model.FormaSubAbordagem;
import info.programese.model.ObjetoAprendizado;
import info.programese.model.Usuario;
import info.programese.service.AssuntoPedagogicoService;
import info.programese.service.FormaAbordagemService;
import info.programese.service.FormaSubAbordagemService;
import info.programese.service.UsuarioService;

@WebServlet("/ServletCadastraObjeto")
public class ServletCadastraObjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCadastraObjeto() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginUsuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nomeUsuario = request.getParameter("nomeUsuario");

		Usuario usuario = UsuarioService.getUsuarioByLogin(loginUsuario);

		String titulo = request.getParameter("titulo");

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
		String[] formasSubAbordagemIds = request.getParameterValues("formaSubAbordagem");
		if (formasAbordagensIds != null && formasAbordagensIds.length != 0) {
			for (int i = 0; i < formasAbordagensIds.length; i++) {
				FormaAbordagem forma = FormaAbordagemService
						.getFormaAbordagemById(Integer.parseInt(formasAbordagensIds[i]));

				if (formasSubAbordagemIds != null && formasSubAbordagemIds.length != 0) {
					for (int j = 0; j < formasSubAbordagemIds.length; j++) {
						FormaSubAbordagem formaSubAbordagem = FormaSubAbordagemService
								.getFormaSubAbordagemByIdEIdFormaAbordagemAssociada(
										Integer.parseInt(formasSubAbordagemIds[j]), forma.getId());
						if (formaSubAbordagem != null) {
							forma.setFormasSubAbordagem(new ArrayList<FormaSubAbordagem>());
							forma.getFormasSubAbordagem().add(formaSubAbordagem);
						}
					}
				}
				formasAbordagens.add(forma);
			}
		}

		String objetivo = request.getParameter("objetivo");
		String quantidadeMinimaPessoas = request.getParameter("quantidadeMinimaPessoas");
		String quantidadeMaximaPessoas = request.getParameter("quantidadeMaximaPessoas");
		String descricao = request.getParameter("descricao");
		String feedback = request.getParameter("feedback");
		String referencias = request.getParameter("referencias");

		ObjetoAprendizado objetoAprendizado = new ObjetoAprendizado();
		objetoAprendizado.setUsuarioCriador(usuario);
		objetoAprendizado.setTitulo(titulo);
		objetoAprendizado.setAssuntosPedagogicos(assuntosObjeto);
		objetoAprendizado.setObjetivo(objetivo);
		objetoAprendizado.setQuantidadeMinimaPessoas(Integer.parseInt(quantidadeMinimaPessoas));
		objetoAprendizado.setQuantidadeMaximaPessoas(Integer.parseInt(quantidadeMaximaPessoas));
		objetoAprendizado.setDescricao(descricao);
		objetoAprendizado.setFeedback(feedback);
		objetoAprendizado.setReferencias(referencias);
		// ObjetoAprendizadoService.cadastraNovoObjeto(objetoAprendizado);

		ServletContext context = getServletContext();

		RequestDispatcher rd = context.getRequestDispatcher("/cadastroObjetoAprendizado.jsp");
		request.setAttribute("login", loginUsuario);
		request.setAttribute("senha", senha);
		request.setAttribute("nomeUsuario", nomeUsuario);

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
