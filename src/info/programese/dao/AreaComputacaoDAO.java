package info.programese.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import info.programese.model.AreaComputacao;
import info.programese.persistance.JDBCConnection;

public class AreaComputacaoDAO {

	public static List<AreaComputacao> getTodasAreasComputacao() throws SQLException {
		String query = "SELECT * FROM area_computacao";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<AreaComputacao> areas = new ArrayList<AreaComputacao>();
		while (result.next()) {
			AreaComputacao area = new AreaComputacao();
			area.setId(result.getInt("area_computacao_id"));
			area.setTitulo(result.getString("titulo"));
			areas.add(area);
		}
		conexao.close();
		return areas;
	}

	public static AreaComputacao getAreaComputacaoById(int id) throws SQLException{
		String query = "SELECT * FROM area_computacao where area_computacao_id = '" + id +"';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<AreaComputacao> areas = new ArrayList<AreaComputacao>();
		while (result.next()) {
			AreaComputacao area = new AreaComputacao();
			area.setId(result.getInt("area_computacao_id"));
			area.setTitulo(result.getString("titulo"));

			areas.add(area);
		}
		conexao.close();
		return areas.get(0);
	}

	public static List<AreaComputacao> getAreasEmObjetoAprendizagem(Integer idObjeto) throws SQLException {
		String query = "SELECT * FROM area_computacao A , area_computacao_objeto_aprendizado O where O.objeto_aprendizado_id = +" +idObjeto 
				+ " AND A.area_computacao_id = O.area_computacao_id ;";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<AreaComputacao> areas = new ArrayList<AreaComputacao>();
		while (result.next()) {
			AreaComputacao area = new AreaComputacao();
			area.setId(result.getInt("area_computacao_id"));
			area.setTitulo(result.getString("titulo"));

			areas.add(area);
		}
		conexao.close();
		return areas;
	}

}
