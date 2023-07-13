package Modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Inmueble {
	
	@Id
	@GeneratedValue
	@Column(name="inm_codigo")
	int Codigo;
	@Column(name="inm_tipo")
	String Tipo;
	@Column(name="inm_direccion")
	String Direccion;
	@Column(name="inm_precio")
	Double Precio;
	@Column(name="inm_hectareas")
	String Hectareas;
	
	
	
	public int getId() {
		return Codigo;
	}
	public void setId(int codigo) {
		this.Codigo = codigo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public Double getPrecio() {
		return Precio;
	}
	public void setPrecio(Double precio) {
		Precio = precio;
	}
	public String getHectareas() {
		return Hectareas;
	}
	public void setHectareas(String hectareas) {
		Hectareas = hectareas;
	}
	
	@Override
    public String toString() {
        return "Inmueble{" + "inmuebleid=" + Codigo + ", tipo=" + Tipo + ", direccion="
        		+ Direccion + ", precio=" + Precio + ", hectareas=" + Hectareas + '}';
    }
	
}
