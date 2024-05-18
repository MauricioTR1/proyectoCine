package cine;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private int id;
    private String titulo;
    private String genero;
    private String productor;
    private String director;
    private String origen;
    private String duracion;

    public Pelicula() {
    }

    public Pelicula(int id, String titulo, String genero, String productor, String director, String origen, String duracion) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.productor = productor;
        this.director = director;
        this.origen = origen;
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return id + "," + titulo + "," + genero + "," + productor + "," + director + "," + origen + "," + duracion;
    }

    public void imprimir() {
        System.out.println(toString());
    }
}
