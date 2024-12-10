package tpGrafos.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

public class Mapa {
	private Map<String, Coordinate> coordenadasProvincias;
	private List<NProvincia> provincias;
	private GrafoListaVecinos grafoVecinos;

	
	public void agregarMarcadores(JMapViewer mapViewer) {
		for(Map.Entry<String, Coordinate> entry : coordenadasProvincias.entrySet()) {
			mapViewer.addMapMarker(new MapMarkerDot(entry.getKey(), entry.getValue()));
		}
	}

	public void conectarProvincias(String provinciaOrigen, String provinciaDestino, JMapViewer mapViewer) {
		Coordinate coordOrigen = coordenadasProvincias.get(provinciaOrigen);
		Coordinate coordDestino = coordenadasProvincias.get(provinciaDestino);

		List<Coordinate> route = new ArrayList<Coordinate>(Arrays.asList(coordOrigen, coordDestino, coordDestino));
		mapViewer.addMapPolygon(new MapPolygonImpl(route));
	}
	public void conectarRegiones(Regiones regiones, JMapViewer mapViewer) {
		for(GrafoPonderado region : regiones.getRegiones()) {
			for(AProvincia arista : region.getAristas()) {
				conectarProvincias(arista.getProv1().getNombre(), arista.getProv2().getNombre(), mapViewer);
			}
		}
	}
	public Map<String, Coordinate> cargarCoordenadasProvincias() {
		coordenadasProvincias = new HashMap<>();
		coordenadasProvincias.put("Jujuy",new Coordinate(-23.3199750616583,-65.764423919292));
		coordenadasProvincias.put("Salta",new Coordinate(-24.2992838957201,-64.8141586574346));
		coordenadasProvincias.put("Formosa", new Coordinate(-24.8950871761481,-59.9321901121647));
		coordenadasProvincias.put("Catamarca", new Coordinate(-27.3359537960762,-66.9478972451295));
		coordenadasProvincias.put("Tucumán", new Coordinate(-26.948283501723,-65.3647655803683));
		coordenadasProvincias.put("Santiago del Estero",new Coordinate(-27.7834318817521,-63.2526268856462));
		coordenadasProvincias.put("Chaco", new Coordinate(-26.3869871835867,-60.765116260356));
		coordenadasProvincias.put("Misiones",new Coordinate(-26.8753025989034,-54.6515705627219));
		coordenadasProvincias.put("Corrientes",new Coordinate(-28.7742044813623,-57.8010818603331));
		coordenadasProvincias.put("La Rioja", new Coordinate(-29.6849372775783,-67.1817575814487));
		coordenadasProvincias.put("Santa Fe", new Coordinate(-30.7088227091528,-60.9506872769706));
		coordenadasProvincias.put("San Juan",new Coordinate(-30.8656607015096,-68.8881597071776));
		coordenadasProvincias.put("Córdoba",new Coordinate(-32.1447993873859,-63.801973466573));
		coordenadasProvincias.put("Entre Ríos",new Coordinate(-32.0589278938558,-59.201262616496));
		coordenadasProvincias.put("Mendoza",new Coordinate(-34.6303887067166,-68.5829456019867));
		coordenadasProvincias.put("San Luis", new Coordinate(-33.7611035381154,-66.0252312714021));
		coordenadasProvincias.put("La Pampa",new Coordinate(-37.1350652212898,-65.4476439990213));
		coordenadasProvincias.put("Buenos Aires",new Coordinate(-36.6773920760823,-60.5584771084959));
		coordenadasProvincias.put("Neuquén", new Coordinate(-38.6419828626673,-70.1198972237318));
		coordenadasProvincias.put("Río Negro",new Coordinate(-40.4050796306359,-67.2296757996036));
		coordenadasProvincias.put("Chubut",new Coordinate(-43.7886271389083,-68.5267363339818));
		coordenadasProvincias.put("Santa Cruz",new Coordinate(-48.8155471830527,-69.9557619144913));
		coordenadasProvincias.put("Tierra del Fuego",new Coordinate(-54.3211345211545,-67.7428606764691));

		return coordenadasProvincias;
	}

	public void crearGrafoProvincias() {
		provincias = crearListaProvincias();
		grafoVecinos = new  GrafoListaVecinos(23, provincias);
		completarAristas(grafoVecinos);
	}
	private void completarAristas(GrafoListaVecinos grafo3) {
		grafo3.agregarArista(provincias.get(1-1), provincias.get(2-1)); //jujuy

		grafo3.agregarArista(provincias.get(2-1), provincias.get(3-1)); //salta
		grafo3.agregarArista(provincias.get(2-1), provincias.get(4-1));
		grafo3.agregarArista(provincias.get(2-1), provincias.get(5-1));
		grafo3.agregarArista(provincias.get(2-1), provincias.get(6-1));
		grafo3.agregarArista(provincias.get(2-1), provincias.get(7-1));

		grafo3.agregarArista(provincias.get(3-1), provincias.get(7-1));

		grafo3.agregarArista(provincias.get(4-1), provincias.get(5-1)); 
		grafo3.agregarArista(provincias.get(4-1), provincias.get(6-1));
		grafo3.agregarArista(provincias.get(4-1), provincias.get(10-1));

		grafo3.agregarArista(provincias.get(5-1), provincias.get(6-1));

		grafo3.agregarArista(provincias.get(6-1),provincias.get(7-1));
		grafo3.agregarArista(provincias.get(6-1),provincias.get(11-1)); 
		grafo3.agregarArista(provincias.get(6-1), provincias.get(13-1));

		grafo3.agregarArista(provincias.get(7-1), provincias.get(9-1));
		grafo3.agregarArista(provincias.get(7-1), provincias.get(11-1));

		grafo3.agregarArista(provincias.get(8-1),provincias.get(9-1));

		grafo3.agregarArista(provincias.get(9-1),provincias.get(11-1));
		grafo3.agregarArista(provincias.get(9-1), provincias.get(14-1));

		grafo3.agregarArista(provincias.get(10-1),provincias.get(12-1));
		grafo3.agregarArista(provincias.get(10-1),provincias.get(13-1));
		grafo3.agregarArista(provincias.get(10-1),provincias.get(16-1));

		grafo3.agregarArista(provincias.get(11-1), provincias.get(13-1)); 
		grafo3.agregarArista(provincias.get(11-1), provincias.get(18-1));

		grafo3.agregarArista(provincias.get(12-1), provincias.get(15-1));
		grafo3.agregarArista(provincias.get(12-1),provincias.get(16-1));

		grafo3.agregarArista(provincias.get(13-1), provincias.get(16-1));
		grafo3.agregarArista(provincias.get(13-1), provincias.get(17-1)); 
		grafo3.agregarArista(provincias.get(13-1), provincias.get(18-1));

		grafo3.agregarArista(provincias.get(14-1), provincias.get(18-1));
		grafo3.agregarArista(provincias.get(14-1), provincias.get(11-1));

		grafo3.agregarArista(provincias.get(15-1), provincias.get(16-1)); 
		grafo3.agregarArista(provincias.get(15-1), provincias.get(17-1));
		grafo3.agregarArista(provincias.get(15-1), provincias.get(19-1));

		grafo3.agregarArista(provincias.get(16-1), provincias.get(17-1));

		grafo3.agregarArista(provincias.get(17-1),provincias.get(18-1));
		grafo3.agregarArista(provincias.get(17-1),provincias.get(20-1));

		grafo3.agregarArista(provincias.get(18-1),provincias.get(20-1));

		grafo3.agregarArista(provincias.get(19-1), provincias.get(20-1)); 

		grafo3.agregarArista(provincias.get(20-1), provincias.get(21-1));

		grafo3.agregarArista(provincias.get(21-1),provincias.get(22-1));

		grafo3.agregarArista(provincias.get(22-1), provincias.get(23-1));
	}

	private List<NProvincia> crearListaProvincias() {
		List <NProvincia> provincias = new ArrayList<>();
		provincias.add(new NProvincia("Jujuy"));
		provincias.add(new NProvincia("Salta"));
		provincias.add(new NProvincia("Formosa"));
		provincias.add(new NProvincia("Catamarca"));
		provincias.add(new NProvincia("Tucumán"));
		provincias.add(new NProvincia("Santiago del Estero"));
		provincias.add(new NProvincia("Chaco"));
		provincias.add(new NProvincia("Misiones"));
		provincias.add(new NProvincia("Corrientes"));
		provincias.add(new NProvincia("La Rioja"));
		provincias.add(new NProvincia("Santa Fe"));
		provincias.add(new NProvincia("San Juan"));
		provincias.add(new NProvincia("Córdoba"));
		provincias.add(new NProvincia("Entre Ríos"));
		provincias.add(new NProvincia("Mendoza"));
		provincias.add(new NProvincia("San Luis"));
		provincias.add(new NProvincia("La Pampa"));
		provincias.add(new NProvincia("Buenos Aires"));
		provincias.add(new NProvincia("Neuquén"));
		provincias.add(new NProvincia("Río Negro"));
		provincias.add(new NProvincia("Chubut"));
		provincias.add(new NProvincia("Santa Cruz"));
		provincias.add(new NProvincia("Tierra del Fuego"));
		return provincias;
	}

	public List<NProvincia> getProvinciasLimitrofes(NProvincia provincia) {
		List<NProvincia> limitrofes = new ArrayList<>();
		Set<NProvincia> vecinos = grafoVecinos.vecinos(provincia);
		for (NProvincia vecino : vecinos) {
			limitrofes.add(vecino);
		}
		return limitrofes;
	}

	public List<NProvincia> getProvincias() {
		return provincias;
	}

	public GrafoListaVecinos getGrafoVecinos() {
		return grafoVecinos;
	}


}
