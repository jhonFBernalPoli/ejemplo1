package co.edu.poli.ejemplo1.modelo;

import co.edu.poli.ejemplo1.servicio.NequiDAOImpl;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class NequiAdapter implements PasarelaPago {
    
    private Nequi nequi;
    private final NequiDAOImpl ndi = new NequiDAOImpl();

    public NequiAdapter(Nequi nequi) {
        this.nequi = nequi;
    }

    @Override
    public void procesarPago(double monto, String fecha) {
        System.out.println("Procesando pago con Nequi:");

Alert confirmo = new Alert(AlertType.CONFIRMATION);
        confirmo.setContentText("Pago a PayPal por valor de " + nequi.getMonto() + " realizado al numero " + nequi.getCelular());
        confirmo.show();
    }

}
