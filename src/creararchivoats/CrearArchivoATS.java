package creararchivoats;

import java.io.*;


public class CrearArchivoATS {
    
    File archivo;
    
    private void crearArchivo(){
        archivo = new File("prueba.txt");
        
        try{
            if(archivo.createNewFile()){ //crea un nuevo archivo, si ya existe no hace nada
                System.out.println("Archivo creado");
            }/*else{
                System.out.println("El archivo ya existe");
            }*/
        }catch (IOException ex){
            System.err.println("No se pudo crear el archivo");
        }
        
    }

    private void agregarTexto(){
        try {
            FileWriter escribir = new FileWriter(archivo, true); //el boolean true indica que vamos a añadir y no sobreescribir 
            //escribir.write("Hola mundo"); //sobrescribe al ejecutar el programa de nuevo
            //escribir.write("\nSobrescribe?");
            escribir.append("un texto");
            escribir.append("\n otro texto");
            escribir.append("\npalabras"); //añade sin sobreescribir
            escribir.close();
        } catch (IOException ex) {
            System.err.println("Error, no se puede escribir en el archivo.");
        }
    }
    
    private void leerTexto(){
        String cadena;
        
        try {
            FileReader lector = new FileReader(archivo);
            BufferedReader lectura = new BufferedReader(lector);
            
            try {
                cadena = lectura.readLine();
                //System.out.println(cadena);
                while(cadena != null){
                System.out.println(cadena);
                cadena = lectura.readLine();
                }
            } catch (IOException ex) {
                System.err.println("Error" + ex);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error " + ex );
        }
    }
    public static void main(String[] args) {
        CrearArchivoATS nuevo = new CrearArchivoATS();
        nuevo.crearArchivo();
       // nuevo.agregarTexto();
        nuevo.leerTexto();
    }
    
}
