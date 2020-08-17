package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Avaliacao;

public class AvaliacaoDAO extends DAO{
	
	
	public int inserir(Avaliacao avaliacao) {
		int generatedKey = 0;
		try {
			 pstmt = getConnection().prepareStatement("insert into avaliacao (data, nome, area, perfil, gestor, idmodeloavaliacao) values (?, ?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);  
			 pstmt.setDate(1, avaliacao.getData());
	         pstmt.setString(2, avaliacao.getNome());
	         pstmt.setString(3, avaliacao.getArea());
	         pstmt.setString(4, avaliacao.getPerfil());
	         pstmt.setString(5, avaliacao.getGestor());
	         pstmt.setInt(6, avaliacao.getIdModeloAvaliacao());
			 pstmt.execute();
			 
			 ResultSet rs = pstmt.getGeneratedKeys();
			 
			 if (rs.next()) {
			     generatedKey = rs.getInt(1);
			 }
		}
		catch(Exception e) {
			
		}
		return generatedKey;
	}
	public ArrayList<Avaliacao> listAll(){
		ArrayList<Avaliacao> avaliacaoList=new ArrayList<Avaliacao>();
		try {
			stmtObj = getConnection().createStatement();    
        	resultSetObj = stmtObj.executeQuery("select * from avaliacao");
        	while(resultSetObj.next()) {  
        		Avaliacao avaliacao=new Avaliacao();
        		avaliacao.setId(resultSetObj.getInt("id"));
        		avaliacao.setData(resultSetObj.getDate("data"));
        		avaliacao.setNome(resultSetObj.getString("nome"));
        		avaliacao.setPerfil(resultSetObj.getString("perfil"));
        		avaliacao.setArea(resultSetObj.getString("area"));
        		avaliacao.setGestor(resultSetObj.getString("gestor"));
        		avaliacao.setIdModeloAvaliacao(resultSetObj.getInt("idmodeloavaliacao"));
        		avaliacaoList.add(avaliacao);
        	}
        	connObj.close();
		}catch(Exception e) {
			
		}
		return avaliacaoList;
	}
	
}
