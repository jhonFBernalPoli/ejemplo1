package co.edu.poli.ejemplo1.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.poli.ejemplo1.modelo.Nequi;
import co.edu.poli.ejemplo1.modelo.NequiAdapter;
import co.edu.poli.ejemplo1.modelo.Paypal;
import co.edu.poli.ejemplo1.modelo.PaypalAdapter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PagoController implements Initializable{

    @FXML
    private TextField campoId;

    @FXML
    private TextField campoFecha;

    @FXML
    private ComboBox<String> comboMetodos;

    @FXML
    private TextField campoMonto;

    @FXML
    private TextField campoDatoCliente;

    @FXML
    private TextField campoCuenta;

    private String[] opciones = {"PayPal", "Nequi"};
    String id;
    String fecha;
    String metodo;
    double monto;
    String correo;
    String cuenta;
    String celular;
    Paypal paypal;
    Nequi nequi;
    PaypalAdapter ppa;
    NequiAdapter na;
    

    // Método llamado al presionar el botón de pagar
    @FXML
    void ProcesarPago() {
        try {
            // Recuperar datos ingresados por el usuario
            id = campoId.getText();
            fecha = campoFecha.getText();
            metodo = comboMetodos.getValue();
            monto = Double.parseDouble(campoMonto.getText());
            correo = campoDatoCliente.getText();
            cuenta = campoCuenta.getText();
            celular = campoDatoCliente.getText();

            if ("PayPal".equals(metodo)) {
                paypal = new Paypal(id, monto, fecha, cuenta, correo);
                ppa = new PaypalAdapter(paypal);
                ppa.procesarPago(monto, fecha);

            } else if ("Nequi".equals(metodo)) {
                nequi = new Nequi(id, monto, fecha, celular);
                na = new NequiAdapter(nequi);
                na.procesarPago(monto, fecha);
            } else {
                System.err.println("Ninguna opción seleccionada");
            }
            campoId.setText("");
            campoFecha.setText("");
            comboMetodos.setValue("");
            campoMonto.setText("");
            campoDatoCliente.setText("");
            campoCuenta.setText("");
            campoDatoCliente.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void MediodePago() {
        metodo = comboMetodos.getValue();
        if ("PayPal".equals(metodo)) {
            campoCuenta.setVisible(true);
            campoDatoCliente.setPromptText("Ingrese el correo (correo@mail.com)");

        } else if ("Nequi".equals(metodo)) {
            campoCuenta.setVisible(false);
            campoDatoCliente.setPromptText("Ingrese el número celular");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        comboMetodos.getItems().addAll(opciones);
    }
}