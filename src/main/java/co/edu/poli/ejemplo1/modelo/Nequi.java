package co.edu.poli.ejemplo1.modelo;

// Clase que representa un objeto Nequi
public class Nequi extends Pago {
    
    private String celular;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Nequi(String id, double monto, String fecha, String celular) {
        super(id, monto, fecha);
        this.celular = celular;
    }
    
}

