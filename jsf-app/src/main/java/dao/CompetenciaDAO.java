package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Competencia;

public class CompetenciaDAO{
	public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;
 
    public static Connection getConnection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");     
            String db_url ="jdbc:mysql://localhost:3306/sgad?useTimezone=true&serverTimezone=UTC",
                    db_userName = "root",
                    db_password = "servidor";
            connObj = DriverManager.getConnection(db_url,db_userName,db_password);  
        } catch(Exception sqlException) {  
            sqlException.printStackTrace();
        }  
        return connObj;
    }
    public void insert(Competencia competencia) {
    	try {
	    	 pstmt = getConnection().prepareStatement("insert into sgad.competencias(nome, descricao) values (?, ?)");         
	         pstmt.setString(1, competencia.getNome());
	         pstmt.setString(2, competencia.getDescricao());
	         pstmt.executeUpdate();
	         connObj.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void remove(int competenciaId) {
    	try {
    		  pstmt = getConnection().prepareStatement("delete from competencias where competencia_id = "+competenciaId);  
              pstmt.executeUpdate();  
              connObj.close();
    	}catch(Exception e) {
    		
    	}
    }
    public Competencia findCompetenciaById(int competenciaId){
    	Competencia comObj=new Competencia();
    	try {
    		stmtObj = getConnection().createStatement();    
    		resultSetObj = stmtObj.executeQuery("select * from competencias where competencia_id="+competenciaId);
    		while(resultSetObj.next()) { 
    			comObj.setId(resultSetObj.getInt("competencia_id"));
    			comObj.setNome(resultSetObj.getString("nome"));
    			comObj.setDescricao(resultSetObj.getString("descricao"));
    		}
    		connObj.close();
    	}catch(Exception e) {
    		
    	}
    	return comObj;
    }
    public ArrayList<Competencia> listAll(){
    	ArrayList<Competencia> competenciaList=new ArrayList<Competencia>();
    	try {
    		stmtObj = getConnection().createStatement();    
    		resultSetObj = stmtObj.executeQuery("select * from competencias");
    		while(resultSetObj.next()) { 
    			Competencia comObj=new Competencia();
    			comObj.setId(resultSetObj.getInt("competencia_id"));
    			comObj.setNome(resultSetObj.getString("nome"));
    			comObj.setDescricao(resultSetObj.getString("descricao"));
    			competenciaList.add(comObj);
    		}
    		connObj.close();
    	}catch(Exception e) {
    		
    	}
    	
    	return competenciaList;
    }
    
}