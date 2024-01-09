package br.com.edmilton.java.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.edmilton.java.dao.ProdutoDao;
import br.com.edmilton.java.model.Produto;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {
	
	private ProdutoDao produtoDao;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        produtoDao = new ProdutoDao();
        Produto obj = produtoDao.findById(id).get(0);
        return obj;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		Produto obj = (Produto) o;
        return obj.getId().toString();
	}
	
}
