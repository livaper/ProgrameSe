package info.programese.service;

import java.sql.SQLException;
import java.util.List;

import info.programese.dao.AssuntoPedagogicoDAO;
import info.programese.model.AssuntoPedagogico;

public class AssuntoPedagogicoService {

	public static List<AssuntoPedagogico> recuperarListaAssuntos() {
		try {
			return AssuntoPedagogicoDAO.getTodosAssuntosPedagogicos();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static AssuntoPedagogico getAssuntoById(int id) {
		try {
			return AssuntoPedagogicoDAO.getAssuntosPedagogicoById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<AssuntoPedagogico> getAssuntosEmObjetoAprendizagem(Integer idObjeto) {
		try {
			return AssuntoPedagogicoDAO.getAssuntosEmObjetoAprendizagem(idObjeto);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
