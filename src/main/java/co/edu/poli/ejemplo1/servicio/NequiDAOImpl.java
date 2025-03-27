package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Nequi;

/**
 * 
 */
public class NequiDAOImpl implements GestorElementoDAO<Nequi> {

    private Nequi nequi;
    private PagoDAOImpl pdi = new PagoDAOImpl();
    private Connection connection;

    public NequiDAOImpl() {
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
    public String createElemento(Nequi elemento) {
        
        nequi = elemento;

        /*
         * Validando si el pago nequi ya existe
         */
        if(pdi.readElemento(nequi.getId()) == null){

            String sql = "INSERT INTO nequi (celular, idpago) VALUES (?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, nequi.getCelular());
                pstmt.setInt(2, Integer.parseInt(nequi.getId()));
                pstmt.executeUpdate();
                return "nequi " + nequi.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el pago nequi";
            }
        }else{
            return "El pago nequi " + pdi.readElemento(nequi.getId()) + " ya existe, no se puede insertar";
        }
    }

    /**
     * @return
     */
    public List<Nequi> listAllElementos() {
        // TODO implement GestorElementoDAO.listAllElementos() here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Nequi readElemento(String id) {
        String sql = "SELECT p.id, p.monto, p.fecha, n.celular FROM pagos p JOIN nequi n ON p.id = n.idpago;";
        Nequi nequi = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nequi = new Nequi(
                    String.valueOf(rs.getInt("p.id")), 
                    rs.getDouble("c.monto"),
                    rs.getString("p.fecha"), 
                    rs.getString("n.celular")
                ); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nequi;
    }

    /**
     * @param id 
     * @param elemento 
     * @return
     */
    public String updateElemento(String id, Nequi elemento) {
        // TODO implement GestorElementoDAO.updateElemento() here
        return "";
    }

    /**
     * @param id 
     * @return
     */
    public Nequi deleteElemento(String id) {
        // TODO implement GestorElementoDAO.deleteElemento() here
        return null;
    }

}