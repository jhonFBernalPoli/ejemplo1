package co.poli.edu.ejemplo1.servicio;

public interface GestionProductoDAO {

    /**
     * @return
     */
    Public List<Producto> FilterByPrecio(double desde, double hasta);
}
