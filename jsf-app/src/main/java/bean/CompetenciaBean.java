package bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.Competencia;
import manager.CompetenciaManager;

@ManagedBean @RequestScoped
public class CompetenciaBean {
	private Competencia competencia;
	private CompetenciaManager competenciaManager;
	
	@PostConstruct
    public void init() {
		this.competenciaManager=new CompetenciaManager();
		this.competencia=new Competencia();
	}

	public Competencia getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public void remove(int competenciaId) {
		competenciaManager.remove(competenciaId);
	}
	public void insert() {
		competenciaManager.insert(this.competencia);
	}
}
