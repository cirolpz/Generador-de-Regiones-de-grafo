package tpGrafos.logica;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS {


	private boolean[] marcados; 
	private List<NProvincia> listaProv; 

	public boolean esConexo(GrafoListaVecinos g) {
		if (g == null) { 
			throw new IllegalArgumentException("Debe proporcionar un grafo válido: " + g);
		}
		if (g.size() == 0) {
			return true; 
		}
		return (alcanzables(g, g.getVertice(0)).size() == g.size()); 
		

	}

	
	public Set<NProvincia> alcanzables(GrafoListaVecinos g, NProvincia vertice) {

		Set<NProvincia> alcanzables = new HashSet<NProvincia>(); 

		inicializarBusqueda(g, vertice);

		while (listaProv.size() > 0) {
			NProvincia actual = seleccionarYMarcar(g); 
			alcanzables.add(actual); 
			agregarVecinosNoMarcados(g, actual); 
			removerMarcados(); 
		}

		return alcanzables;
	}

	private void removerMarcados() {
		listaProv.remove(0); 
	}

	
	private NProvincia seleccionarYMarcar(GrafoListaVecinos grafo) {
		NProvincia seleccionada = listaProv.get(0);
		marcados[grafo.getVertices().indexOf(seleccionada)] = true;
		return seleccionada;
	}

	private void agregarVecinosNoMarcados(GrafoListaVecinos grafo, NProvincia seleccionada) {
		for (NProvincia vecino : grafo.vecinos(seleccionada)) {
			
			if (!marcados[grafo.getVertices().indexOf(vecino)] && !listaProv.contains(vecino)) {
				listaProv.add(vecino);
			}
		}
	}

	private void inicializarBusqueda(GrafoListaVecinos grafo, NProvincia prov) {
		listaProv = new LinkedList<NProvincia>(); 
		listaProv.add(prov); 
		marcados = new boolean[grafo.size()]; 
	}
}