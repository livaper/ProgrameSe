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

}
