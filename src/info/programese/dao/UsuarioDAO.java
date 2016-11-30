package info.programese.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			usuario.setId(Integer.parseInt(usuarios.getString("usuario_id")));
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

	public static Usuario getUsuarioById(Integer id) throws SQLException {
		String query = "SELECT * FROM usuario WHERE usuario_id = '" + id + "';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet usuarios = sql.executeQuery(query);
		Usuario usuario = new Usuario();
		while(usuarios.next()){
			usuario.setId(Integer.parseInt(usuarios.getString("usuario_id")));
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

	public static Boolean verificaExistenciaLogin(String login) throws SQLException {
		String query = "SELECT COUNT (*) as quantidade FROM usuario WHERE login = '" + login + "';";
		Connection conexao = JDBCConnection.getConnection();
		Statement sql = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet quantidade = sql.executeQuery(query);
		int contagem = -1;
		while(quantidade.next()){
			contagem = quantidade.getInt("quantidade");
		}
		conexao.close();
		return contagem == 0 ? false : true;
	}

	public static void cadastraUsuario(Usuario usuario) throws SQLException {
		String query = "INSERT INTO usuario (nome, email, login, senha,"+
		" tipo, cidade, estado) VALUES (?, ?, ?, ?, ?, ?, ?);";

		try (Connection connection = JDBCConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getLogin());
			statement.setString(4, usuario.getSenha());
			statement.setString(5, String.valueOf(usuario.getTipo()));
			statement.setString(6,usuario.getCidade());
			statement.setString(7, usuario.getEstado());

			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating objeto failed, no rows affected.");
			}
	}
	}
}
