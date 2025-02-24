package co.poli.edu.ejemplo1.controlador;

import java.util.List;

import co.poli.edu.ejemplo1.modelo.Pedido;
import co.poli.edu.ejemplo1.servicio.PedidoDAOImpl;

public class PedidoController {
	private PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();

    public String crearPedido(Pedido pedido) {
        return pedidoDAO.createElemento(pedido);
    }

    public List<Object> listarPedidos() {
        return pedidoDAO.listAllElementos();
    }

    public Pedido obtenerPedido(String numero) {
        return (Pedido) pedidoDAO.readElemento(numero);
    }

    public String actualizarPedido(String numero, Pedido pedido) {
        return pedidoDAO.updateElemento(numero, pedido);
    }

    public Pedido eliminarPedido(String numero) {
        return (Pedido) pedidoDAO.deleteElemento(numero);
    }

}