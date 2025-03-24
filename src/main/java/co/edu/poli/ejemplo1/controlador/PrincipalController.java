package co.edu.poli.ejemplo1.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    @FXML
    private MenuItem BtnCliente;
    @FXML
    private MenuItem BtnDepartamento;
    @FXML
    private MenuItem BtnEmpleado;
    @FXML
    private MenuItem BtnPedido;
    @FXML
    private MenuItem BtnProducto;
    @FXML
    private MenuItem BtnProveedor;
    @FXML
    private Pane MainPanel;

    Scene scene;
    Stage stage = new Stage();

    @FXML
    void IntClientes(ActionEvent event) {
        Parent intCliente;
        try {
            intCliente = FXMLLoader.load(getClass().getResource("/co/edu/poli/ejemplo1/vista/ClienteView.fxml"));
            scene = new Scene(intCliente);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @FXML
    void IntDepartamentos(ActionEvent event) {

    }

    @FXML
    void IntEmpleados(ActionEvent event) {

    }

    @FXML
    void IntPedidos(ActionEvent event) {

    }

    @FXML
    void IntProductos(ActionEvent event) {
        Pane productos = new Pane();
        
    }

    @FXML
    void IntProveedores(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

}
