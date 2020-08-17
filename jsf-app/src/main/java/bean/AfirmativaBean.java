package bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.Afirmativa;
import manager.AfirmativaManager;

@ManagedBean @RequestScoped
public class AfirmativaBean {
	private Afirmativa afirmativa;
	private AfirmativaManager afirmativaManager;
	
	@PostConstruct
    public void init() {
		afirmativaManager=new AfirmativaManager();
		afirmativa=new Afirmativa();
	}

	public Afirmativa getAfirmativa() {
		return afirmativa;
	}

	public void setAfirmativa(Afirmativa afirmativa) {
		this.afirmativa = afirmativa;
	}
	public void insert() {
		afirmativaManager.insert(this.afirmativa);
	}
	public void remove(int afirmativaId) {
		afirmativaManager.remove(afirmativaId);
	}
}
