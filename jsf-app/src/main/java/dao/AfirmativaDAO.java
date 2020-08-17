package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Afirmativa;
import dominio.Competencia;

public class AfirmativaDAO extends DAO{
	
	public void insert(Afirmativa afirmativa) {
		try {
	    	 pstmt = getConnection().prepareStatement("insert into sgad.afirmativa(nome, descricao, competencia_id) values (?, ?, ?)");         
	         pstmt.setString(1, afirmativa.getNome());
	         pstmt.setString(2, afirmativa.getDescricao());
	         pstmt.setInt(3, afirmativa.getCompetenciaId());
	         pstmt.executeUpdate();
	         connObj.close();
   	}catch(Exception e) {
   		e.printStackTrace();
   	}
	}
	public void remove(int idAfirmativa) {
		try {
  		  pstmt = getConnection().prepareStatement("delete from afirmativa where afirmativa_id = "+idAfirmativa);  
          pstmt.executeUpdate();  
          connObj.close();
  	}catch(Exception e) {
  		e.printStackTrace();
  	}
	}
	public ArrayList<Afirmativa> listAll(){
		ArrayList<Afirmativa> afirmativaList=new ArrayList<Afirmativa>();
		try {
			stmtObj = getConnection().createStatement();    
    		resultSetObj = stmtObj.executeQuery("select * from afirmativa");
    		while(resultSetObj.next()) { 
    			Afirmativa afirObj=new Afirmativa();
    			afirObj.setId(resultSetObj.getInt("afirmativa_id"));
    			afirObj.setCompetenciaId(resultSetObj.getInt("competencia_id"));
    			afirObj.setNome(resultSetObj.getString("nome"));
    			afirObj.setDescricao(resultSetObj.getString("descricao"));
    			afirmativaList.add(afirObj);
    		}
    		connObj.close();
		}catch(Exception e) {
			
		}
		return afirmativaList;
	}
    public ArrayList<Afirmativa> findAfirmativasByCompetenciaId(int competenciaId){
    	ArrayList<Afirmativa> afirmativaList=new ArrayList<Afirmativa>();
    	try {
    		stmtObj = getConnection().createStatement();    
    		resultSetObj = stmtObj.executeQuery("select * from afirmativa where competencia_id ="+competenciaId);
    		while(resultSetObj.next()) { 
    			Afirmativa afirObj=new Afirmativa();
    			afirObj.setId(resultSetObj.getInt("afirmativa_id"));
    			afirObj.setCompetenciaId(resultSetObj.getInt("competencia_id"));
    			afirObj.setNome(resultSetObj.getString("nome"));
    			afirObj.setDescricao(resultSetObj.getString("descricao"));
    			afirmativaList.add(afirObj);
    		}
    		connObj.close();
    	}catch(Exception e) {
    		
    	}
    	return afirmativaList;
    }
    public Afirmativa findAfirmativaById(int afirmativaId) {
    	Afirmativa afirmativa=new Afirmativa();
    	try {
    		stmtObj = getConnection().createStatement();    
    		resultSetObj = stmtObj.executeQuery("select * from afirmativa where afirmativa_id ="+afirmativaId);
    		while(resultSetObj.next()) { 
    			afirmativa.setId(resultSetObj.getInt("afirmativa_id"));
    			afirmativa.setCompetenciaId(resultSetObj.getInt("competencia_id"));
    			afirmativa.setNome(resultSetObj.getString("nome"));
    			afirmativa.setDescricao(resultSetObj.getString("descricao"));
    		}
    		connObj.close();
    	}catch(Exception e) {
    		
    	}
    	
    	return afirmativa;
    }
}
