package tpGrafos.logica.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import tpGrafos.logica.GrafoPonderado;
import tpGrafos.logica.NProvincia;
import tpGrafos.logica.Prim;

public class PrimTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void nonConnectedGraphTest() {
		GrafoPonderado grafo = crearGrafoNoConexo();
		Prim prim = new Prim();
		prim.recorridoPrim(grafo);
	}
	@Test
	public void testCaminoFeliz() {
		GrafoPonderado g = crearGrafoConexo();
		Prim prim = new Prim();
		GrafoPonderado agm = prim.recorridoPrim(g);
		boolean acum = true;
		acum = acum && agm.existeArista(agm.getVertice(0), agm.getVertice(1));
		acum = acum && agm.existeArista(agm.getVertice(1), agm.getVertice(2));
		acum = acum && agm.existeArista(agm.getVertice(2), agm.getVertice(4));
		acum = acum && agm.existeArista(agm.getVertice(4), agm.getVertice(3));
		acum = acum && agm.existeArista(agm.getVertice(4), agm.getVertice(5));
		assertTrue(acum);
	}

	private GrafoPonderado crearGrafoConexo() {
		GrafoPonderado grafo = new GrafoPonderado(6, crearListaProvincias());
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(1), 1);
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(2), 100);
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(2), 3);
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(3), 100);
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(5), 100);
		grafo.agregarArista(grafo.getVertice(2), grafo.getVertice(4), 34);
		grafo.agregarArista(grafo.getVertice(4), grafo.getVertice(3), 21);
		grafo.agregarArista(grafo.getVertice(4), grafo.getVertice(5), 45);
		return grafo;
	}

	private GrafoPonderado crearGrafoNoConexo() {
		GrafoPonderado grafo = new GrafoPonderado(6,crearListaProvincias());
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(1),23);
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(2),100);
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(2),93);
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(3),12);
		grafo.agregarArista(grafo.getVertice(2), grafo.getVertice(4),14);
		grafo.agregarArista(grafo.getVertice(3), grafo.getVertice(4),27);
		return grafo;
	}

	private List<NProvincia> crearListaProvincias() {
		List<NProvincia> provincias = new ArrayList<>();
		provincias.add(new NProvincia("Buenos Aires"));
		provincias.add(new NProvincia("Mendoza"));
		provincias.add(new NProvincia("La Pampa"));
		provincias.add(new NProvincia("Catamarca"));
		provincias.add(new NProvincia("Santa Fe"));
		provincias.add(new NProvincia("Entre Rios"));
		
		return provincias;
	}
}
