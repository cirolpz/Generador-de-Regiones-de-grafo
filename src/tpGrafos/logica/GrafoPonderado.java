package tpGrafos.logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrafoPonderado extends GrafoListaVecinos {
	ArrayList<AProvincia> aristas;

	
	public GrafoPonderado(int vertices, List<NProvincia> provSeleccionadas) {

		super(vertices, provSeleccionadas);
		aristas = new ArrayList<AProvincia>();
	}

	public void agregarArista(NProvincia prov) {
		AProvincia nuevaArista = new AProvincia(prov, prov, 0);
		if (!aristas.contains(nuevaArista)) {
			aristas.add(nuevaArista);
		}
	}
	public void agregarArista(NProvincia prov1, NProvincia prov2, int similitud) {
		super.agregarArista(prov1, prov2);
		 
		AProvincia nuevaArista = new AProvincia(prov1, prov2, similitud);
		if (!aristas.contains(nuevaArista)) {
			aristas.add(nuevaArista);
		}
	}

	@Override
	public void borrarArista(NProvincia prov1, NProvincia prov2) {
		super.borrarArista(prov1, prov2);

		for (int i = 0; i < aristas.size(); i++) {
			if (aristas.get(i).getProv1() == prov1 && aristas.get(i).getProv2() == prov2) {
				aristas.remove(i);
				break;
			}
		}
	}

	public int getPesoArista(NProvincia prov1, NProvincia prov2) {
		for (int i = 0; i < aristas.size(); i++) {
			if ((aristas.get(i).getProv1() == prov1 && aristas.get(i).getProv2() == prov2)
					|| (aristas.get(i).getProv1() == prov2 && aristas.get(i).getProv2() == prov1)) {
				return aristas.get(i).getPeso();
			}
		}
		
		return 0;
		
		//throw new RuntimeException("No se encontró un peso entre " + prov1.getNombre() + " y " + prov2.getNombre());
	}

	@Override
	public String toString() {
		String sb= "";
		for (int i = 0; i < aristas.size(); i++) {
			sb+=(aristas.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public ArrayList<AProvincia> getAristas() {
		return aristas;
	}


	public boolean contieneArista(NProvincia prov1, NProvincia prov2) {
		for (AProvincia arista : aristas) {
			if ((arista.getProv1().equals(prov1) && arista.getProv2().equals(prov2)) ||
					(arista.getProv1().equals(prov2) && arista.getProv2().equals(prov1))) {
				return true;
			}
		}
		return false;
	}


	public NProvincia[] getProvincias() {
		Set<NProvincia> provinciasSet = new HashSet<>();

		for (AProvincia arista : aristas) {
			provinciasSet.add(arista.getProv1());
			provinciasSet.add(arista.getProv2());
		}
		
		NProvincia[] provinciasArray = new NProvincia[provinciasSet.size()];
		provinciasArray = provinciasSet.toArray(provinciasArray);

		return provinciasArray;
	}

	public void actualizarPesoArista(NProvincia provincia, NProvincia limitrofe, int similitud) {
		
		if (existeArista(provincia, limitrofe)) {
			aristas.forEach(arista -> {
				if ((arista.getProv1() == provincia && arista.getProv2() == limitrofe) ||
						(arista.getProv1() == limitrofe && arista.getProv2() == provincia)) {
					arista.setPeso(similitud);
				}
			});
		} else {
			
			agregarArista(provincia, limitrofe, similitud);
		}
	}
}
