package co.poli.edu.ejemplo1.modelo;

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