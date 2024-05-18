package dao;

import cine.Pelicula;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DAOCine {

    private File archivoDeObjetos;
    FileOutputStream salidaConObjetos;
    ObjectOutputStream salidaDeObjetos;

    private String nombreArchivo;

    File archivoDeObjetosALeer;
    FileInputStream entradaConObjetos;
    ObjectInputStream entradaDeObjetos;

    private char inputOutput;

    public DAOCine(String nombreArchivo, char inputOutput) {
        try {
            archivoDeObjetos = new File(nombreArchivo);
            archivoDeObjetosALeer = new File(nombreArchivo);

            if (!archivoDeObjetos.exists()) {
                System.out.println("No existe el archivo, se creará");
                archivoDeObjetos.createNewFile();
            }

            this.inputOutput = inputOutput;

            if (inputOutput == 'o') {
                salidaConObjetos = new FileOutputStream(this.archivoDeObjetos);
                salidaDeObjetos = new ObjectOutputStream(salidaConObjetos);
                System.out.println("o");
            } else {

                entradaConObjetos = new FileInputStream(archivoDeObjetosALeer);
                entradaDeObjetos = new ObjectInputStream(entradaConObjetos);
                System.out.println("i");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ie) {
            System.out.println("No se pudo crear archivo");
        }
    }
    public ArrayList cargaPelicula(){
        ArrayList<Pelicula> peliculasEnArchivo = new ArrayList<Pelicula>();
        Pelicula p = new Pelicula();
        //int id, String titulo, String genero, String productor, String director, String origen, String duracion
        int id;
        String titulo, genero, productor, director, origen, duracion;
        try{
            while((p = (Pelicula) entradaDeObjetos.readObject())!=null){
               if(p.getId()>0){
                  id = p.getId();
                  titulo = p.getTitulo();
                  genero = p.getGenero();
                  productor = p.getProductor();
                  director = p.getDirector();
                  origen = p.getOrigen();
                  duracion = p.getDuracion();
                  peliculasEnArchivo.add(new Pelicula(id, titulo, genero, productor, director, origen, duracion));
               }
            }
            entradaDeObjetos.close();
        } catch(IOException e){
            System.out.println("Error en archivo");
        } catch(NullPointerException ex) {
            System.out.println("\nError");
        } catch(ClassNotFoundException exc){
            System.out.println("\nError ClassNotFound");
        }
        
        return peliculasEnArchivo;
    }
    public void actualizarPelicula(ArrayList peliculas){
        String registro;
        try{
            for(int i=0; i<peliculas.size(); i++){
                salidaDeObjetos.writeObject(peliculas.get(i));
            }
            salidaDeObjetos.close();
        } catch(IOException e){
            System.out.println("Error en archivo");
        }
    }
}
