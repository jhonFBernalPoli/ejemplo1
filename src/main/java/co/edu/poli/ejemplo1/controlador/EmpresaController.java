package co.edu.poli.ejemplo1.controlador;


import co.edu.poli.ejemplo1.modelo.Departamento;
import co.edu.poli.ejemplo1.modelo.Empleado;
import co.edu.poli.ejemplo1.servicio.EmpresaDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmpresaController {
    @FXML
    private TextField nombreEmpleadoField;
    @FXML
    private TextField puestoEmpleadoField;
    @FXML
    private TextField nombreDepartamentoField;
    @FXML
    private TextArea outputArea;

    private EmpresaDAOImpl empresa;

    public EmpresaController() {
        this.empresa = new EmpresaDAOImpl();
    }

    @FXML
    private void guardarEmpleado() {
        String nombreEmpleado = nombreEmpleadoField.getText();
        String puesto = puestoEmpleadoField.getText();
        String nombreDepartamento = nombreDepartamentoField.getText();

        if (!nombreEmpleado.isEmpty() && !puesto.isEmpty() && !nombreDepartamento.isEmpty()) {
            Empleado empleado = new Empleado(nombreEmpleado, puesto);
            Departamento departamento = new Departamento(nombreDepartamento);

            // Guardar en la base de datos a través del DAO
            empresa.guardarEmpleadoYDepartamento(empleado, departamento);

            Alert confirmo = new Alert(AlertType.CONFIRMATION);
            confirmo.setContentText("Empleado guardado con éxito:\n Nombre: " + nombreEmpleado + ", Puesto: " + puesto + ", Departamento: " + nombreDepartamento + "\n");
            confirmo.show();
        } else {
            Alert error = new Alert(AlertType.ERROR);
            error.setContentText("Por favor, completa todos los campos antes de guardar.\n");
        }
    }
}

