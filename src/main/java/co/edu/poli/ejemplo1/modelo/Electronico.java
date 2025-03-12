<<<<<<< HEAD:src/main/java/co/edu/poli/ejemplo1/modelo/Electronico.java
package co.edu.poli.ejemplo1.modelo;
=======
package co.poli.edu.ejemplo1.modelo;
>>>>>>> 6d8ab01e0413dc9547904a88c1bc88c2bc2d6408:src/main/java/co/poli/edu/ejemplo1/modelo/Electronico.java

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