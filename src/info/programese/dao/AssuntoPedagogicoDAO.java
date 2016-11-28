package info.programese.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import info.programese.model.AssuntoPedagogico;
import info.programese.persistance.JDBCConnection;

public class AssuntoPedagogicoDAO {

	public static List<AssuntoPedagogico> getTodosAssuntosPedagogicos() throws SQLException {
		String query = "SELECT * FROM assunto_pedagogico";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<AssuntoPedagogico> assuntos = new ArrayList<AssuntoPedagogico>();
		while (result.next()) {
			AssuntoPedagogico assunto = new AssuntoPedagogico();
			assunto.setId(result.getInt("assunto_pedagogico_id"));
			assunto.setTitulo(result.getString("titulo"));

			assuntos.add(assunto);
		}

		conexao.close();
		return assuntos;
	}

	public static AssuntoPedagogico getAssuntosPedagogicoById(int id) throws SQLException {
		String query = "SELECT * FROM assunto_pedagogico WHERE assunto_pedagogico_id = " + id;
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<AssuntoPedagogico> assuntos = new ArrayList<AssuntoPedagogico>();
		while (result.next()) {
			AssuntoPedagogico assunto = new AssuntoPedagogico();
			assunto.setId(result.getInt("assunto_pedagogico_id"));
			assunto.setTitulo(result.getString("titulo"));
			assuntos.add(assunto);
		}

		conexao.close();
		return assuntos.get(0);
	}
}
