package tpGrafos.logica;

import java.util.Objects;

public class AProvincia {
	private NProvincia prov1;
	private NProvincia prov2;
	private int peso;

	public AProvincia(NProvincia prov1, NProvincia prov2, int peso) {
		this.prov1 = prov1;
		this.prov2 = prov2;
		this.peso = peso;
	}

	public NProvincia getProv1() {
		return prov1;
	}

	public NProvincia getProv2() {
		return prov2;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(peso, prov1, prov2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AProvincia other = (AProvincia) obj;
		return peso == other.peso && Objects.equals(prov1, other.prov1) && Objects.equals(prov2, other.prov2);
	}
	@Override
	public String toString() {
		return prov1.toString()+" "+prov2.toString()+" "+ peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;

	}

}
