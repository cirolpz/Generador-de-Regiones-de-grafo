package tpGrafos.logica.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import tpGrafos.logica.GrafoListaVecinos;
import tpGrafos.logica.NProvincia;

public class GrafoListaVecinosTest {
	private GrafoListaVecinos grafo ;
	private List<NProvincia> provincias ;
	
	@Before
	public void setUp() {
		provincias = new ArrayList<NProvincia>();
		provincias.add(new NProvincia("Buenos Aires"));
		provincias.add(new NProvincia("La Pampa"));
		provincias.add(new NProvincia("Mendoza"));
		grafo = new GrafoListaVecinos (provincias.size(),provincias);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void testNProvinciasNull() {
		new GrafoListaVecinos(provincias.size(),null);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNumVerticesIncorrecto() {
		new GrafoListaVecinos(5,provincias);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAgregarVeticeNull() {
		grafo.agregarArista(provincias.get(0), null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAgregarVeticeIgual() {
		grafo.agregarArista(provincias.get(0), provincias.get(0));
	}
	@Test
	public void testAgregarVertice() {
		grafo.agregarArista(provincias.get(0), provincias.get(1));
		assertTrue(grafo.existeArista(provincias.get(0), provincias.get(1)));
		assertTrue(grafo.existeArista(provincias.get(1), provincias.get(0)));
	}
	
	@Test
	public void testBorrarVertice() {
		grafo.agregarArista(provincias.get(0), provincias.get(1));
		grafo.borrarArista(provincias.get(0), provincias.get(1));
		assertFalse(grafo.existeArista(provincias.get(0), provincias.get(1)));
		assertFalse(grafo.existeArista(provincias.get(1), provincias.get(0)));
	}
	
	@Test
	public void testNeighbors() {
		grafo.agregarArista(provincias.get(0), provincias.get(1));
		grafo.agregarArista(provincias.get(0), provincias.get(2));
		Set<NProvincia> vecinos = grafo.vecinos(provincias.get(0));
		assertTrue(vecinos.contains(provincias.get(1)));
		assertTrue(vecinos.contains(provincias.get(2)));
	}
	@Test (expected = IllegalArgumentException.class)
	public void testVerificarVerticeNull() {
		grafo.verificarProv(null);
	}
	
	@Test
	public void testIgualTamanio() {
		assertEquals(grafo.size(),3);
		
	}
}
