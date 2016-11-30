package info.programese.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import info.programese.model.AreaComputacao;
import info.programese.model.AssuntoPedagogico;
import info.programese.model.FormaAbordagem;
import info.programese.model.ObjetoAprendizado;
import info.programese.model.Usuario;
import info.programese.persistance.JDBCConnection;
import info.programese.service.AreaComputacaoService;
import info.programese.service.AssuntoPedagogicoService;
import info.programese.service.FormaAbordagemService;
import info.programese.service.UsuarioService;

public class ObjetoAprendizadoDAO {

	public static Boolean cadastraNovoObjeto(ObjetoAprendizado objetoAprendizado) throws SQLException {

		String query = "INSERT INTO objeto_aprendizado (titulo, objetivo, quantidade_minima_pessoas, quantidade_maxima_pessoas,"+
		" feedback, referencias, descricao, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, objetoAprendizado.getTitulo());
			statement.setString(2, objetoAprendizado.getObjetivo());
			statement.setInt(3, objetoAprendizado.getQuantidadeMinimaPessoas());
			statement.setInt(4, objetoAprendizado.getQuantidadeMaximaPessoas());
			statement.setString(5, objetoAprendizado.getFeedback());
			statement.setString(6, objetoAprendizado.getReferencias());
			statement.setString(7, objetoAprendizado.getDescricao());
			statement.setInt(8, objetoAprendizado.getUsuarioCriador().getId());

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating objeto failed, no rows affected.");
			}
			//Pega a chave do Objeto Gerado para cadastrar o relacionamento na tabela
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					objetoAprendizado.setId(Integer.valueOf((int) generatedKeys.getLong(1)));

					for (AssuntoPedagogico assunto : objetoAprendizado.getAssuntosPedagogicos()) {
						cadastrarRelacionamentosObjetoAssuntoPedagogico(objetoAprendizado, assunto);
					}
					for (FormaAbordagem forma : objetoAprendizado.getFormasAbordagens()) {
						cadastrarRelacionamentosObjetoFormaAbordagem(objetoAprendizado, forma);
					}
					for (AreaComputacao area : objetoAprendizado.getAreasComputacao()) {
						cadastrarRelacionamentosObjetoAreaComputacao(objetoAprendizado, area);
					}
				} else {
					throw new SQLException("Creating objeto failed, no ID obtained.");
				}
			}
			return (affectedRows == 0 ? false : true);
		}
	}

	private static void cadastrarRelacionamentosObjetoFormaAbordagem(ObjetoAprendizado objetoAprendizado,
			FormaAbordagem forma) throws SQLException {
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String queryCadastroRelacionamentoObjetoForma = "INSERT INTO forma_abordagem_objeto_aprendizado(objeto_aprendizado_id, forma_abordagem_id) VALUES ("
				+ objetoAprendizado.getId() + ", " + forma.getId() + ");";
		sql.executeUpdate(queryCadastroRelacionamentoObjetoForma);
		conexao.close();
	}

	private static void cadastrarRelacionamentosObjetoAssuntoPedagogico(ObjetoAprendizado objetoAprendizado,
			AssuntoPedagogico assunto) throws SQLException {
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String queryCadastroRelacionamentoObjetoAbordagem = "INSERT INTO assunto_pedagogico_objeto_aprendizado(objeto_aprendizado_id, assunto_pedagogico_id) VALUES ("
				+ objetoAprendizado.getId() + ", " + assunto.getId() + ");";
		sql.executeUpdate(queryCadastroRelacionamentoObjetoAbordagem);
		conexao.close();
	}

	private static void cadastrarRelacionamentosObjetoAreaComputacao(ObjetoAprendizado objetoAprendizado,
			AreaComputacao area) throws SQLException {
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		String queryCadastroRelacionamentoObjetoArea = "INSERT INTO area_computacao_objeto_aprendizado(objeto_aprendizado_id, area_computacao_id) VALUES ("
				+ objetoAprendizado.getId() + ", " + area.getId() + ");";
		sql.executeUpdate(queryCadastroRelacionamentoObjetoArea);
		conexao.close();
	}

	public static List<ObjetoAprendizado> getTodosObjetos() throws SQLException {
		String query = "SELECT * FROM objeto_aprendizado";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<ObjetoAprendizado> objetos = new ArrayList<ObjetoAprendizado>();
		while (result.next()) {
			ObjetoAprendizado objeto = new ObjetoAprendizado();
			objeto.setId(result.getInt("objeto_aprendizado_id"));
			objeto.setTitulo(result.getString("titulo"));
			objeto.setDescricao(result.getString("descricao"));
			objeto.setFeedback(result.getString("feedback"));
			objeto.setObjetivo(result.getString("objetivo"));
			objeto.setQuantidadeMaximaPessoas(Integer.parseInt(result.getString("quantidade_maxima_pessoas")));
			objeto.setQuantidadeMinimaPessoas(Integer.parseInt(result.getString("quantidade_minima_pessoas")));
			objeto.setReferencias(result.getString("referencias"));
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(result.getString("usuario_id")));
			usuario.setNome(UsuarioService.getUsuarioById(usuario.getId()).getNome());
			objeto.setUsuarioCriador(usuario);
			
			objeto.setAreasComputacao(AreaComputacaoService.getAreasEmObjetoAprendizagem(objeto.getId()));
			
			objeto.setAssuntosPedagogicos(AssuntoPedagogicoService.getAssuntosEmObjetoAprendizagem(objeto.getId()));
			objeto.setFormasAbordagens(FormaAbordagemService.getFormasEmObjetoAprendizagem(objeto.getId()));
			

			objetos.add(objeto);
		}
		conexao.close();
		return objetos;
	}
}
