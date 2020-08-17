package dao;

import dominio.Afirmativa;
import dominio.AvaliacaoAfirmativa;

public class AvaliacaoAfirmativaDAO extends DAO{
	public void insert(AvaliacaoAfirmativa avaliacaoAfirmativa) 
	{
		try {
	    	 pstmt = getConnection().prepareStatement("insert into sgad.avaliacaoafirmativa(avaliacao_id, afirmativa_id) values (?, ?)");
	    	 pstmt.setInt(1,avaliacaoAfirmativa.getAvaliacaoId());
	    	 pstmt.setInt(2, avaliacaoAfirmativa.getAfirmativaId());
	    	 pstmt.executeUpdate();
		     connObj.close();
		}catch(Exception e) {
			
		}
	}
}
