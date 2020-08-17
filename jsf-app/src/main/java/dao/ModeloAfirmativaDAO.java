package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.ModeloAfirmativa;
import dominio.ModeloAvaliacao;

public class ModeloAfirmativaDAO extends DAO{
	public int inserir(ModeloAfirmativa modeloAfirmativa) {
		int generatedKey = 0;
		try {
			 pstmt = getConnection().prepareStatement("insert into modeloafirmativa (afirmativa_id, idmodeloavaliacao) values (?, ?)", Statement.RETURN_GENERATED_KEYS);  
			 pstmt.setInt(1, modeloAfirmativa.getIdAfirmativa());
	         pstmt.setInt(2, modeloAfirmativa.getIdModeloAvaliacao());
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
	public ArrayList<ModeloAfirmativa> findByIdModeloAvaliacao(int idModeloAvaliacao){
		ArrayList<ModeloAfirmativa> modeloAfirmativaList=new ArrayList<ModeloAfirmativa>();
		try {
    		stmtObj = getConnection().createStatement();    
    		resultSetObj = stmtObj.executeQuery("select * from modeloafirmativa where idmodeloavaliacao ="+idModeloAvaliacao);
    		while(resultSetObj.next()) { 
    			ModeloAfirmativa modeloAfirmativa=new ModeloAfirmativa();
    			modeloAfirmativa.setIdAfirmativa(resultSetObj.getInt("afirmativa_id"));
    			modeloAfirmativa.setIdModeloAvaliacao(resultSetObj.getInt("idmodeloavaliacao"));
    			modeloAfirmativaList.add(modeloAfirmativa);
    		}
    		connObj.close();
    	}catch(Exception e) {
    		
    	}
		return modeloAfirmativaList;
	}
}
