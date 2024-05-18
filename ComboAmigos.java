package cine;

public class ComboAmigos extends Combo {

    protected int dulces;

    public ComboAmigos() {
    }

    public ComboAmigos(int dulces) {
        this.dulces = dulces;
    }

    public ComboAmigos(int dulces, int id, float precio, String tamanioPalomitas, int refrescos) {
        super(id, precio, tamanioPalomitas, refrescos);
        this.dulces = dulces;
    }

    public int getDulces() {
        return dulces;
    }

    public void setDulces(int dulces) {
        this.dulces = dulces;
    }

    @Override
    public String toString() {
        return super.toString() + "ComboAmigos{" + "dulces=" + dulces + '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }
}
