package bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.Competencia;
import manager.CompetenciaManager;

@ManagedBean @RequestScoped
public class CompetenciaListBean {
	
	private CompetenciaManager competenciaManager;
	private ArrayList<Competencia> competenciaList;
	
	@PostConstruct
    public void init() {
		competenciaManager=new CompetenciaManager();
		competenciaList=competenciaManager.listAll();
	}

	public ArrayList<Competencia> getCompetenciaList() {
		return competenciaList;
	}

	public void setCompetenciaList(ArrayList<Competencia> competenciaList) {
		this.competenciaList = competenciaList;
	}
}
