package manager;

import java.util.ArrayList;

import dao.CompetenciaDAO;
import dominio.Competencia;

public class CompetenciaManager {
	private CompetenciaDAO competenciaDAO;
	public CompetenciaManager(){
		competenciaDAO=new CompetenciaDAO();
	}
	public ArrayList<Competencia> listAll()
	{
		return competenciaDAO.listAll();
	}
	public void insert(Competencia competencia) {
		competenciaDAO.insert(competencia);
	}
	public void remove(int competenciaId) {
		competenciaDAO.remove(competenciaId);
	}
}
