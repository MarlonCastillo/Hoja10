/**
*Universidad del Valle de Guatemala
*Algoritmos y Estructura de Datos
*Seccion: 10
*Andre Rodas - carnet 14395
*Yosemite Melendez - carnet: 14413
*08/11/2015
*Hoja de Trabajo 10
**/

import java.util.ArrayList;


/**
*Esta es la clase que hace al grafo y lo crea
*a partir de un arreglo de Edges. Hay varios vértices
*y distancias para llegar de un vértice a otro.
**/
public class Graph {
    
    private ArrayList distancias;
    private ArrayList vertices;
    private double[][] adyacencia;
    private String[][] recorrido;
	
	/**
	 *	 este es el constructor de objetos para crear un
	 * arreglo de distnacias y uno de vértices	
	 *
	 **/
    public Graph(){
     
        distancias = new ArrayList<Edge>();
        vertices = new ArrayList<Vertex>();
    }
	     
	/**
	* Método que se utiliza para agregar una arista
	*
	**/
    public void addVertex(String name){
        vertices.add(new Vertex(name));
    }
    
    /**
	* Método que se utiliza para remover una arista
	*
	**/
	public boolean removeEdge(String origen, String destino){
        Edge aux;
        Vertex ver1;
        Vertex ver2;
        for (int x=0;x<distancias.size();x++){
            aux=(Edge)distancias.get(x);
            ver1=aux.getOrigen();
            ver2=aux.getDestino();
            if((ver1.getNombre().equals(origen)&&(ver2.getNombre().equals(destino)))){
                distancias.remove(x);
                return true;
            }
        }
        return false;
    }
    
	/**
	* Método que se utiliza para agregar un vértice
	* @param: el origen, el destino de llegada y la distancia entre ambos
	*
	**/
    public void addEdge(String origen, String destino, double distancia) throws Exception{
        if (vertices.isEmpty()){
            throw new Exception("No hay vertices");
        }
        int indice1=0;
        int indice2=0;
        boolean ver1=false;
        boolean ver2=false;
        Vertex aux;
        for (int x=0;x<vertices.size();x++){
            aux=(Vertex) vertices.get(x);
            if (aux.getNombre().equals(origen)){
                indice1=x;
                ver1=true;
            }
            else if(aux.getNombre().equals(destino)){
                indice2=x;
                ver2=true;
            }
           
        }
        Edge arista =new Edge((Vertex)vertices.get(indice1),(Vertex)vertices.get(indice2),distancia);
        distancias.add(arista);
       
    }
	
    /**
	* Método que se utiliza para obtener la distancia entre dos vértices
	* @param origen, de dónde sale
	* @param destino, hacia donde va
	*
	**/
	 public double getdistancia(String origen, String destino){
        if(origen.equals(destino)){
            return 0.0;
        }
        Edge aux = new Edge(new Vertex(origen),new Vertex(destino),6666.6);
        
        for (int x=0;x<distancias.size();x++){
            if(aux.equals((Edge)distancias.get(x))){
                aux=(Edge)distancias.get(x);
                return aux.getdistancia();
            }
        }
        
        return 6666.6;
    } 
   
	 /**
	* Método que se utiliza para construir el grafo 
	* como matriz
	*
	**/
    public void crearMatriz(){
        adyacencia= new double[vertices.size()][vertices.size()];
        recorrido = new String[vertices.size()][vertices.size()];
       
        for (int x=0;x<vertices.size();x++){
            for(int j=0;j<vertices.size();j++){
                recorrido[x][j]=((Vertex)vertices.get(j)).getNombre();
                adyacencia[x][j]=getdistancia(((Vertex)vertices.get(x)).getNombre(),((Vertex)vertices.get(j)).getNombre());
            }
        }
    }   
    
    
	 /**
	* Método que se utiliza para mostrar matriz
	**/
    public void imprimirMatriz(){
        System.out.println("Longitud del viaje");
        String cadena="\t\t";
        for(int x=0;x<vertices.size();x++){
            cadena+=((Vertex)vertices.get(x)).getNombre()+"\t\t";
        }
        System.out.println(cadena);
       
        for (int x=0;x<vertices.size();x++){
            cadena=((Vertex)vertices.get(x)).getNombre()+"\t\t";
            for(int j=0;j<vertices.size();j++){
                cadena+=adyacencia[x][j]+"\t\t";
            }
            System.out.println(cadena);
        }
        System.out.println("Recorrido del viaje");
        cadena="\t\t";
        for(int x=0;x<vertices.size();x++){
            cadena+=((Vertex)vertices.get(x)).getNombre()+"\t\t";
        }
        System.out.println(cadena);
       
        for (int x=0;x<vertices.size();x++){
            cadena=((Vertex)vertices.get(x)).getNombre()+"\t\t";
            for(int j=0;j<vertices.size();j++){
                cadena+=recorrido[x][j]+"\t\t";
            }
            System.out.println(cadena);
        }
    }
        
    
	/**
	* Método con el cual se utiliza el algoritno de Floyd
	* con este se calcula la distancia más corta que deberá
	* recorrer
	**/
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
                        recorrido[x][j]=((Vertex)vertices.get(i)).getNombre();
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
        return "El centro del grafo es: "+((Vertex)vertices.get(centro)).getNombre();
    }
    
    
	 /**
	* Método que se utiliza para obtener el recorrido que se 
	* tiene que recorrer y la distancia a recorrer
	**/
    public String getRecorrido(String origen, String destino){
        String aux1=origen;
        String aux2=destino;
        String aux3="";
        String camino="";
        double distancia =0;
        int index1=0;
        int index2=0;
        for(int x=0;x<vertices.size();x++){
                if(aux1.equals(((Vertex)vertices.get(x)).getNombre())){
                    index1=x;
                }
                if(aux2.equals(((Vertex)vertices.get(x)).getNombre())){
                    index2=x;
                }
            }
        distancia=adyacencia[index1][index2];
        if(distancia==1000.0){
            return "No hay forma de llegar hasta la ciudad";
        }
        do{
            for(int x=0;x<vertices.size();x++){
                if(aux1.equals(((Vertex)vertices.get(x)).getNombre())){
                    index1=x;
                }
                if(aux2.equals(((Vertex)vertices.get(x)).getNombre())){
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