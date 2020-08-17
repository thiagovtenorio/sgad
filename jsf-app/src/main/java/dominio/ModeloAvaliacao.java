package dominio;

import java.util.ArrayList;

public class ModeloAvaliacao {
	private int idModeloAvaliacao;
	private String nome;
	private ArrayList<ModeloAfirmativa> afirmativas;
	public int getIdModeloAvaliacao() {
		return idModeloAvaliacao;
	}
	public void setIdModeloAvaliacao(int idModeloAvaliacao) {
		this.idModeloAvaliacao = idModeloAvaliacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<ModeloAfirmativa> getAfirmativas() {
		return afirmativas;
	}
	public void setAfirmativas(ArrayList<ModeloAfirmativa> afirmativas) {
		this.afirmativas = afirmativas;
	}
}
