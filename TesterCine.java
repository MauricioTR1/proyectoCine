package tester;

import cine.Boleto;
import cine.Combo;
import cine.ComboAmigos;
import cine.Pelicula;
import cine.Sala;
import java.util.Vector;

public class TesterCine {

    public static Vector<Boleto> boletos = new Vector<Boleto>();
    public static Vector<Combo> combos = new Vector<Combo>();

    public static void main2(String[] args) {

        Pelicula p1 = new Pelicula(1, "Los viajes de Gulliver", "Ciencia Ficcion", "Davis Entertainment", "Rob Letterman", "Estados Unidos", "1:25:00");

        Sala s1 = new Sala(1, 5, 5, p1);

        ComboAmigos ca = new ComboAmigos(5, 1, 150, "Grande", 3);
        combos.add(ca);

        s1.comprar("A1,B1,C1");

        Boleto b1 = new Boleto(1, p1, "06/06/2022", "17:00", s1, "A1,B1,C1");
        boletos.add(b1);
        b1.imprimir();

    }
}
