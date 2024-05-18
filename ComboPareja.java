package cine;

public class ComboPareja extends Combo {

    protected int hotDogs;

    public ComboPareja() {
    }

    public ComboPareja(int hotDogs) {
        this.hotDogs = hotDogs;
    }

    public ComboPareja(int hotDogs, int id, float precio, String tamanioPalomitas, int refrescos) {
        super(id, precio, tamanioPalomitas, refrescos);
        this.hotDogs = hotDogs;
    }

    public int getHotDogs() {
        return hotDogs;
    }

    public void setHotDogs(int hotDogs) {
        this.hotDogs = hotDogs;
    }

    @Override
    public String toString() {
        return super.toString() + "ComboPareja{" + "hotDogs=" + hotDogs + '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }

}
