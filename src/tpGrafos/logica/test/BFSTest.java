package tpGrafos.logica.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpGrafos.logica.BFS;
import tpGrafos.logica.GrafoListaVecinos;
import tpGrafos.logica.NProvincia;

public class BFSTest {
	private BFS bfs;
	
	@Before
	public void setUp() {
		bfs = new BFS();
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGrafoNull() {
		GrafoListaVecinos grafo = null;
		assertTrue(bfs.esConexo(grafo));
		
	}
	@Test
	public void testGrafoVacio() {
		List<NProvincia> lista = new ArrayList<>();
		GrafoListaVecinos grafo = new GrafoListaVecinos(0, lista);
		assertTrue(bfs.esConexo(grafo));
	}
	
	@Test
	public void testGrafoUnVertice() {
		List<NProvincia> lista = new ArrayList<>();
		NProvincia prov = new NProvincia("Buenos Aires");
		lista.add(prov);
		GrafoListaVecinos grafo = new GrafoListaVecinos(1, lista);
		assertTrue(bfs.esConexo(grafo));
	}
	@Test
	public void testGrafoDosVerticesAislados() {
		List<NProvincia> lista = new ArrayList<>();
		NProvincia prov = new NProvincia("Buenos Aires");
		NProvincia prov2 = new NProvincia("La Pampa");
		lista.add(prov);
		lista.add(prov2);
		GrafoListaVecinos grafo = new GrafoListaVecinos(2, lista);
		assertFalse(bfs.esConexo(grafo));
	}
	@Test
	public void testGrafoDosVerticesConexo() {
		List<NProvincia> lista = new ArrayList<>();
		NProvincia prov = new NProvincia("Buenos Aires");
		NProvincia prov2 = new NProvincia("La Pampa");
		lista.add(prov);
		lista.add(prov2);
		GrafoListaVecinos grafo = new GrafoListaVecinos(2, lista);
		grafo.agregarArista(prov, prov2);
		assertTrue(bfs.esConexo(grafo));
	}
	@Test
	public void testGrafoNoConexo() {
		GrafoListaVecinos grafo = crearGrafoNoConexo();
		assertFalse(bfs.esConexo(grafo));
	}
	@Test
	public void testGrafoConexo() {
		GrafoListaVecinos grafo = crearGrafoConexo();
		assertTrue(bfs.esConexo(grafo));
	}

	private GrafoListaVecinos crearGrafoConexo() {
		GrafoListaVecinos grafo = new GrafoListaVecinos(6,crearListaProvincias());
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(1));
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(2));
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(2));
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(3));
		grafo.agregarArista(grafo.getVertice(2), grafo.getVertice(4));
		grafo.agregarArista(grafo.getVertice(3), grafo.getVertice(4));
		grafo.agregarArista(grafo.getVertice(4), grafo.getVertice(5));
		return grafo;
		
	}

	private GrafoListaVecinos crearGrafoNoConexo() {
		GrafoListaVecinos grafo = new GrafoListaVecinos(6,crearListaProvincias());
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(1));
		grafo.agregarArista(grafo.getVertice(0), grafo.getVertice(2));
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(2));
		grafo.agregarArista(grafo.getVertice(1), grafo.getVertice(3));
		grafo.agregarArista(grafo.getVertice(2), grafo.getVertice(4));
		grafo.agregarArista(grafo.getVertice(3), grafo.getVertice(4));
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
