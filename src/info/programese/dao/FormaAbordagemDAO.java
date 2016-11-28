package info.programese.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import info.programese.model.FormaAbordagem;
import info.programese.model.FormaSubAbordagem;
import info.programese.persistance.JDBCConnection;

public class FormaAbordagemDAO {

	public static List<FormaAbordagem> getTodasFormasAbordagem() throws SQLException {
		String query = "SELECT * FROM forma_abordagem";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<FormaAbordagem> formas = new ArrayList<FormaAbordagem>();
		while (result.next()) {
			FormaAbordagem forma = new FormaAbordagem();
			forma.setId(result.getInt("forma_abordagem_id"));
			forma.setTitulo(result.getString("titulo"));

			formas.add(forma);
		}
		for(FormaAbordagem formaAbordagem : formas){
			formaAbordagem.setFormasSubAbordagem(getFormasSubAbordagem(formaAbordagem.getId()));
		}
		conexao.close();
		return formas;
	}

	public static FormaAbordagem getFormaAbordagemById(int id) throws SQLException{
		String query = "SELECT * FROM forma_abordagem where forma_abordagem_id = '" + id +"';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<FormaAbordagem> formas = new ArrayList<FormaAbordagem>();
		while (result.next()) {
			FormaAbordagem forma = new FormaAbordagem();
			forma.setId(result.getInt("forma_abordagem_id"));
			forma.setTitulo(result.getString("titulo"));

			formas.add(forma);
		}
		conexao.close();
		return formas.get(0);
	}


	private static List<FormaSubAbordagem> getFormasSubAbordagem(int id) throws SQLException{
		String query = "SELECT * FROM forma_sub_abordagem where forma_abordagem_id = '" + id +"';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);
		
		List<FormaSubAbordagem> formasSubAbordagem = new ArrayList<FormaSubAbordagem>();
		while (result.next()) {
			FormaSubAbordagem formaSubAbordagem = new FormaSubAbordagem();
			formaSubAbordagem.setId(result.getInt("forma_sub_abordagem_id"));
			formaSubAbordagem.setTitulo(result.getString("titulo"));
			formasSubAbordagem.add(formaSubAbordagem);
		}
		conexao.close();
		return formasSubAbordagem;
	}
}
