package co.edu.poli.ejemplo1.modelo;

// Modelo que representa un pago
public class Pago {

    private String id;
    private double monto;
    private String fecha;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Pago(String id, double monto, String fecha) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
    }

   
}
