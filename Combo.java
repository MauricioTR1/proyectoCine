package cine;

public abstract class Combo {

    protected int id;
    protected float precio;
    protected String tamanioPalomitas;
    protected int refrescos;

    public Combo() {
    }

    public Combo(int id, float precio, String tamanioPalomitas, int refrescos) {
        this.id = id;
        this.precio = precio;
        this.tamanioPalomitas = tamanioPalomitas;
        this.refrescos = refrescos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTamanioPalomitas() {
        return tamanioPalomitas;
    }

    public void setTamanioPalomitas(String tamanioPalomitas) {
        this.tamanioPalomitas = tamanioPalomitas;
    }

    public int getRefrescos() {
        return refrescos;
    }

    public void setRefrescos(int refrescos) {
        this.refrescos = refrescos;
    }

    @Override
    public String toString() {
        return "Combo{" + "id=" + id + ", precio=" + precio + ", tamanioPalomitas=" + tamanioPalomitas + ", refrescos=" + refrescos + '}';
    }

    public abstract void imprimir();
}
