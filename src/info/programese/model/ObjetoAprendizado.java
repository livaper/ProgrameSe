package info.programese.model;

import java.util.List;

public class ObjetoAprendizado {
	private Integer id;
	private Usuario usuarioCriador;
	private String titulo;
	private String objetivo;
	private Integer quantidadeMinimaPessoas;
	private Integer quantidadeMaximaPessoas;
	private String descricao;
	private String feedback;
	private String referencias;
	private List<AssuntoPedagogico> assuntosPedagogicos;
	private List<AreaComputacao> areasComputacao;
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
	public Integer getQuantidadeMinimaPessoas() {
		return quantidadeMinimaPessoas;
	}
	public void setQuantidadeMinimaPessoas(Integer quantidadeMinimaPessoas) {
		this.quantidadeMinimaPessoas = quantidadeMinimaPessoas;
	}
	public Integer getQuantidadeMaximaPessoas() {
		return quantidadeMaximaPessoas;
	}
	public void setQuantidadeMaximaPessoas(Integer quantidadeMaximaPessoas) {
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<AreaComputacao> getAreasComputacao() {
		return areasComputacao;
	}
	public void setAreasComputacao(List<AreaComputacao> areasComputacao) {
		this.areasComputacao = areasComputacao;
	}
	
}
