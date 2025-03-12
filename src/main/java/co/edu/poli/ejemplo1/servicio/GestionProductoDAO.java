package co.edu.poli.ejemplo1.servicio;

import java.util.List;

import co.edu.poli.ejemplo1.modelo.Producto;

public interface GestionProductoDAO {

    /**
     * @return
     */
    public List<Producto> FilterByPrecio(double desde, double hasta);

}
