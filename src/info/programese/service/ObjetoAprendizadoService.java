package info.programese.service;

import java.sql.SQLException;
import java.util.List;

import info.programese.dao.ObjetoAprendizadoDAO;
import info.programese.model.ObjetoAprendizado;

public class ObjetoAprendizadoService {

	public static List<ObjetoAprendizado> getTodosObjetos() {
		Boolean sucesso = null;
		try {
			return ObjetoAprendizadoDAO.getTodosObjetos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public static Boolean cadastraNovoObjeto(ObjetoAprendizado objetoAprendizado) {
		Boolean sucesso = null;
		try {
			sucesso = ObjetoAprendizadoDAO.cadastraNovoObjeto(objetoAprendizado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sucesso;		
	}

	public static ObjetoAprendizado getObjetoById(Integer idObjeto) {
		try {
			return ObjetoAprendizadoDAO.getObjetoById(idObjeto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

}
