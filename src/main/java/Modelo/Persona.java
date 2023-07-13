package Modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Persona {

		@Id
		@GeneratedValue
		@Column(name="per_codigo")
		int codigo;
		@Column(name="per_cedula")
		String Cedula;
		@Column(name="per_nombre")
		String Nombre;
		@Column(name="per_apellido")
		String Apellido;
		@Column(name="per_direccion")
		String Direccion;
		@Column(name="per_telefono")
		String Telefono;
		
		@OneToMany(cascade= CascadeType.ALL)
		@JoinColumn(name="per_codigo")
		private List<Inmueble> inmuebles;
		
		public int getId() {
			return codigo;
		}
		public void setId(int codigo) {
			this.codigo = codigo;
		}
		public String getCedula() {
			return Cedula;
		}
		public void setCedula(String cedula) {
			Cedula = cedula;
		}
		public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public String getApellido() {
			return Apellido;
		}
		public void setApellido(String apellido) {
			Apellido = apellido;
		}
		public String getDireccion() {
			return Direccion;
		}
		public void setDireccion(String direccion) {
			Direccion = direccion;
		}
		public String getTelefono() {
			return Telefono;
		}
		public void setTelefono(String telefono) {
			Telefono = telefono;
		}
		
		public List<Inmueble> getInmueble() {
			return inmuebles;
		}

		public void setInmueble(List<Inmueble> inmuebles) {
			this.inmuebles = inmuebles;
		}
		
		
		public void addInmueble(Inmueble inmueble) {
			if(inmuebles==null) {
				inmuebles = new ArrayList<Inmueble>();
			}
			inmuebles.add(inmueble);
		}
		
		@Override
	    public String toString() {
	        return "Persona{" + "personaid=" + codigo + ", cedula=" + Cedula + ", nombre=" + Nombre + ", apellido=" + Apellido + 
	        		", direccion=" + Direccion + ", telefono=" + Telefono + '}';
	    }
		
}
