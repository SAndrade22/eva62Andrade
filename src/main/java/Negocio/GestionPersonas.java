package Negocio;

import Dao.PersonaDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import Modelo.Persona;

@Stateless
public class GestionPersonas {

	@Inject
	private PersonaDAO daoPersona;
	
public void guardarPersonas(Persona persona) throws Exception{
		
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		
		if(daoPersona.read(persona.getCedula())==null) {
			try {
				daoPersona.insert(persona);
			}catch(Exception e) {
				throw new Exception("Error al insertar: "+e.getMessage());
			}
		}else {
			try {
				daoPersona.update(persona);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: "+e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length()==10;
	}
	
}
