package info.programese.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import info.programese.model.Usuario;
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

	public static Usuario getUsuarioByLogin(String login) throws SQLException {
		
		String query = "SELECT * FROM usuario WHERE login = '" + login + "';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet usuarios = sql.executeQuery(query);
		Usuario usuario = new Usuario();
		while(usuarios.next()){
			usuario.setNome(usuarios.getString("nome"));
			usuario.setEmail(usuarios.getString("email"));
			usuario.setLogin(usuarios.getString("login"));
			usuario.setSenha(usuarios.getString("senha"));
			usuario.setCidade(usuarios.getString("Cidade"));
			usuario.setTipo(usuarios.getString("tipo").charAt(0));
			usuario.setEstado(usuarios.getString("estado"));
		}
		conexao.close();
		return usuario;	
		}
	
}
