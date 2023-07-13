package Negocio;

import Dao.InmuebleDAO;
import Dao.PersonaDAO;
import Modelo.Inmueble;
import Modelo.Persona;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosEva {

	@Inject
	private PersonaDAO daoPersona;
	@Inject
	private InmuebleDAO daoInmueble;
	
	public void init() {
		
		Persona p = new Persona();
		p.setCedula("0102023377");
		p.setNombre("Alberto");
		p.setApellido("Alvarez");
		p.setDireccion("3 puentes");
		p.setTelefono("099889076");
		
		Inmueble i = new Inmueble();
		i.setTipo("Terreno");
		i.setPrecio(17.000);
		i.setHectareas("500 m^2");
		i.setDireccion("Av. Americas");
		daoInmueble.insert(i);
		
		Inmueble i2 = new Inmueble();
		i2.setTipo("Edificio");
		i2.setPrecio(53.000);
		i2.setHectareas("1200 m^2");
		i2.setDireccion("Av. Don Bosco y Av. Loja");
		daoInmueble.insert(i2);
		
		p.addInmueble(i);
		p.addInmueble(i2);
		daoPersona.insert(p);
		
	}
}
