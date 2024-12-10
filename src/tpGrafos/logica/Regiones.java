package tpGrafos.logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Regiones {

	List<GrafoPonderado> regiones;


	public Regiones(GrafoPonderado agm, int k) {
		regiones = new ArrayList<>();

		for (int i = 0; i < k - 1; i++) { 
			AProvincia aristaMaxima = aristaMaxima(agm);

			System.out.println(aristaMaxima.toString()+"\n");
			agm.borrarArista(aristaMaxima.getProv1(), aristaMaxima.getProv2());
		}

		BFS bfs = new BFS();
		List<Set<NProvincia>> regionesBFS = new ArrayList<>(); 
		Set<NProvincia> visitados = new HashSet<>();	

		for (NProvincia vertice : agm.getVertices()) { 
			if (!visitados.contains(vertice)) { 
				Set<NProvincia> region = bfs.alcanzables(agm, vertice); 
				regionesBFS.add(region); 
				visitados.addAll(region); 
			}
		}

		
		for (Set<NProvincia> region : regionesBFS) { 
			if(region.size()==1) {
				ArrayList<NProvincia> a =new ArrayList<>(region);
				GrafoPonderado r = new GrafoPonderado(a.size(), a); 
				for (NProvincia n : region) {
					r.agregarArista(n); 

				}

				regiones.add(r);

			}else {
				GrafoPonderado regionPonderada = new GrafoPonderado(region.size(), new ArrayList<>(region)); 
				for (NProvincia prov1 : region) { 
					for (NProvincia prov2 : region) { 
						if (agm.contieneArista(prov1, prov2)&&!regionPonderada.contieneArista(prov2, prov1)) { 
							regionPonderada.agregarArista(prov1, prov2, agm.getPesoArista(prov1, prov2)); 
						}
					}
				}
				regiones.add(regionPonderada); 
			}}
	}

	
	private AProvincia aristaMaxima(GrafoPonderado agm) {
		AProvincia aristaMaxima = agm.getAristas().get(0);

		for (AProvincia arista : agm.getAristas()) {
			if (arista.getPeso() > aristaMaxima.getPeso()) {
				aristaMaxima = arista;
			}
		}
		return aristaMaxima;
	}

	public List<GrafoPonderado> getRegiones() {
		return regiones;
	}

	@Override
	public String toString() {
		String s = "";
		int i = 1;
		for (GrafoPonderado region : regiones) {
			s+= "Region : " + i +"\n";
			ArrayList<AProvincia> aristasProvincias = region.getAristas();
			HashSet<String> provincias = new HashSet<>();
			for (AProvincia arista : aristasProvincias) {
				provincias.add(arista.getProv1().toString());
				provincias.add(arista.getProv2().toString());
			}
			s+=(provincias+"\n");
			i++;
			s+=("--------------------------------------------------") +"\n";
		}
		return s.toString();
	}


}
