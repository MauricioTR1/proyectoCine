package cine;

public class Sala {

    private int id;
    private Asiento asientos[][];
    private Pelicula pelicula;
    private final String rojo = "\u001B[31m";
    private final String verde = "\u001B[32m";
    private final String reset = "\u001B[0m";

    public Sala() {
    }

    public Sala(int id, int filas, int columnas, Pelicula pelicula) {
        this.id = id;
        asientos = new Asiento[filas][columnas];
        this.pelicula = pelicula;
        this.rellenaAsientos();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    private void rellenaAsientos() {
        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos[f].length; c++) {
                asientos[f][c] = new Asiento(f + 1, (char) ('A' + c), false);
            }
        }
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + '}';
    }

    public void imprimir() {
        System.out.println(toString());
    }

    public String imprimeSala() {
        String info = "";
        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos[f].length; c++) {
                info += asientos[f][c].isOcupado() ? rojo : verde;
                info += asientos[f][c].FilaYColumna() + " ";
                info += reset;
            }
            info += "\n";
        }
        return info;
    }

    public boolean comprar(String seleccionados) {
        String comprados = "";
        String[] espacios = seleccionados.split(",");
        for (int i = 0; i < espacios.length; i++) {
            if (comprarAsiento(espacios[i])) {
                comprados += espacios[i] + ",";
            } else {
                liberar(comprados);
                return false;
            }
        }
        return true;
    }

    public boolean comprarAsiento(String espacio) {
        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos[f].length; c++) {
                if (asientos[f][c].FilaYColumna().equals(espacio)) {
                    if (!asientos[f][c].isOcupado()) {
                        asientos[f][c].setOcupado(true);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void liberar(String comprados) {
        String[] espacios = comprados.split(",");
        for (int i = 0; i < espacios.length; i++) {
            liberarAsiento(espacios[i]);
        }
    }

    public void liberarAsiento(String espacio) {
        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos[f].length; c++) {
                if (espacio.equals(asientos[f][c].FilaYColumna())) {
                    asientos[f][c].setOcupado(false);
                    return;
                }
            }
        }
    }
}
