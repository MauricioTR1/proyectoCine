package cine;

public class ComboFamilia extends Combo {

    protected int crepas;

    public ComboFamilia() {
    }

    public ComboFamilia(int crepas) {
        this.crepas = crepas;
    }

    public ComboFamilia(int crepas, int id, float precio, String tamanioPalomitas, int refrescos) {
        super(id, precio, tamanioPalomitas, refrescos);
        this.crepas = crepas;
    }

    public int getCrepas() {
        return crepas;
    }

    public void setCrepas(int crepas) {
        this.crepas = crepas;
    }

    @Override
    public String toString() {
        return super.toString() + "ComboFamilia{" + "crepas=" + crepas + '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }

}
