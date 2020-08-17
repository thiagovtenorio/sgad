package manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dao.AfirmativaDAO;
import dao.CompetenciaDAO;
import dao.ModeloAfirmativaDAO;
import dominio.Afirmativa;
import dominio.Avaliacao;
import dominio.Competencia;
import dominio.ModeloAfirmativa;

public class AutoAvaliacaoManager {
	private ModeloAfirmativaDAO modeloAfirmativaDAO;
	private AfirmativaDAO afirmativaDAO;
	private CompetenciaDAO competenciaDAO;
	public AutoAvaliacaoManager() {
		modeloAfirmativaDAO=new ModeloAfirmativaDAO();
		afirmativaDAO=new AfirmativaDAO();
		competenciaDAO=new CompetenciaDAO();
	}
	
	public void carregarCompetenciasEAfirmativasPorModelo(Avaliacao avaliacao, int idModeloAvaliacao) {
		ArrayList<Competencia> competenciaList=new ArrayList<Competencia>();
		ArrayList<Afirmativa> afirmativaList=new ArrayList<Afirmativa>();
		ArrayList<ModeloAfirmativa> modeloAfirmativaList=modeloAfirmativaDAO.findByIdModeloAvaliacao(idModeloAvaliacao);
		
		Afirmativa afirmativa=null;
		for(ModeloAfirmativa modeloAfirmativa:modeloAfirmativaList) 
		{	
			afirmativa=afirmativaDAO.findAfirmativaById(modeloAfirmativa.getIdAfirmativa());
			afirmativaList.add(afirmativa);
		}
		
		Map<Integer, Competencia> afirmativasByCompetencia=new HashMap<Integer, Competencia>();
		Competencia competencia=null;
		
		for(Afirmativa afir:afirmativaList) {
			competencia=competenciaDAO.findCompetenciaById(afir.getCompetenciaId());
			
			if(afirmativasByCompetencia.containsKey(afir.getCompetenciaId())){
				Competencia comp=afirmativasByCompetencia.get(afir.getCompetenciaId());
				comp.getAfirmativas().add(afir);
			}else {
				afirmativasByCompetencia.put(afir.getCompetenciaId(), competencia);
				afirmativasByCompetencia.get(afir.getCompetenciaId()).getAfirmativas().add(afir);
			}
		}
		
		Object[] competenciasId=afirmativasByCompetencia.keySet().toArray();
		
		for(Object competenciaId:competenciasId) {
			competenciaList.add(afirmativasByCompetencia.get((Integer)competenciaId));
		}
		
		avaliacao.setCompetencias(competenciaList);
	}
	
	public Avaliacao novaAvaliacao(int idModeloAvaliacao){
		
		Avaliacao avaliacao=new Avaliacao();
		avaliacao.setData(new Date(System.currentTimeMillis()));
		
		carregarCompetenciasEAfirmativasPorModelo(avaliacao, idModeloAvaliacao);
		
		return avaliacao;
	}
}
