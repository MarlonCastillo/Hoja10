/*
	Cristian Daniel De León Castillo, 14015.
	Carlos Javier Lima Cordón, 14373.
	Marlon Josue Castillo Martinez, 14247.
	Fernando Sebastián Castillo Echeverría, 14102.
*/

public class Arista {
    
    private Vertice origen;			// de donde parte
    private Vertice destino;		// hacia donde va
    private double distancia;

    public Arista(Vertice origen, Vertice destino, double distancia){
        this.origen=origen;
        this.destino=destino;
        this.distancia=distancia;
    }
    
	public void setOrigen(Vertice origen) {
        this.origen = origen;
    }
	
	  public Vertice getOrigen() {
        return origen;
    }

	
	 public void setDestino(Vertice destino) {
        this.destino = destino;
    }
    
    public Vertice getDestino() {
        return destino;
    }
	
	  public boolean equals(Arista ar){
        if((origen.getNombre().equals(ar.getOrigen().getNombre()))&&(destino.getNombre().equals(ar.getDestino().getNombre()))){
            return true;
        }
        return false;
    }
	
    public void setdistancia(float distancia) {
        this.distancia = distancia;
    }
	
	  public double getdistancia() {
        return distancia;
    }
   
}