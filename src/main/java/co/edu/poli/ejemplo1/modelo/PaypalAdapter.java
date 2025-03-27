package co.edu.poli.ejemplo1.modelo;

// Adaptador para PayPal
public class PaypalAdapter implements PagoAdapter {
    private Paypal paypal;
    private Pago pago;

    public PaypalAdapter(Paypal paypal, Pago pago) {
        this.paypal = paypal;
        this.pago = pago;
    }

    @Override
    public void procesarPago(Pago pago) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'procesarPago'");
    }
}
