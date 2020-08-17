package bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import dominio.Usuario;
import manager.UsuarioManager;

@SuppressWarnings("restriction")
@ManagedBean @ViewScoped
public class UsuarioBean {
	
	private Usuario usuario;
	private ArrayList<String> tiposUsuario;
	private UsuarioManager usuarioManager;
	private String nomeColaborador;
	
	@PostConstruct
    public void init() {
		this.usuarioManager=new UsuarioManager();
		this.tiposUsuario=new ArrayList<String>();
		this.tiposUsuario.add("Colaborador");
		this.tiposUsuario.add("Gestor");
		this.tiposUsuario.add("RH");
		
		this.usuario=new Usuario();
	}
	public ArrayList<Usuario> getColaboradoresByNome(){
		return usuarioManager.getColaboradoresByNome(this.nomeColaborador);
	}
	
	public String cadastrar() {
		this.usuarioManager.insert(this.usuario);
		return "sgadLogin.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<String> getTiposUsuario() {
		return tiposUsuario;
	}

	public void setTiposUsuario(ArrayList<String> tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
}
