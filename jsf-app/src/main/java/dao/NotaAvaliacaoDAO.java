package dao;

import java.util.ArrayList;

import dominio.Avaliacao;
import dominio.NotaAvaliacao;

public class NotaAvaliacaoDAO extends DAO{
	public void inserir(NotaAvaliacao notaAvaliacao) {
		try {
			pstmt = getConnection().prepareStatement("insert into notaavaliacao (avaliacao_id, afirmacao_id, nota, tipoavaliacao) values (?, ?, ?, ?)");
			pstmt.setInt(1, notaAvaliacao.getAvaliacaoId());
			pstmt.setInt(2, notaAvaliacao.getAfirmativaId());
			pstmt.setInt(3, notaAvaliacao.getNota());
			pstmt.setString(4, notaAvaliacao.getTipoAvaliacao());
			pstmt.executeUpdate();
            connObj.close();
		}catch (Exception e){
			
		}
	}
	
	public NotaAvaliacao findNotaAvaliacaoById(int idAvaliacao, int idAfirmativa){
		
		NotaAvaliacao notaAvaliacao=new NotaAvaliacao();
		try {
			stmtObj =  getConnection().createStatement();    
			StringBuilder sb=new StringBuilder();
			sb.append("select * from sgad.notaavaliacao where avaliacao_id=");
			sb.append(idAvaliacao);
			sb.append(" and afirmacao_id=");
			sb.append(idAfirmativa);
			
        	resultSetObj = stmtObj.executeQuery(sb.toString());
        	
        	while(resultSetObj.next()) {  

        		notaAvaliacao.setAfirmativaId(resultSetObj.getInt("afirmacao_id"));
        		notaAvaliacao.setAvaliacaoId(resultSetObj.getInt("avaliacao_id"));
        		notaAvaliacao.setNota(resultSetObj.getInt("nota"));
        		notaAvaliacao.setTipoAvaliacao(resultSetObj.getString("tipoavaliacao"));
        		
        	}
        	connObj.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return notaAvaliacao;
	}
}
