package info.programese.service;

import java.sql.SQLException;

import info.programese.dao.UsuarioDAO;
import info.programese.model.Usuario;

public class UsuarioService {

	public static Usuario getUsuarioByLogin(String login) {
		try {
			Usuario usuario =  UsuarioDAO.getUsuarioByLogin(login);
			if(usuario == null){				
				return null;
			}
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Usuario getUsuarioById(Integer id) {
		try {
			Usuario usuario =  UsuarioDAO.getUsuarioById(id);
			if(usuario == null){				
				return null;
			}
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Boolean cadastraUsuario(Usuario usuario) {
		try {
			Boolean loginExiste = UsuarioDAO.verificaExistenciaLogin(usuario.getLogin());
			if(!loginExiste ){				
				UsuarioDAO.cadastraUsuario(usuario);
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
