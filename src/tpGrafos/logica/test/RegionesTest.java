package tpGrafos.logica.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import tpGrafos.logica.Prim;
import tpGrafos.logica.Regiones;

import tpGrafos.logica.BFS;
import tpGrafos.logica.GrafoPonderado;
import tpGrafos.logica.NProvincia;

public class RegionesTest {


    private GrafoPonderado grafoConexo;

    @Before
    public void setUp() {
        grafoConexo = crearGrafoConexo();
    }

    @Test
    public void testRegiones() {
        Prim prim = new Prim();
        GrafoPonderado agm = prim.recorridoPrim(grafoConexo);

        int k = 3; 
        Regiones regiones = new Regiones(agm, k);

        List<GrafoPonderado> regionesList = regiones.getRegiones();
        assertEquals(k, regionesList.size());

        
        for (GrafoPonderado region : regionesList) {
            assertTrue(esConexo(region));
        }
    }

    @Test
    public void testGetRegiones() {
        Prim prim = new Prim();
        GrafoPonderado agm = prim.recorridoPrim(grafoConexo);

        int k = 2;
        Regiones regiones = new Regiones(agm, k);

        List<GrafoPonderado> regionesList = regiones.getRegiones();
        assertEquals(k, regionesList.size());

  
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

    private boolean esConexo(GrafoPonderado grafo) {
        return new BFS().esConexo(grafo);
    }
}
