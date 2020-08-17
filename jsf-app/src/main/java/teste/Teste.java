package teste;

import java.util.ArrayList;

import dao.CompetenciaDAO;
import dao.NotaAvaliacaoDAO;
import dominio.Competencia;

class Teste{
	public static void main(String[] args) {
		NotaAvaliacaoDAO notaDAO=new NotaAvaliacaoDAO();
		notaDAO.findNotaAvaliacaoById(6, 1);
		
		
		
	}
}