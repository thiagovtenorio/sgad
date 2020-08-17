package dominio;

import java.util.ArrayList;

public class Competencia {
	private int id;
	private String nome;
	private String descricao;
	private ArrayList<Afirmativa> afirmativas;
	
	public Competencia(){
		afirmativas=new ArrayList<Afirmativa>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<Afirmativa> getAfirmativas() {
		return afirmativas;
	}
	public void setAfirmativas(ArrayList<Afirmativa> afirmativas) {
		this.afirmativas = afirmativas;
	}
	
}
