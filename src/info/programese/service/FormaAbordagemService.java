package info.programese.service;

import java.sql.SQLException;
import java.util.List;

import info.programese.dao.FormaAbordagemDAO;
import info.programese.model.FormaAbordagem;

public class FormaAbordagemService {

	public static List<FormaAbordagem> recuperarListaFormas() {
		try {
			return FormaAbordagemDAO.getTodasFormasAbordagem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static FormaAbordagem getFormaAbordagemById(int id) {
		try {
			return FormaAbordagemDAO.getFormaAbordagemById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
