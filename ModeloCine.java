package modelo;

import cine.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ModeloCine {

    private FileReader fileR;
    private BufferedReader buffR;
    private char inputOutput;
    private String nombreArchivo;
    private File archivo;
    private FileOutputStream salida;
    private OutputStreamWriter escribeSalida;

    public ModeloCine(String nombreArchivo, char inputOutput) {
        try {
            archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                System.out.println("No existe el archivo, se creará uno nuevo");
                archivo.createNewFile();
            }

            this.inputOutput = inputOutput;

            if (inputOutput == 'o') {
                salida = new FileOutputStream(this.archivo);
                escribeSalida = new OutputStreamWriter(this.salida);
                System.out.println("o");
            } else {
                fileR = new FileReader(archivo);
                buffR = new BufferedReader(fileR);
                System.out.println("i");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ie) {
            System.out.println("No se pudo crear archivo");
        }
    }

    public ArrayList cargaPeliculas() {
        ArrayList<Pelicula> peliculasEnArchivo = new ArrayList<Pelicula>();
        //int id, String titulo, String genero, String productor, String director, String origen, String duracion
        int id;
        String titulo, genero, productor, director, origen, duracion;
        try {
            String linea = "  ", atrib;
            while (linea != null) {
                linea = buffR.readLine();
                if (linea != null) {
                    // linea -> "1,INTERSTELLAR,CIENCIA FICCION,WARNER,JOE RUSSO,ESTADOS UNIDOS,2:19:00"
                    atrib = (linea.substring(0, linea.indexOf(",")));
                    id = Integer.parseInt(atrib);//=1
                    linea = linea.substring(atrib.length() + 1, linea.length());//"INTERSTELLAR,CIENCIA FICCION,WARNER,JOSE RUSSO,ESTADOS UNIDOS,2:19:00"
                    atrib = linea.substring(0, linea.indexOf(","));//"INTERSTELLAR"
                    titulo = atrib;//"INTERSTELLAR"
                    linea = linea.substring(atrib.length() + 1, linea.length());//"CIENCIA FICCION,WARNER,JOSE RUSSO,ESTADOS UNIDOS,2:19:00"
                    atrib = linea.substring(0, linea.indexOf(","));//"CIENCIA FICCION"
                    genero = atrib;//"CIENCIA FICCION"
                    linea = linea.substring(atrib.length() + 1, linea.length());//"WARNER,JOSE RUSSO,ESTADOS UNIDOS,2:19:00"
                    atrib = linea.substring(0, linea.indexOf(","));//"WARNER"
                    productor = atrib;//"WARNER"
                    linea = linea.substring(atrib.length() + 1, linea.length());//"JOSE RUSSO,ESTADOS UNIDOS,2:19:00"
                    atrib = linea.substring(0, linea.indexOf(","));//"JOE RUSSO"
                    director = atrib;//"JOE RUSSO"
                    linea = linea.substring(atrib.length() + 1, linea.length());//"ESTADOS UNIDOS,2:19:00"
                    atrib = linea.substring(0, linea.indexOf(","));//"ESTADOS UNIDOS"
                    origen = atrib;//"ESTADOS UNIDOS"
                    linea = linea.substring(atrib.length() + 1, linea.length());//"2:19:00"
                    duracion = linea;
                    peliculasEnArchivo.add(new Pelicula(id, titulo, genero, productor, director, origen, duracion));
                }
            }
            escribeSalida.close();
        } catch (IOException e) {
            System.out.println("Error en archivo");
        } catch (NullPointerException ex) {
            System.out.println("\nError");
        }

        return peliculasEnArchivo;
    }
    public void registrarPelicula(Pelicula p){
        try{
            String registro = p.toString();
            System.out.println(registro);
            escribeSalida.write(registro+"\n");
            escribeSalida.close();
        } catch(IOException e){
            System.out.println("Error al grabar en archivo");
        }
    }
    public void actualizarPelicula(ArrayList peliculas){
        String registro;
        try{
            for(int i=0; i<peliculas.size(); i++){
                registro = peliculas.get(i).toString();
                escribeSalida.write(registro+"\n");
            }
            escribeSalida.close();
        } catch(IOException e){
            System.out.println("Error en archivo");
        }
    }
    public void listarPelicula(){
        try{
            String linea = "  ";
            while(linea!=null){
               linea = buffR.readLine();
               if(linea!=null){
                  System.out.println(linea);
               }
            }
            escribeSalida.close();
        } catch(IOException e){
            System.out.println("Error en archivo");
        } catch(NullPointerException ex) {
            System.out.println("\nError");
        }
    }
}
