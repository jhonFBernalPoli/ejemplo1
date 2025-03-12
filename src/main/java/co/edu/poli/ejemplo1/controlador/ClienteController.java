package co.edu.poli.ejemplo1.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.servicio.ClienteDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
 
public class ClienteController implements Initializable{

    Cliente cliente;
    List<Cliente> listaClientes = new ArrayList<Cliente>();
    private String respuesta;
    private String idCliente;
    private String nombreCliente;
    @FXML
    private ChoiceBox<String> selOperation;

    private String[] opciones = {"Crear", "Listar", "Buscar", "Actualizar", "Eliminar"};

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    void Enviar(ActionEvent event) {
        idCliente = txtId.getText();
        nombreCliente = txtNombre.getText();
        Alert advertencia = new Alert(AlertType.WARNING);
        Alert mensaje = new Alert(AlertType.INFORMATION);
        Alert error = new Alert(AlertType.ERROR);
        switch (selOperation.getValue()) {
            case "Crear" : 
                    cliente = new Cliente(idCliente, nombreCliente);
                    this.crearCliente(cliente);
                    txtId.setText("");
                    txtNombre.setText("");
                    Alert confirmo = new Alert(AlertType.CONFIRMATION);
                    confirmo.setContentText("Cliente Creado");
                    confirmo.show();
                break;
            case "Listar" :

                listaClientes = this.listarClientes();
                respuesta = "";
                for (int i = 0; i < listaClientes.size(); i++) {
                    respuesta += listaClientes.get(i).getId() + ": " + listaClientes.get(i).getNombre() + ", ";
                }
                mensaje.setContentText(respuesta);
                mensaje.show();
                break;
            case "Buscar" :
                if(!idCliente.isEmpty()){
                   try {
                        cliente = this.obtenerCliente(idCliente);
                        txtId.setText(cliente.getId());
                        txtNombre.setText(cliente.getNombre());
                   } catch (Exception e) {
                        error.setContentText("El cliente " + idCliente + " no existe");
                        error.show();
                   }
                }  else {
                    advertencia.setContentText("Por favor diligencie el campo Id");
                    advertencia.show();
                }
                break;
            case "Actualizar" :
                if(!idCliente.isEmpty() && !nombreCliente.isEmpty()){
                    try {
                        cliente = new Cliente(idCliente, nombreCliente);
                        respuesta = this.actualizarCliente(idCliente, cliente);
                        txtId.setText("");
                        txtNombre.setText("");
                        mensaje.setContentText(respuesta);
                        mensaje.show();
                    } catch (Exception e) {
                        error.setContentText("El cliente " + idCliente + " no existe, no se puede Actualizar");
                        error.show();
                    }
                } else {
                    advertencia.setContentText("Debe diligenciar los dos campos para continuar");
                    advertencia.show();
                }
                
                break;
            case "Eliminar" :
                if(!idCliente.isEmpty()){
                    try {
                        cliente = this.eliminarCliente(idCliente);
                        txtId.setText("");
                        txtNombre.setText("");
                        mensaje.setContentText("Cliente " + cliente.getId() + ": " + cliente.getNombre() + " fue eliminado permanentemente");
                        mensaje.show();
                    } catch (Exception e) {
                        error.setContentText("El cliente " + idCliente + " no existe, no se puede Eliminar");
                        error.show();
                    }
                } else {
                    advertencia.setContentText("Debe diligenciar los dos campos para continuar");
                    advertencia.show();
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    
    @SuppressWarnings("FieldMayBeFinal")
	private ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

    public String crearCliente(Cliente cliente) {
        return clienteDAO.createElemento(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listAllElementos();
    }

    public Cliente obtenerCliente(String id) {
        return (Cliente) clienteDAO.readElemento(id);
    }

    public String actualizarCliente(String id, Cliente cliente) {
        return clienteDAO.updateElemento(id, cliente);
    }

    public Cliente eliminarCliente(String id) {
        return (Cliente) clienteDAO.deleteElemento(id);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        selOperation.getItems().addAll(opciones);
    }

}