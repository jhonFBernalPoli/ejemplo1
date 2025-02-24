package co.poli.edu.ejemplo1.servicio;

import java.util.List;

import co.poli.edu.ejemplo1.modelo.Producto;

public interface GestionProductoDAO {

    /**
     * @return
     */
    public List<Producto> FilterByPrecio(double desde, double hasta);

}
