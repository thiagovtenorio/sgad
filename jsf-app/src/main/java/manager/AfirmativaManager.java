package manager;

import java.util.ArrayList;

import dao.AfirmativaDAO;
import dao.CompetenciaDAO;
import dominio.Afirmativa;
import dominio.Competencia;

public class AfirmativaManager {
	private AfirmativaDAO afirmativaDAO;
	private CompetenciaDAO competenciaDAO;
	
	public AfirmativaManager() {
		this.afirmativaDAO=new AfirmativaDAO();
		this.competenciaDAO=new CompetenciaDAO();
	}
	
	public ArrayList<Afirmativa> listAll(){
		ArrayList<Afirmativa> afirmativaList=this.afirmativaDAO.listAll();
		Competencia competencia=null;
		for(Afirmativa afirmativa:afirmativaList) {
			competencia=competenciaDAO.findCompetenciaById(afirmativa.getCompetenciaId());
			afirmativa.setCompetencia(competencia);
		}
		return afirmativaList;
	}
	public ArrayList<Afirmativa> findAfirmativasByCompetenciaId(int competenciaId){
		return afirmativaDAO.findAfirmativasByCompetenciaId(competenciaId);
	}
	 public Afirmativa findAfirmativaById(int afirmativaId) {
		Afirmativa afirmativa=afirmativaDAO.findAfirmativaById(afirmativaId);
		Competencia competencia=competenciaDAO.findCompetenciaById(afirmativa.getCompetenciaId());
		afirmativa.setCompetencia(competencia);
		return afirmativa;
	 }
	public void insert(Afirmativa afirmativa) {
		afirmativaDAO.insert(afirmativa);
	}
	public void remove(int idAfirmativa) {
		afirmativaDAO.remove(idAfirmativa);
	}
}
