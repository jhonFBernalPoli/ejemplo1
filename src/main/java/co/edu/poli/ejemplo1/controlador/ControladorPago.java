package co.edu.poli.ejemplo1.controlador;

import co.edu.poli.ejemplo1.modelo.Nequi;
import co.edu.poli.ejemplo1.modelo.NequiAdapter;
import co.edu.poli.ejemplo1.modelo.Pago;
import co.edu.poli.ejemplo1.modelo.Paypal;
import co.edu.poli.ejemplo1.modelo.PaypalAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorPago {

    @FXML
    private TextField campoId;

    @FXML
    private TextField campoFecha;

    @FXML
    private ComboBox<String> comboMetodos;

    @FXML
    private TextField campoMonto;

    @FXML
    private TextField campoCorreo;
    
    @FXML
    private TextField campoCelular;

    @FXML
    private Label etiquetaResultado;

    // Método llamado al presionar el botón de pagar
    @FXML
    private void procesarPago() {
        try {
            // Recuperar datos ingresados por el usuario
            String id = campoId.getText();
            String fecha = campoFecha.getText();
            String metodo = comboMetodos.getValue();
            double monto = Double.parseDouble(campoMonto.getText());
            String correo = campoCorreo.getText();
            String celular = campoCelular.getText();

            // Crear el modelo de pago
            Pago pago = new Pago(id, monto, fecha);

            if ("Paypal".equals(metodo)) {
                Paypal paypal = new Paypal(id, monto, celular, celular, celular);
                PaypalAdapter payPalAdapter = new PaypalAdapter(paypal, pago);
                payPalAdapter.procesarPago(paypal);
                etiquetaResultado.setText("Pago procesado con Paypal. ID: " + id + ", Fecha: " + fecha);
            } else if ("Nequi".equals(metodo)) {
                Nequi nequi = new Nequi("3101234567", monto, correo, correo);
                NequiAdapter nequiAdapter = new NequiAdapter(nequi, pago);
                nequiAdapter.procesarPago(nequi);
                etiquetaResultado.setText("Pago procesado con Nequi. ID: " + id + ", Fecha: " + fecha);
            } else {
                etiquetaResultado.setText("Método de pago no válido.");
            }
        } catch (NumberFormatException e) {
            etiquetaResultado.setText("Por favor, ingrese un monto válido.");
        } catch (Exception e) {
            etiquetaResultado.setText("Ocurrió un error: " + e.getMessage());
        }
    }
}