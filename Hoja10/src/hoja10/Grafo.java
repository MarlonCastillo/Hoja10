/*
	Cristian Daniel De Le�n Castillo, 14015.
	Carlos Javier Lima Cord�n, 14373.
	Marlon Josue Castillo Martinez, 14247.
	Fernando Sebasti�n Castillo Echeverr�a, 14102.
*/

import java.util.ArrayList;


public class Grafo {
    
    private ArrayList distancias;
    private ArrayList vertices;
    private double[][] adyacencia;
    private String[][] recorrido;
	
    public Grafo(){
     
        distancias = new ArrayList<Arista>();
        vertices = new ArrayList<Vertice>();
    }
	     

    public void addVertice(String name){
        vertices.add(new Vertice(name));
    }
    
	public boolean removeArista(String origen, String destino){
        Arista aux;
        Vertice ver1;
        Vertice ver2;
        for (int x=0;x<distancias.size();x++){
            aux=(Arista)distancias.get(x);
            ver1=aux.getOrigen();
            ver2=aux.getDestino();
            if((ver1.getNombre().equals(origen)&&(ver2.getNombre().equals(destino)))){
                distancias.remove(x);
                return true;
            }
        }
        return false;
    }
    
    public void addArista(String origen, String destino, double distancia) throws Exception{
        if (vertices.isEmpty()){
            throw new Exception("No hay vertices");
        }
        int indice1=0;
        int indice2=0;
        boolean ver1=false;
        boolean ver2=false;
        Vertice aux;
        for (int x=0;x<vertices.size();x++){
            aux=(Vertice) vertices.get(x);
            if (aux.getNombre().equals(origen)){
                indice1=x;
                ver1=true;
            }
            else if(aux.getNombre().equals(destino)){
                indice2=x;
                ver2=true;
            }
           
        }
        Arista arista =new Arista((Vertice)vertices.get(indice1),(Vertice)vertices.get(indice2),distancia);
        distancias.add(arista);
       
    }

	 public double getdistancia(String origen, String destino){
        if(origen.equals(destino)){
            return 0.0;
        }
        Arista aux = new Arista(new Vertice(origen),new Vertice(destino),9999.9);
        
        for (int x=0;x<distancias.size();x++){
            if(aux.equals((Arista)distancias.get(x))){
                aux=(Arista)distancias.get(x);
                return aux.getdistancia();
            }
        }
        
        return 9999.9;
    } 

    public void crearMatriz(){
        adyacencia= new double[vertices.size()][vertices.size()];
        recorrido = new String[vertices.size()][vertices.size()];
       
        for (int x=0;x<vertices.size();x++){
            for(int j=0;j<vertices.size();j++){
                recorrido[x][j]=((Vertice)vertices.get(j)).getNombre();
                adyacencia[x][j]=getdistancia(((Vertice)vertices.get(x)).getNombre(),((Vertice)vertices.get(j)).getNombre());
            }
        }
    }   
    
    public void imprimirMatriz(){
        System.out.println("Longitud del viaje: (Los numeros 1-6 representan las ciudades)\n");
        String cadena="       [1]      [2]      [3]      [4]      [5]      [6]\n     ------------------------------------------------------";
        System.out.println(cadena);
       
        for (int x=0;x<vertices.size();x++){
            cadena=("[" + x + "] | ");
            for(int j=0;j<vertices.size();j++){
                cadena+=""+adyacencia[x][j]+"";
				double var = adyacencia[x][j];
				if(var < 10.0){
					cadena+="    | ";
				}else if(var < 100.0){
					cadena+="   | ";
				}else if(var < 1000.0){
					cadena+="  | ";
				}else if(var >= 1000.0){
					cadena+=" | ";
				}					
            }
            System.out.println(cadena);
        }
        System.out.println("\nRecorrido del viaje");
        cadena="    ";
        for(int x=0;x<vertices.size();x++){
            cadena+=((Vertice)vertices.get(x)).getNombre()+" ";
        }
        System.out.println(cadena);
       
        for (int x=0;x<vertices.size();x++){
            cadena=((Vertice)vertices.get(x)).getNombre()+" ";
            for(int j=0;j<vertices.size();j++){
                cadena+=recorrido[x][j]+" ";
            }
            System.out.println(cadena);
        }
    }
        
   
    public void algoritmoFloyd(){
       
        double val1;
        double val2;
        for(int i=0;i<vertices.size();i++){
           
            for(int x=0;x<vertices.size();x++){
                for(int j=0;j<vertices.size();j++){
                    val1=adyacencia[x][j];
                    val2=adyacencia[x][i]+adyacencia[i][j];
                    if (val2<val1){
                        adyacencia[x][j]=val2;
                        recorrido[x][j]=((Vertice)vertices.get(i)).getNombre();
                    }
                }
            }
        }
    }
    
    
    public String getCenter(){
        double[] excen = new double[vertices.size()];
        double val;
        int centro=0;
        for (int x=0;x<vertices.size();x++){
            val=0.0;
            for (int j=0;j<vertices.size();j++){
                    if(val<adyacencia[j][x]){
                        val=adyacencia[j][x];
                    }
            }
            excen[x]=val;
        }
        val=5000000000.0;
        for (int x=0;x<vertices.size();x++){
            if(val>excen[x]){
                centro=x;
            }
        }
        return "El centro del grafo1 es: "+((Vertice)vertices.get(centro)).getNombre();
    }
    
    public String getRecorrido(String origen, String destino){
        String aux1=origen;
        String aux2=destino;
        String aux3="";
        String camino="";
        double distancia =0;
        int index1=0;
        int index2=0;
        for(int x=0;x<vertices.size();x++){
                if(aux1.equals(((Vertice)vertices.get(x)).getNombre())){
                    index1=x;
                }
                if(aux2.equals(((Vertice)vertices.get(x)).getNombre())){
                    index2=x;
                }
            }
        distancia=adyacencia[index1][index2];
        if(distancia==1000.0){
            return "No hay forma de llegar hasta la ciudad";
        }
        do{
            for(int x=0;x<vertices.size();x++){
                if(aux1.equals(((Vertice)vertices.get(x)).getNombre())){
                    index1=x;
                }
                if(aux2.equals(((Vertice)vertices.get(x)).getNombre())){
                    index2=x;
                }
            }
            camino+="-"+recorrido[index1][index2];
            aux3=aux2;
            aux2=recorrido[index1][index2];
        }
        while(!(aux3.equals(recorrido[index1][index2])));
        StringBuffer aux = new StringBuffer(camino);
        aux.deleteCharAt(aux.length()-1);
        aux.reverse();
        return "El Recorrido es: "+aux+" y la distancia hacia la ciudad es de "+distancia+" KM";
    }
   
}