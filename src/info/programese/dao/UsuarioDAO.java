package info.programese.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import info.programese.persistance.JDBCConnection;

public class UsuarioDAO {

	public static String autenticaUsuario(String login, String senha) throws SQLException {
		
		String query = "SELECT * FROM usuario WHERE login = '" + login + "' AND senha = '" + senha + "' ;";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet usuarios = sql.executeQuery(query); 
		String temp = null;
		while(usuarios.next()){
		
			temp = usuarios.getString("nome");
		
		}
		conexao.close();
		return temp;
	}
}
