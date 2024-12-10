package tpGrafos.logica;

import java.util.Objects;

public class NProvincia { 
	private String nombre;

	public NProvincia(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NProvincia other = (NProvincia) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return nombre; 
	}
}
