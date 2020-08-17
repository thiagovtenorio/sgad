package bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dominio.ModeloAvaliacao;
import manager.ModeloAvaliacaoManager;

@ManagedBean @ViewScoped
public class ModeloAvaliacaoListBean {
	private ModeloAvaliacaoManager modeloAvaliacaoManager;
	private ArrayList<ModeloAvaliacao> modeloAvaliacaoList;
	
	@SuppressWarnings("restriction")
	@PostConstruct
    public void init() {
		modeloAvaliacaoManager=new ModeloAvaliacaoManager();
		modeloAvaliacaoList=modeloAvaliacaoManager.listAll();
	}
	public ArrayList<ModeloAvaliacao> getModeloAvaliacaoList() {
		return modeloAvaliacaoList;
	}
	public void setModeloAvaliacaoList(ArrayList<ModeloAvaliacao> modeloAvaliacaoList) {
		this.modeloAvaliacaoList = modeloAvaliacaoList;
	}
}
