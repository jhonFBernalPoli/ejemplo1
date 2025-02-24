package co.poli.edu.ejemplo1.modelo;

public class Electronico extends Producto {
    private boolean bateria;
    private String voltaje;

    public Electronico(String id, String descripcion, double precio, boolean bateria, String voltaje) {
        super(id, descripcion, precio);
        this.bateria = bateria;
        this.voltaje = voltaje;
    }

    public boolean isBateria() {
        return bateria;
    }

    public void setBateria(boolean bateria) {
        this.bateria = bateria;
    }

    public String getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(String voltaje) {
        this.voltaje = voltaje;
    }
}