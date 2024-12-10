package tpGrafos.logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrafoListaVecinos { 
	private ArrayList<HashSet<NProvincia>> listaVecinos;
	List<NProvincia> vertices;

	public GrafoListaVecinos(int numVertices, List<NProvincia> provincias) {
		if (provincias == null) {
			throw new IllegalArgumentException("no hay una lista de provincias creada");
		}
		if (numVertices != provincias.size()) {
			throw new IllegalArgumentException("no hay las suficientes provincias para cada vertice del grafo");
		}
		listaVecinos = new ArrayList<HashSet<NProvincia>>();
		for (int i = 0; i < numVertices; i++) {
			listaVecinos.add(new HashSet<NProvincia>());
		}
		vertices = provincias;
	}

	public void agregarArista(NProvincia i, NProvincia j) {
		verificarProv(i);
		verificarProv(j);
		verificarDistinto(i, j);

		if (!existeArista(i, j)) {
			listaVecinos.get(vertices.indexOf(i)).add(j);
			listaVecinos.get(vertices.indexOf(j)).add(i);
		}

	}

	public void borrarArista(NProvincia i, NProvincia j) {
		verificarProv(i);
		verificarProv(j);
		verificarDistinto(i, j);

		listaVecinos.get(vertices.indexOf(i)).remove(j);
		listaVecinos.get(vertices.indexOf(j)).remove(i);
	}

	public boolean existeArista(NProvincia i, NProvincia j) {
		verificarProv(i);
		verificarProv(j);
		verificarDistinto(i, j);

		return listaVecinos.get(vertices.indexOf(i)).contains(j) && listaVecinos.get(vertices.indexOf(j)).contains(i);
	}

	public void verificarDistinto(NProvincia i, NProvincia j) {
		if (i.equals(j)) {
			throw new IllegalArgumentException("no se permiten loops; (" + i + ", " + j + ")");

		}

	}

	public void verificarProv(NProvincia i) {
		if (i == null) {
			throw new IllegalArgumentException("El vertice no puede ser null: " + i);
		}

	}

	public int size() {
		return listaVecinos.size();
	}

	public NProvincia getVertice(int i) {
		return vertices.get(i);

	}

	public List<NProvincia> getVertices() {
		return vertices;

	}
	public Set<NProvincia> vecinos (NProvincia i){
		verificarProv(i);

		return listaVecinos.get(vertices.indexOf(i));

	}



}
