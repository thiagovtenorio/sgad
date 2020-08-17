package dominio;

public class Afirmativa {
	private int id;
	private String nome;
	private String descricao;
	private int competenciaId;
	private NotaAvaliacao nota;
	private Competencia competencia;
	
	public Afirmativa() {
		this.nota=new NotaAvaliacao();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NotaAvaliacao getNota() {
		return nota;
	}
	public void setNota(NotaAvaliacao nota) {
		this.nota = nota;
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
	public int getCompetenciaId() {
		return competenciaId;
	}
	public void setCompetenciaId(int competenciaId) {
		this.competenciaId = competenciaId;
	}

	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
}
