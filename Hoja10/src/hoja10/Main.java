/*
	Cristian Daniel De León Castillo, 14015.
	Carlos Javier Lima Cordón, 14373.
	Marlon Josue Castillo Martinez, 14247.
	Fernando Sebastián Castillo Echeverría, 14102.
*/


import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
 
        Grafo grafo1 = new Grafo();	//Se instancia el grafo
		String[] ciudad;
		String linea, ciudad1, ciudad2;
		int i = 0;
        
		System.out.println("\n                           TRIBUNAL SUPREMO ELECTORAL\n                         ELECCIONES 2015 SEGUNDA VUELTA\n");	//Título
		
		
		try{
			BufferedReader file = new BufferedReader(new FileReader("guategrafo.txt"));	//Se lee el archivo guategrafo.txt
            while ((linea = file.readLine()) != null)   {
               
            	ciudad = linea.split(", ");
            	
            	// Dice la cantidad de ciudades que existen
                if(i == 0){
                    System.out.println("Las ciudades son:");
                    for (String cadena : ciudad) {
                        System.out.print("  " + String.valueOf(i+1) + ") " + cadena + "\n");
                        grafo1.addVertice(cadena);
						i++;
                    }
                    //Muestra las rutas que se pueden tomar
                    System.out.println("\nLas rutas disponibles son:\n"); 
                }
                else if(ciudad.length == 3){
                    grafo1.addArista(ciudad[0], ciudad[1], Double.parseDouble(ciudad[2]));
                    System.out.println("     "+ciudad[0]+" --------> "+ciudad[1]+"    "+ciudad[2]+"km");
                    i++;
                }  
            }
            file.close();
        }catch (Exception e){
            System.out.println("Error");
        }

        String opcion = "1";
		
        while(!opcion.equals("4")){
            grafo1.crearMatriz();
            grafo1.algoritmoFloyd();
            
            //Menu de opciones que se pueden seleccionar
            System.out.println("\n1. Ruta mas corta entre ciudades\n" + "2. Centro del grafo\n" + "3. Modificar rutas\n" + "4. Salir");     
            System.out.println("\nIngrese la opcion que desea: ");
            Scanner input = new Scanner(System.in);
			opcion = input.nextLine();
            
			//Opci�n que selecciona el usuario
            switch(opcion){
                case "1": 
                	System.out.println("Ingrese el numero de la ciudad origen:");
                    ciudad1 = input.nextLine();
                    
                    System.out.println("Ingrese el numero de la ciudad de destino:");
                    ciudad2 = input.nextLine();
					
					switch(ciudad1){
						case "1":
							ciudad1 = "Guatemala     ";
							break;
						case "2":
							ciudad1 = "Coban         ";
							break;
						case "3":
							ciudad1 = "Peten         ";
							break;
						case "4":
							ciudad1 = "Chiquimula    ";
							break;
						case "5":
							ciudad1 = "Santa Rosa    ";
							break;
						case "6":
							ciudad1 = "Quetzaltenango";
							break;
						default:
							System.out.println("Error, ha ingresado incorrectamente.");
							break;
					}
					
					switch(ciudad2){
						case "1":
							ciudad2 = "Guatemala     ";
							break;
						case "2":
							ciudad2 = "Coban         ";
							break;
						case "3":
							ciudad2 = "Peten         ";
							break;
						case "4":
							ciudad2 = "Chiquimula    ";
							break;
						case "5":
							ciudad2 = "Santa Rosa    ";
							break;
						case "6":
							ciudad2 = "Quetzaltenango";
							break;
						default:
							System.out.println("Error, ha ingresado incorrectamente.");
							break;
					}
                     
                    double peso = grafo1.getdistancia(ciudad1, ciudad2);
                    
                    //Mensaje de ruta que no existe
                    if(peso == -1)
                        System.out.println("No existe ruta entre las ciudades o ha ingresado una ciudad no existente");
                    else
                    	System.out.println("La distancia entre las ciudades es de: " + peso);
                    break;
                    
                case "2":
                	System.out.println(grafo1.getCenter());
                    break;
                   
                case "3":

                    String opcion2 = "0";

                    while(!opcion2.equals("3")){
                       //Se puede crear una interrupci�n entre ciudades
                    	System.out.println("1. Interrumpir dos ciudades\n" + "2. Conectar dos ciudades\n" + "3. Salir");          
                        
                    	System.out.println("Ingrese la opcion que desea:");
                    	opcion2 = input.nextLine();
                        switch(opcion2){
                            case "1":                 
                                System.out.println("Ingrese el numero de la ciudad origen:");
                                ciudad1 = input.nextLine();
                                
                                System.out.println("Ingrese el numero de la ciudad origen:");
                                ciudad2  = input.nextLine();
								
								switch(ciudad1){
									case "1":
										ciudad1 = "Guatemala     ";
										break;
									case "2":
										ciudad1 = "Coban         ";
										break;
									case "3":
										ciudad1 = "Peten         ";
										break;
									case "4":
										ciudad1 = "Chiquimula    ";
										break;
									case "5":
										ciudad1 = "Santa Rosa    ";
										break;
									case "6":
										ciudad1 = "Quetzaltenango";
										break;
									default:
										System.out.println("Error, ha ingresado incorrectamente.");
										break;
								}
								
								switch(ciudad2){
									case "1":
										ciudad2 = "Guatemala     ";
										break;
									case "2":
										ciudad2 = "Coban         ";
										break;
									case "3":
										ciudad2 = "Peten         ";
										break;
									case "4":
										ciudad2 = "Chiquimula    ";
										break;
									case "5":
										ciudad2 = "Santa Rosa    ";
										break;
									case "6":
										ciudad2 = "Quetzaltenango";
										break;
									default:
										System.out.println("Error, ha ingresado incorrectamente.");
										break;
								}
                                
                                if(!grafo1.removeArista(ciudad1, ciudad2)){
                                	System.out.println("No se pudo crear la interrupcion.");
                                }else{
                                	System.out.println("Se creo la interrupcion exitosamente");
                                }
                               
                                break;
                            case "2": //Crear conexion 
                            	
                            	System.out.println("Ingrese el numero de la ciudad origen:");
                                ciudad1 = input.nextLine();
                                
                                System.out.println("Ingrese el numero de la ciudad origen:");
                                ciudad2  = input.nextLine();
								
								switch(ciudad1){
									case "1":
										ciudad1 = "Guatemala     ";
										break;
									case "2":
										ciudad1 = "Coban         ";
										break;
									case "3":
										ciudad1 = "Peten         ";
										break;
									case "4":
										ciudad1 = "Chiquimula    ";
										break;
									case "5":
										ciudad1 = "Santa Rosa    ";
										break;
									case "6":
										ciudad1 = "Quetzaltenango";
										break;
									default:
										System.out.println("Error, ha ingresado incorrectamente.");
										break;
								}
								
								switch(ciudad2){
									case "1":
										ciudad2 = "Guatemala     ";
										break;
									case "2":
										ciudad2 = "Coban         ";
										break;
									case "3":
										ciudad2 = "Peten         ";
										break;
									case "4":
										ciudad2 = "Chiquimula    ";
										break;
									case "5":
										ciudad2 = "Santa Rosa    ";
										break;
									case "6":
										ciudad2 = "Quetzaltenango";
										break;
									default:
										System.out.println("Error, ha ingresado incorrectamente.");
										break;
								}
                                
                                System.out.println("Ingrese la distancia entre ambas ciudades: ");
                                peso  = Double.parseDouble(input.nextLine());         
                                
                                try {
                                    grafo1.addArista(ciudad1, ciudad2, peso);                                    
                                    System.out.println("Se creo la conexion exitosamente");
                                } catch (Exception ex) {                                    
                                	System.out.println("No se pudo crear la conexion exitosamente");
                                }
                                break;
                            case "3": //Salir
                                break;
                            default:            
                            	System.out.println("Ha ingresado una opcion incorrecta");
                        }
                    }
                    
                    grafo1.imprimirMatriz();
                    
                    break;
                case "4":
                    System.out.println("\nQue le vaya bien. :)");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }
    
}