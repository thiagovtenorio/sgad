package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import dominio.Afirmativa;
import dominio.Competencia;
import manager.AfirmativaManager;
import manager.AvaliacaoManager;
import manager.CompetenciaManager;
import manager.ModeloAvaliacaoManager;

@ManagedBean @ViewScoped
public class ModeloAvaliacaoBean {
	private int afirmativaId;
	private List<Afirmativa> afirmativasByCompetencia;
	
	private CompetenciaManager competenciaManager;
	private AfirmativaManager afirmativaManager;	
	private ModeloAvaliacaoManager modeloAvaliacaoManager;
	
	private int competenciaId;
	
	private String nomeModelo;
	private ArrayList<Afirmativa> afirmativaEscolhidaList;
	
	@SuppressWarnings("restriction")
	@PostConstruct
    public void init() {
		this.competenciaManager= new CompetenciaManager();
		this.afirmativaManager= new AfirmativaManager();
		this.modeloAvaliacaoManager=new ModeloAvaliacaoManager();
		this.afirmativaEscolhidaList=new ArrayList<Afirmativa>();
	}
	public void adicionarAfirmativa() {
		Afirmativa afirmativa=afirmativaManager.findAfirmativaById(afirmativaId);
		afirmativaEscolhidaList.add(afirmativa);
	}
	public void concluir() {
		this.modeloAvaliacaoManager.criarModeloAvaliacao(this.nomeModelo, this.afirmativaEscolhidaList);
	}
	public int getAfirmativaId() {
		return afirmativaId;
	}
	public void setAfirmativaId(int afirmativaId) {
		this.afirmativaId = afirmativaId;
	}
	
	public void onCompetenciaChange() {
		this.afirmativasByCompetencia=afirmativaManager.findAfirmativasByCompetenciaId(this.competenciaId);
	}
	public List<Afirmativa> getAfirmativasByCompetencia() {
		return afirmativasByCompetencia;
	}

	public void setAfirmativasByCompetencia(List<Afirmativa> afirmativasByCompetencia) {
		this.afirmativasByCompetencia = afirmativasByCompetencia;
	}

	public int getCompetenciaId() {
		return competenciaId;
	}

	public void setCompetenciaId(int competenciaId) {
		this.competenciaId = competenciaId;
	}

	public ArrayList<Afirmativa> getAfirmativaEscolhidaList() {
		return afirmativaEscolhidaList;
	}
	public void setAfirmativaEscolhidaList(ArrayList<Afirmativa> afirmativaEscolhidaList) {
		this.afirmativaEscolhidaList = afirmativaEscolhidaList;
	}
	
	public String getNomeModelo() {
		return nomeModelo;
	}
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
}
