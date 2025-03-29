package co.edu.poli.ejemplo1.modelo;

import co.edu.poli.ejemplo1.servicio.PaypalDAOImpl;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// Adaptador para PayPal
public class PaypalAdapter implements PasarelaPago {
    
    private Paypal paypal;
    private final PaypalDAOImpl pdi = new PaypalDAOImpl();

    public PaypalAdapter(Paypal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void procesarPago(double monto, String fecha) {
        System.out.println("Procesando pago con PayPal:");
        Alert confirmo = new Alert(AlertType.CONFIRMATION);
        confirmo.setContentText("Pago a PayPal por valor de " + paypal.getMonto() + " realizado a la cuenta " + paypal.getCuenta());
        confirmo.show();
    }


}
