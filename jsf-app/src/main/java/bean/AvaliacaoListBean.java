package bean;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dominio.Avaliacao;
import manager.AvaliacaoManager;

@ManagedBean @RequestScoped
public class AvaliacaoListBean {
	
	private ArrayList<Avaliacao> avaliacaoList;
	private AvaliacaoManager avaliacaoManager;
	private Avaliacao avaliacao;
	
	@PostConstruct
    public void init() {
		avaliacaoManager=new AvaliacaoManager();
		avaliacaoList=avaliacaoManager.listAll();
		avaliacao=new Avaliacao();
	}
	public String detalhar() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMapObj.put("avaliacao", avaliacao);
		return "/avaliacao.xhtml?faces-redirect=true";
	}

	public ArrayList<Avaliacao> getAvaliacaoList() {
		return avaliacaoList;
	}

	public void setAvaliacaoList(ArrayList<Avaliacao> avaliacaoList) {
		this.avaliacaoList = avaliacaoList;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
