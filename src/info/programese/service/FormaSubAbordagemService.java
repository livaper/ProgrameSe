package info.programese.service;

import java.sql.SQLException;

import info.programese.dao.FormaSubAbordagemDAO;
import info.programese.model.FormaSubAbordagem;

public class FormaSubAbordagemService {

	public static FormaSubAbordagem getFormaSubAbordagemByIdEIdFormaAbordagemAssociada(int idFormaSubAbordagem, int idFormaAbordagem) {
		try {
			return FormaSubAbordagemDAO.getFormaSubAbordagemByIdEIdFormaAbordagemAssociada(idFormaSubAbordagem, idFormaAbordagem);
		} catch (SQLException e) {
			return null;
		}
	}

}
