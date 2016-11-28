package info.programese.model;

import java.util.List;

public class FormaAbordagem {
	private int id;
	private String titulo;
	private List<FormaSubAbordagem> formasSubAbordagem;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<FormaSubAbordagem> getFormasSubAbordagem() {
		return formasSubAbordagem;
	}

	public void setFormasSubAbordagem(List<FormaSubAbordagem> formasSubAbordagem) {
		this.formasSubAbordagem = formasSubAbordagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
}
