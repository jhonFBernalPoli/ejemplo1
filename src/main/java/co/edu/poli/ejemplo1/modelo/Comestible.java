<<<<<<< HEAD:src/main/java/co/edu/poli/ejemplo1/modelo/Comestible.java
package co.edu.poli.ejemplo1.modelo;
=======
package co.poli.edu.ejemplo1.modelo;
>>>>>>> 6d8ab01e0413dc9547904a88c1bc88c2bc2d6408:src/main/java/co/poli/edu/ejemplo1/modelo/Comestible.java

public class Comestible extends Producto {
    private String fechaVencimiento;
    private boolean refrigerado;
    private String aporteCalorico;

    public Comestible(String id, String descripcion, double precio, String fechaVencimiento, boolean refrigerado, String aporteCalorico) {
        super(id, descripcion, precio);
        this.fechaVencimiento = fechaVencimiento;
        this.refrigerado = refrigerado;
        this.aporteCalorico = aporteCalorico;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }

    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    public String getAporteCalorico() {
        return aporteCalorico;
    }

    public void setAporteCalorico(String aporteCalorico) {
        this.aporteCalorico = aporteCalorico;
    }
}