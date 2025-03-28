package co.edu.poli.ejemplo1.controlador;

import java.util.List;

import co.edu.poli.ejemplo1.modelo.Producto;
import co.edu.poli.ejemplo1.servicio.ProductoDAOImpl;

public class ProductoController {

    @SuppressWarnings("FieldMayBeFinal")
	private ProductoDAOImpl productoDAO = new ProductoDAOImpl();

    public String crearProducto(Producto producto) {
        return productoDAO.createElemento(producto);
    }

    public List<Producto> listarProductos() {
        return productoDAO.listAllElementos();
    }

    public Producto obtenerProducto(String id) {
        return (Producto) productoDAO.readElemento(id);
    }

    public String actualizarProducto(String id, Producto producto) {
        return productoDAO.updateElemento(id, producto);
    }

    public Producto eliminarProducto(String id) {
        return (Producto) productoDAO.deleteElemento(id);
    }

}