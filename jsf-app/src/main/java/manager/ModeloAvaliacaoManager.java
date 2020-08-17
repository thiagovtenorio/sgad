package manager;

import java.util.ArrayList;
import java.util.List;

import dao.ModeloAfirmativaDAO;
import dao.ModeloAvaliacaoDAO;
import dominio.Afirmativa;
import dominio.ModeloAfirmativa;
import dominio.ModeloAvaliacao;

public class ModeloAvaliacaoManager {
	private ModeloAvaliacaoDAO modeloAvaliacaoDAO;
	private ModeloAfirmativaDAO modeloAfirmativaDAO;
	
	public ModeloAvaliacaoManager() {
		modeloAvaliacaoDAO=new ModeloAvaliacaoDAO();
		modeloAfirmativaDAO=new ModeloAfirmativaDAO();
	}
	public void criarModeloAvaliacao(String nome, List<Afirmativa> afirmativaEscolhidaList) {
		ModeloAvaliacao modeloAvaliacao=new ModeloAvaliacao();
		modeloAvaliacao.setNome(nome);
		
		int idModeloAvaliacao=modeloAvaliacaoDAO.inserir(modeloAvaliacao);
		ModeloAfirmativa modeloAfirmativa=null;
		
		for(Afirmativa afirmativa:afirmativaEscolhidaList) {
			modeloAfirmativa=new ModeloAfirmativa();
			modeloAfirmativa.setIdModeloAvaliacao(idModeloAvaliacao);
			modeloAfirmativa.setIdAfirmativa(afirmativa.getId());
			modeloAfirmativaDAO.inserir(modeloAfirmativa);
		}
	}
	public ArrayList<ModeloAvaliacao> listAll(){
		return modeloAvaliacaoDAO.listAll();
	}
	
}
