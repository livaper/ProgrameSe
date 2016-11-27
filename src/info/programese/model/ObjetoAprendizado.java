package info.programese.model;

import java.util.List;

public class ObjetoAprendizado {
	private Usuario usuarioCriador;
	private String titulo;
	private String objetivo;
	private int quantidadeMinimaPessoas;
	private int quantidadeMaximaPessoas;
	private String descricao;
	private String feedback;
	private String referencias;
	private List<AssuntoPedagogico> assuntosPedagogicos;
	private List<FormaAbordagem> formasAbordagens;
	private List<Comentario> comentarios;
	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}
	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public int getQuantidadeMinimaPessoas() {
		return quantidadeMinimaPessoas;
	}
	public void setQuantidadeMinimaPessoas(int quantidadeMinimaPessoas) {
		this.quantidadeMinimaPessoas = quantidadeMinimaPessoas;
	}
	public int getQuantidadeMaximaPessoas() {
		return quantidadeMaximaPessoas;
	}
	public void setQuantidadeMaximaPessoas(int quantidadeMaximaPessoas) {
		this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getReferencias() {
		return referencias;
	}
	public void setReferencias(String referencias) {
		this.referencias = referencias;
	}
	public List<AssuntoPedagogico> getAssuntosPedagogicos() {
		return assuntosPedagogicos;
	}
	public void setAssuntosPedagogicos(List<AssuntoPedagogico> assuntosPedagogicos) {
		this.assuntosPedagogicos = assuntosPedagogicos;
	}
	public List<FormaAbordagem> getFormasAbordagens() {
		return formasAbordagens;
	}
	public void setFormasAbordagens(List<FormaAbordagem> formasAbordagens) {
		this.formasAbordagens = formasAbordagens;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
}
