package converter;

import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import dominio.Afirmativa;

@FacesConverter("converter.AfirmativaConverter")
public class AfirmativaConverter implements Converter{

	public Object getAsObject(FacesContext arg0, UIComponent component, String value) {
		Afirmativa afir=new Afirmativa();
		
		return afir;
	}

	public String getAsString(FacesContext arg0, UIComponent component, Object value) {
		Afirmativa afir=(Afirmativa)value;
		
		StringBuilder sb=new StringBuilder();
		
		sb.append(afir.getNome());
		sb.append(";");
		sb.append(afir.getDescricao());
		
		return sb.toString();
	}
	
}