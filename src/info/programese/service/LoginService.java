package info.programese.service;

import java.sql.SQLException;

import info.programese.dao.UsuarioDAO;

public class LoginService {
	public static String autenticaUsuario(String login, String senha){
		
		try {
		
			String nome =  UsuarioDAO.autenticaUsuario(login, senha);
			if(nome == null){				
				return null;
			}
			return nome;

		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		
		}

	}

}
