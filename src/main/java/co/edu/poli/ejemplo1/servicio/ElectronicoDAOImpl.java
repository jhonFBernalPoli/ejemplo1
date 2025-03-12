<<<<<<< HEAD:src/main/java/co/edu/poli/ejemplo1/servicio/ElectronicoDAOImpl.java
package co.edu.poli.ejemplo1.servicio;
=======
package co.poli.edu.ejemplo1.servicio;
>>>>>>> 6d8ab01e0413dc9547904a88c1bc88c2bc2d6408:src/main/java/co/poli/edu/ejemplo1/servicio/ElectronicoDAOImpl.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

<<<<<<< HEAD:src/main/java/co/edu/poli/ejemplo1/servicio/ElectronicoDAOImpl.java
import co.edu.poli.ejemplo1.modelo.Electronico;
=======
import co.poli.edu.ejemplo1.modelo.Electronico;
>>>>>>> 6d8ab01e0413dc9547904a88c1bc88c2bc2d6408:src/main/java/co/poli/edu/ejemplo1/servicio/ElectronicoDAOImpl.java

/**
 * 
 */
public class ElectronicoDAOImpl implements GestorElementoDAO<Electronico> {

    private Electronico electronico;
    private ProductoDAOImpl pri = new ProductoDAOImpl();
    private Connection connection;

    public ElectronicoDAOImpl() {
        try {
            connection = Singleton.getInstance().getConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener la instancia de Singleton: " + e.getMessage());
            // Maneja el error adecuadamente
        }
    }

    /**
     * @param elemento 
     * @return
     */
    public String createElemento(Electronico elemento) {
        
        electronico = elemento;

        /*
         * Validando si el producto electronico ya existe
         */
        if(pri.readElemento(electronico.getId()) == null){

            String sql = "INSERT INTO electronico (bateria, voltaje, idproducto) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setBoolean(1, electronico.isBateria());
                pstmt.setString(2, electronico.getVoltaje());
                pstmt.setInt(3, Integer.parseInt(electronico.getId()));
                pstmt.executeUpdate();
                return "electronico " + electronico.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el producto electronico";
            }
        }else{
            return "El producto electronico " + pri.readElemento(electronico.getId()).getDescripcion() + " ya existe, no se puede insertar";
        }
    }

    /**
     * @return
     */
    public List<Electronico> listAllElementos() {
        // TODO implement GestorElementoDAO.listAllElementos() here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Electronico readElemento(String id) {
        String sql = "SELECT p.id, p.descripcion, p.precio, c.bateria, c.voltaje FROM productos p JOIN comestibles c ON p.id = c.idproducto;";
        Electronico electronico = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                electronico = new Electronico(String.valueOf(rs.getInt("p.id")), 
                rs.getString("p.descripcion"), 
                rs.getInt("p.precio"), 
                rs.getBoolean("c.bateria"), 
                rs.getString("c.voltaje")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return electronico;
    }

    /**
     * @param id 
     * @param elemento 
     * @return
     */
    public String updateElemento(String id, Electronico elemento) {
        // TODO implement GestorElementoDAO.updateElemento() here
        return "";
    }

    /**
     * @param id 
     * @return
     */
    public Electronico deleteElemento(String id) {
        // TODO implement GestorElementoDAO.deleteElemento() here
        return null;
    }

}