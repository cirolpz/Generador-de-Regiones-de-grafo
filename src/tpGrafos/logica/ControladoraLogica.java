package tpGrafos.logica;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

public class ControladoraLogica {
	GrafoPonderado grafoPonderado;
	Regiones regiones;
	private Mapa mapa;

	public ControladoraLogica() {
		mapa = new Mapa();
		mapa.crearGrafoProvincias();
		grafoPonderado = new GrafoPonderado(mapa.getProvincias().size(), mapa.getGrafoVecinos().getVertices());
	}

		public void cargarGrafoPonderado() {
			
			GrafoListaVecinos gListaVec = mapa.getGrafoVecinos();
			
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(1-1), gListaVec.getVertices().get(2-1), 10); //jujuy
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(2-1), gListaVec.getVertices().get(3-1), 2); //salta
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(2-1), gListaVec.getVertices().get(4-1), 5);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(2-1), gListaVec.getVertices().get(5-1), 8);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(2-1), gListaVec.getVertices().get(6-1), 15);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(2-1), gListaVec.getVertices().get(7-1), 6);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(3-1), gListaVec.getVertices().get(7-1), 22);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(4-1), gListaVec.getVertices().get(5-1), 1); 
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(4-1), gListaVec.getVertices().get(6-1), 6);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(4-1), gListaVec.getVertices().get(10-1), 9);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(5-1), gListaVec.getVertices().get(6-1), 32);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(6-1), gListaVec.getVertices().get(7-1), 44);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(6-1), gListaVec.getVertices().get(11-1), 90); 
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(6-1), gListaVec.getVertices().get(13-1), 3);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(7-1), gListaVec.getVertices().get(9-1), 5);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(7-1), gListaVec.getVertices().get(11-1), 132);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(8-1), gListaVec.getVertices().get(9-1), 2);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(9-1), gListaVec.getVertices().get(11-1), 7);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(9-1), gListaVec.getVertices().get(14-1), 30);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(10-1), gListaVec.getVertices().get(12-1), 45);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(10-1), gListaVec.getVertices().get(13-1), 16);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(10-1), gListaVec.getVertices().get(16-1), 5);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(11-1), gListaVec.getVertices().get(13-1),19); 
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(11-1), gListaVec.getVertices().get(18-1), 11);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(12-1), gListaVec.getVertices().get(15-1), 22);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(12-1), gListaVec.getVertices().get(16-1), 39);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(13-1), gListaVec.getVertices().get(16-1), 7);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(13-1), gListaVec.getVertices().get(17-1), 9); 
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(13-1), gListaVec.getVertices().get(18-1), 15);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(14-1), gListaVec.getVertices().get(18-1), 10);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(15-1), gListaVec.getVertices().get(16-1), 12); 
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(15-1), gListaVec.getVertices().get(17-1), 20);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(15-1), gListaVec.getVertices().get(19-1), 12);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(16-1), gListaVec.getVertices().get(17-1), 10);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(17-1), gListaVec.getVertices().get(18-1), 4);
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(17-1), gListaVec.getVertices().get(20-1), 3);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(18-1), gListaVec.getVertices().get(20-1), 8);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(19-1), gListaVec.getVertices().get(20-1), 39); 
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(20-1), gListaVec.getVertices().get(21-1), 450);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(21-1), gListaVec.getVertices().get(22-1), 23);
	
			grafoPonderado.actualizarPesoArista(gListaVec.getVertices().get(22-1), gListaVec.getVertices().get(23-1), 11);
		}

	public ArrayList<AProvincia> getGrafoPonderado() {
		return grafoPonderado.getAristas();
	}

	public void actualizarSimilitud(NProvincia provincia, NProvincia limitrofe, int similitud) {
		grafoPonderado.actualizarPesoArista(provincia, limitrofe, similitud);
	}

	public List<NProvincia> getProvincias() {
		return mapa.getProvincias();
	}

	public List<NProvincia> getProvinciasLimitrofes(NProvincia provincia) {
		return mapa.getProvinciasLimitrofes(provincia);
	}

	public void crearRegiones(int cantRegiones) {
		Prim prim = new Prim();
		GrafoPonderado AGM =  prim.recorridoPrim(grafoPonderado);
		regiones = new Regiones(AGM, cantRegiones); 
	}

	public String regionString() {
		return regiones.toString();
	}
	
	public void agregarMarcadores(JMapViewer mapViewer) {
		mapa.agregarMarcadores(mapViewer);
	}
	public void conectarProvincias(String provinciaOrigen, String provinciaDestino, JMapViewer mapViewer) {
		mapa.conectarProvincias(provinciaOrigen, provinciaDestino, mapViewer);
	}
	public void conectarRegiones(int k, JMapViewer mapViewer) {
		crearRegiones(k);
		mapa.conectarRegiones(regiones, mapViewer);
	}
	public Map<String, Coordinate> cargarCoordenadasProvincias(){
		return mapa.cargarCoordenadasProvincias();
	}

	public Integer obtenerSimilitud(NProvincia provincia, NProvincia limitrofe) {
		return grafoPonderado.getPesoArista(provincia, limitrofe);
	}
	
	public boolean grafoEsConexo() { //Se agrego
		BFS grafoConexo = new BFS();
		return grafoConexo.esConexo(grafoPonderado);
	}
}

