package info.programese.service;

import java.sql.SQLException;
import java.util.List;

import info.programese.dao.AreaComputacaoDAO;
import info.programese.model.AreaComputacao;

public class AreaComputacaoService {

	public static List<AreaComputacao> getTodasAreasComputacao() {
		try {
			return AreaComputacaoDAO.getTodasAreasComputacao();
		} catch (SQLException e) {
			return null;
		}
	}

	public static AreaComputacao getAreaComputacaoById(int id) {
		try {
			return AreaComputacaoDAO.getAreaComputacaoById(id);
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<AreaComputacao> getAreasEmObjetoAprendizagem(Integer idObjeto) {
		try {
			return AreaComputacaoDAO.getAreasEmObjetoAprendizagem(idObjeto);
		} catch (SQLException e) {
			return null;
		}
	}
}
