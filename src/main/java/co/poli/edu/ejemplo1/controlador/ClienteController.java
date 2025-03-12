package co.poli.edu.ejemplo1.controlador;

import java.util.List;

import co.poli.edu.ejemplo1.modelo.Cliente;
import co.poli.edu.ejemplo1.servicio.ClienteDAOImpl;
 
public class ClienteController {

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

}