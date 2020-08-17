package bean;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.CompetenciaDAO;
import dominio.Avaliacao;
import dominio.Competencia;
import manager.AvaliacaoManager;

@ManagedBean @ViewScoped
public class AvaliacaoBean{
	
	
	private AvaliacaoManager avaliacaoManager;
	private Avaliacao avaliacao;
	
	@PostConstruct
    public void init() {
		
		this.avaliacaoManager=new AvaliacaoManager();
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		avaliacao=(Avaliacao)sessionMapObj.get("avaliacao");
		
		if(avaliacao==null) {
			this.avaliacao=avaliacaoManager.novaAvaliacao();
		}else {
			avaliacaoManager.detalhar(avaliacao);
		}
	}
	
	public void finalizar() {
		avaliacaoManager.finalizar(getAvaliacao());
	}
	

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	
}