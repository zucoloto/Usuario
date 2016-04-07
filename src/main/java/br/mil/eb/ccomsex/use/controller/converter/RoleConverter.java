package br.mil.eb.ccomsex.use.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mil.eb.ccomsex.use.model.entity.Role;
import br.mil.eb.ccomsex.use.model.repository.RoleRepository;

@FacesConverter(forClass = Role.class)
public class RoleConverter implements Converter {

	@Inject
	private RoleRepository roleRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Role retorno = null;
		if (value != null && !value.equals("")) {
			retorno = roleRepository.buscarPorId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Role retorno = (Role) value;
			return retorno.getId() == null ? null : retorno.getId().toString();
		}
		return null;
	}

}
