package dominio;

public class NotaAvaliacao {
	private int avaliacaoId;
	private int afirmativaId;
	private int nota;
	private String tipoAvaliacao;
	
	public int getAvaliacaoId() {
		return avaliacaoId;
	}
	public void setAvaliacaoId(int avaliacaoId) {
		this.avaliacaoId = avaliacaoId;
	}
	
	public int getAfirmativaId() {
		return afirmativaId;
	}
	public void setAfirmativaId(int afirmativaId) {
		this.afirmativaId = afirmativaId;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	public void setTipoAvaliacao(String tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
	
}
