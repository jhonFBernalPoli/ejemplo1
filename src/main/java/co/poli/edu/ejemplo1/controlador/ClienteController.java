package co.poli.edu.ejemplo1.controlador;

import co.poli.edu.ejemplo1.modelo.Cliente;
import co.poli.edu.ejemplo1.servicio.ClienteDAOImpl;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class ClienteController {

	private ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

    public String crearCliente(Cliente cliente) {
        return clienteDAO.createElemento(cliente);
    }

    public List<Object> listarClientes() {
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