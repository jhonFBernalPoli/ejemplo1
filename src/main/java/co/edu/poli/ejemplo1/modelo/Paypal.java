package co.edu.poli.ejemplo1.modelo;

// Clase que representa un objeto PayPal
public class Paypal extends Pago{
    private String cuenta;
    private String correo;

    public String getCuenta() {
        return cuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public Paypal(String id, double monto, String fecha, String cuenta, String correo) {
        super(id, monto, fecha);
        this.cuenta = cuenta;
        this.correo = correo;
    }

    
}


