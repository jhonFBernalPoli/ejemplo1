<<<<<<< HEAD:src/main/java/co/edu/poli/ejemplo1/servicio/GestionProductoDAO.java
package co.edu.poli.ejemplo1.servicio;

import java.util.List;

import co.edu.poli.ejemplo1.modelo.Producto;
=======
package co.poli.edu.ejemplo1.servicio;

import java.util.List;

import co.poli.edu.ejemplo1.modelo.Producto;
>>>>>>> 6d8ab01e0413dc9547904a88c1bc88c2bc2d6408:src/main/java/co/poli/edu/ejemplo1/servicio/GestionProductoDAO.java

public interface GestionProductoDAO {

    /**
     * @return
     */
    public List<Producto> FilterByPrecio(double desde, double hasta);

}
