package tpGrafos.logica;

import java.util.Set;
import java.util.HashSet;

public class Prim {
	private Set<NProvincia> provinciasMarcadas;

	public GrafoPonderado recorridoPrim(GrafoPonderado grafoCompleto) {
		BFS bfs = new BFS();
		if (!bfs.esConexo(grafoCompleto)) {
			throw new IllegalArgumentException("El grafo no es conexo.");
		}

		GrafoPonderado grafoMST = new GrafoPonderado(grafoCompleto.size(), grafoCompleto.getVertices());
		provinciasMarcadas = new HashSet<>();
		provinciasMarcadas.add(grafoCompleto.getVertice(0));

		while (provinciasMarcadas.size() < grafoCompleto.size()&& provinciasMarcadas.size()!=0) {
			AProvincia aristaMinima = encontrarSimilitudMinima(grafoCompleto, grafoMST);
			NProvincia prov1 = aristaMinima.getProv1();
			NProvincia prov2 = aristaMinima.getProv2();

			grafoMST.agregarArista(prov1, prov2, aristaMinima.getPeso());
			provinciasMarcadas.add(prov1);
			provinciasMarcadas.add(prov2);
		}

		return grafoMST;
	}

	private AProvincia encontrarSimilitudMinima(GrafoPonderado grafoCompleto, GrafoPonderado grafoMST) {
		
		AProvincia aristaMinima = null;
		int pesoMinimo =  Integer.MAX_VALUE;


		for (NProvincia prov : provinciasMarcadas) {
			Set<NProvincia> vecinos = grafoCompleto.vecinos(prov);
			for (NProvincia vecino : vecinos) {
				if (!estaEnArbolExpansionMinima(vecino) && !grafoMST.existeArista(prov, vecino)) {
					int peso = grafoCompleto.getPesoArista(prov, vecino);
					if (aristaMinima == null || peso < pesoMinimo) {
						pesoMinimo = peso;
						aristaMinima = new AProvincia(prov, vecino, peso);
					}
				}
			}
		}
		return aristaMinima;
	}

	private boolean estaEnArbolExpansionMinima(NProvincia prov) {
		return provinciasMarcadas.contains(prov);
	}
}
