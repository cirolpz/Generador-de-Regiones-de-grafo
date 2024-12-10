package tpGrafos.logica.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import tpGrafos.logica.GrafoPonderado;
import tpGrafos.logica.NProvincia;

public class GrafoPonderadoTest {

	private GrafoPonderado grafoPonderado;
	private List<NProvincia> provincias;

	@Before
	public void setUp() {
		provincias = new ArrayList<>();
		provincias.add(new NProvincia("Buenos Aires"));
		provincias.add(new NProvincia("Mendoza"));
		provincias.add(new NProvincia("La Pampa"));
		grafoPonderado = new GrafoPonderado(provincias.size(), provincias);
	}

	@Test
	public void testAgregarArista() {
		NProvincia provincia1 = provincias.get(0);
		NProvincia provincia2 = provincias.get(1);
		int peso = 10;
		grafoPonderado.agregarArista(provincia1, provincia2, peso);

		assertEquals(peso, grafoPonderado.getPesoArista(provincia1, provincia2));
	}


	@Test
	public void testGetPesoArista() {
		NProvincia provincia1 = provincias.get(0);
		NProvincia provincia2 = provincias.get(1);
		int peso = 10;
		grafoPonderado.agregarArista(provincia1, provincia2, peso);
		assertEquals(peso, grafoPonderado.getPesoArista(provincia1, provincia2));
		assertEquals(peso, grafoPonderado.getPesoArista(provincia1, provincia2));
	}


}