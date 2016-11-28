package info.programese.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import info.programese.model.FormaSubAbordagem;
import info.programese.persistance.JDBCConnection;

public class FormaSubAbordagemDAO {

	public static FormaSubAbordagem getFormaSubAbordagemByIdEIdFormaAbordagemAssociada(int idFormaSubAbordagem,
			int idFormaAbordagem) throws SQLException {
		String query = "SELECT * FROM forma_sub_abordagem where forma_abordagem_id = '" + idFormaAbordagem +"' AND forma_sub_abordagem_id = '"+ idFormaSubAbordagem + "';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet result = sql.executeQuery(query);

		List<FormaSubAbordagem> formasSubAbordagem = new ArrayList<FormaSubAbordagem>();
		
			while (result.next()) {
				FormaSubAbordagem forma = new FormaSubAbordagem();
				forma.setId(result.getInt("forma_sub_abordagem_id"));
				forma.setTitulo(result.getString("titulo"));
				formasSubAbordagem.add(forma);
			}
		conexao.close();
		return formasSubAbordagem.size() >0 ? formasSubAbordagem.get(0) : null;
	}

}
