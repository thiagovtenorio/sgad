package bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import dominio.Avaliacao;
import manager.AutoAvaliacaoManager;
import manager.AvaliacaoManager;

@ManagedBean @ViewScoped
public class AutoAvaliacaoBean {
	private int idModeloAvaliacao;
	private AutoAvaliacaoManager autoAvaliacaoManager;
	private AvaliacaoManager avaliacaoManager;
	private Avaliacao autoAvaliacao;
	
	@SuppressWarnings("restriction")
	@PostConstruct
    public void init() {
		this.avaliacaoManager=new AvaliacaoManager();
		this.autoAvaliacaoManager=new AutoAvaliacaoManager();
		this.autoAvaliacao=new Avaliacao();
	}
	public void carregarAvaliacao() {
		this.autoAvaliacao=this.autoAvaliacaoManager.novaAvaliacao(this.autoAvaliacao.getIdModeloAvaliacao());
	}
	public void onModeloAvaliacaoChange() {
		carregarAvaliacao();
	}
	public void finalizar() {
		avaliacaoManager.finalizar(getAutoAvaliacao());
	}
	
	public int getIdModeloAvaliacao() {
		return idModeloAvaliacao;
	}

	public void setIdModeloAvaliacao(int idModeloAvaliacao) {
		this.idModeloAvaliacao = idModeloAvaliacao;
	}
	public Avaliacao getAutoAvaliacao() {
		return autoAvaliacao;
	}
	public void setAutoAvaliacao(Avaliacao autoAvaliacao) {
		this.autoAvaliacao = autoAvaliacao;
	}
	
}
