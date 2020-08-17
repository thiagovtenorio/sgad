package manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AfirmativaDAO;
import dao.AvaliacaoAfirmativaDAO;
import dao.AvaliacaoDAO;
import dao.CompetenciaDAO;
import dao.ModeloAfirmativaDAO;
import dao.NotaAvaliacaoDAO;
import dominio.Afirmativa;
import dominio.Avaliacao;
import dominio.AvaliacaoAfirmativa;
import dominio.Competencia;
import dominio.ModeloAfirmativa;
import dominio.NotaAvaliacao;

public class AvaliacaoManager{
	private AvaliacaoDAO avaliacaoDAO;
	private AvaliacaoAfirmativaDAO avaliacaoAfirmativaDAO;
	private NotaAvaliacaoDAO notaAvaliacaoDAO;
	private CompetenciaDAO competenciaDAO;
	private AfirmativaDAO afirmativaDAO;
	private ModeloAfirmativaDAO modeloAfirmativaDAO;
	public AvaliacaoManager(){
		avaliacaoDAO=new AvaliacaoDAO();
		notaAvaliacaoDAO=new NotaAvaliacaoDAO();
		competenciaDAO=new CompetenciaDAO();
		afirmativaDAO=new AfirmativaDAO();
		modeloAfirmativaDAO=new ModeloAfirmativaDAO();
	}
	
	public Avaliacao novaAvaliacao(){
		
		Avaliacao avaliacao=new Avaliacao();
		avaliacao.setData(new Date(System.currentTimeMillis()));
		
		ArrayList<Competencia> competenciaList=new ArrayList<Competencia>();
		ArrayList<Afirmativa> afirmativaList=new ArrayList<Afirmativa>();
		
		competenciaList=competenciaDAO.listAll();
		
		for(Competencia competencia:competenciaList) {
			afirmativaList=afirmativaDAO.findAfirmativasByCompetenciaId(competencia.getId());
			competencia.setAfirmativas(afirmativaList);
		}
		avaliacao.setCompetencias(competenciaList);
		
		return avaliacao;
	}
	public void finalizar(Avaliacao avaliacao) {
		int avaliacaoId=avaliacaoDAO.inserir(avaliacao);
		
		NotaAvaliacao nota=null;
		for(Competencia competencia:avaliacao.getCompetencias()) {
			
			for(Afirmativa afirmativa:competencia.getAfirmativas()) {
				nota=afirmativa.getNota();
				nota.setAvaliacaoId(avaliacaoId);
				nota.setAfirmativaId(afirmativa.getId());
				notaAvaliacaoDAO.inserir(afirmativa.getNota());
				
			}
		}
	}
	
	public void detalhar(Avaliacao avaliacao) {		
		carregarCompetenciasEAfirmativasPorModelo(avaliacao, avaliacao.getIdModeloAvaliacao());
		NotaAvaliacao nota=null;
		for(Competencia competencia:avaliacao.getCompetencias()) {
			for(Afirmativa afirmativa:competencia.getAfirmativas()) {
				System.out.println("idModelo= "+avaliacao.getIdModeloAvaliacao()+ "idAvaliacao= "+avaliacao.getId()+" idAfirmativa= "+afirmativa.getId());
				nota=notaAvaliacaoDAO.findNotaAvaliacaoById(avaliacao.getId(), afirmativa.getId());
				afirmativa.setNota(nota);
			}
		}
	}
	
	public ArrayList<Avaliacao> listAll(){
		ArrayList<Avaliacao> avaliacaoList=avaliacaoDAO.listAll();
		return avaliacaoList;
	}
	public void criarModeloAvaliacao(List<Afirmativa> afirmativaEscolhidaList) {
		Avaliacao avaliacaoModelo=new Avaliacao();
		
		int avaliacaoId=avaliacaoDAO.inserir(avaliacaoModelo);
		
		AvaliacaoAfirmativa avaliacaoAfirmativa=new AvaliacaoAfirmativa();
		
		for(Afirmativa afirmativa:afirmativaEscolhidaList) {
			avaliacaoAfirmativa=new AvaliacaoAfirmativa();
			avaliacaoAfirmativa.setAvaliacaoId(avaliacaoId);
			avaliacaoAfirmativa.setAfirmativaId(afirmativa.getId());
			avaliacaoAfirmativaDAO.insert(avaliacaoAfirmativa);
		}
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
}