package bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dominio.Afirmativa;
import manager.AfirmativaManager;

@ManagedBean @RequestScoped
public class AfirmativaListBean {
	
	private AfirmativaManager afirmativaManager;
	private ArrayList<Afirmativa> afirmativaList;
	
	@PostConstruct
    public void init() {
		afirmativaManager=new AfirmativaManager();
		afirmativaList=afirmativaManager.listAll();
	}

	public ArrayList<Afirmativa> getAfirmativaList() {
		return afirmativaList;
	}

	public void setAfirmativaList(ArrayList<Afirmativa> afirmativaList) {
		this.afirmativaList = afirmativaList;
	}
	
}
