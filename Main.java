/**
 * Main del programa
 * HDT#7 - Estructura de Datos
 * @author Esteban Aldana Guerra 20591
 */
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {

        ArrayList<Association> todoDiccionario = new ArrayList();
        File f = new File( "diccionario.txt" );
        BufferedReader entrada;
        try {
        entrada = new BufferedReader( new FileReader( f ) );
        String linea = entrada.readLine();
       
            while(entrada.ready()){
                linea = entrada.readLine();

                String vector[] = linea.split(",");
                Association separado = new Association();
                separado.addAsociation( vector[0].substring(1), vector[1].substring(0,vector[1].length()-1));

                todoDiccionario.add(separado);

            }

        }catch (IOException e) {
        e.printStackTrace();
        }
        
        System.out.println(todoDiccionario.size());
        System.out.println(todoDiccionario);
        BinaryTree diccionario = new BinaryTree();
        
        for (int x = 0; x < todoDiccionario.size(); x++){
            diccionario.addNode(todoDiccionario.get(x).getKey().toString(), todoDiccionario.get(x).getValue().toString());
        }
        
        
        
        System.out.println(diccionario);
        
        //Se trabaja el arbol binario de manera "in order"
        diccionario.inOrderTraverseTree(diccionario.root);
        
        
        //Mide el tamaño del arbol 
        int contador = todoDiccionario.size();
        System.out.println(contador); 
       

        File f1 = new File( "texto.txt" );
        BufferedReader entrada1;
        try {
            entrada1 = new BufferedReader( new FileReader( f1 ) );
            String linea1;
            linea1 = entrada1.readLine();
            linea1 = linea1.toLowerCase();
            System.out.println(linea1);
            
            
            String[] palabras = linea1.split(" ");
            String cadena = "";
            for (int x =0; x < palabras.length; x++){
                System.out.println(palabras[x]);
                String traducir = diccionario.findName(palabras[x].toString());
                System.out.println(traducir);

                if(palabras[x].equals("chicken")|| palabras[x].equals("hen")|| palabras[x].equals("quiz") || palabras[x].equals("calculator") || palabras[x].equals("car")
                        || palabras[x].equals("ship") ){
                    cadena += traducir + " ";
                }else{
                    cadena += " *"+palabras[x]+"* ";
                }
            }
            
            System.out.println(cadena);
            
            
        }catch (IOException e) {
        e.printStackTrace();
        }   
        
         
    }
    
    
}