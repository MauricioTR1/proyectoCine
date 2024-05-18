package cine;

public class Boleto {

    private int id;
    private Pelicula pelicula;
    private String fecha;
    private String hora;
    private Sala sala;
    private String asiento;

    public Boleto() {
    }

    public Boleto(int id, Pelicula pelicula, String fecha, String hora, Sala sala, String asiento) {
        this.id = id;
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
        this.asiento = asiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "Boleto{" + "id=" + id + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", asiento=" + asiento + '}';
    }

    public void imprimir() {
        System.out.println(toString());
    }
}
