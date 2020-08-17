package dominio;

import java.sql.Date;
import java.util.ArrayList;

public class Avaliacao {
	private int id;
	private int idModeloAvaliacao;
	private Date data;
	private String nome;
	private String area;
	private String perfil;
	private String gestor;
	private ArrayList<Competencia> competencias;
	
	public Avaliacao() {
		competencias=new ArrayList<Competencia>();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getIdModeloAvaliacao() {
		return idModeloAvaliacao;
	}
	
	public void setIdModeloAvaliacao(int idModeloAvaliacao) {
		this.idModeloAvaliacao = idModeloAvaliacao;
	}
	public ArrayList<Competencia> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(ArrayList<Competencia> competencias) {
		this.competencias = competencias;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}
	
}
