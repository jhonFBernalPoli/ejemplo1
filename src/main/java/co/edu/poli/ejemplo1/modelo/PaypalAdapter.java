package co.edu.poli.ejemplo1.modelo;

import co.edu.poli.ejemplo1.servicio.GestorElementoDAO;

// Adaptador para PayPal
public class PaypalAdapter implements PagoAdapter {
    private Paypal paypal;
    private Pago pago;
    private GestorElementoDAO ged;
    public PaypalAdapter(Paypal paypal, Pago pago) {
        this.paypal = paypal;
        this.pago = pago;
    }

    @Override
    public void procesarPago(Pago pago) {
        
        ged.createElemento(pago);
        System.out.println("Nos fuimos por PayPal");
        throw new UnsupportedOperationException("Unimplemented method 'procesarPago'");
    }
}
