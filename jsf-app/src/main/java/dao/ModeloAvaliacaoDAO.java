package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Avaliacao;
import dominio.ModeloAvaliacao;

public class ModeloAvaliacaoDAO extends DAO{
	public int inserir(ModeloAvaliacao modeloAvaliacao) {
		int generatedKey = 0;
		try {
			 pstmt = getConnection().prepareStatement("insert into sgad.modeloavaliacao (idmodeloavaliacao, nome) values (?, ?)", Statement.RETURN_GENERATED_KEYS);  
			 pstmt.setInt(1, modeloAvaliacao.getIdModeloAvaliacao());
	         pstmt.setString(2, modeloAvaliacao.getNome());
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
	public ArrayList<ModeloAvaliacao> listAll(){
		ArrayList<ModeloAvaliacao> modeloAvaliacaoList=new ArrayList<ModeloAvaliacao>();
		try {
			stmtObj = getConnection().createStatement();    
        	resultSetObj = stmtObj.executeQuery("select * from modeloavaliacao");
        	while(resultSetObj.next()) {  
        		ModeloAvaliacao modeloAvaliacao=new ModeloAvaliacao();
        		modeloAvaliacao.setNome(resultSetObj.getString("nome"));
        		modeloAvaliacao.setIdModeloAvaliacao(resultSetObj.getInt("idmodeloavaliacao"));
        		modeloAvaliacaoList.add(modeloAvaliacao);
        	}
        	connObj.close();
		}catch(Exception e) {
			
		}
		return modeloAvaliacaoList;
	}
	
}
