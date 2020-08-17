package manager;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.UsuarioDAO;
import dominio.Usuario;

public class UsuarioManager {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioManager(){
		this.usuarioDAO=new UsuarioDAO();
	}
	public void insert(Usuario usuario) {
		this.usuarioDAO.insert(usuario);
	}
	public boolean login(String login, String senha) {
		try {
			return usuarioDAO.login(login, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<Usuario> getColaboradoresByNome(String nome){
		try {
			return usuarioDAO.listColaboradorByNome(nome);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Usuario>();
	}
}
