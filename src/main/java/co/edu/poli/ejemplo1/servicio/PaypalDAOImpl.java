package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Paypal;

/**
 * 
 */
public class PaypalDAOImpl implements GestorElementoDAO<Paypal> {

    private Paypal paypal;
    private PagoDAOImpl pri = new PagoDAOImpl();
    private Connection connection;

    public PaypalDAOImpl() {
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
    public String createElemento(Paypal elemento) {
        
        paypal = elemento;

        /*
         * Validando si el pago paypal ya existe
         */
        if(pri.readElemento(paypal.getId()) == null){

            String sql = "INSERT INTO paypal (cuenta, correo, idpago) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, paypal.getCuenta());
                pstmt.setString(2, paypal.getCorreo());
                pstmt.setInt(3, Integer.parseInt(paypal.getId()));
                pstmt.executeUpdate();
                return "paypal " + paypal.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el pago paypal";
            }
        }else{
            return "El pago paypal " + pri.readElemento(paypal.getId()) + " ya existe, no se puede insertar";
        }
    }

    /**
     * @return
     */
    public List<Paypal> listAllElementos() {
        // TODO implement GestorElementoDAO.listAllElementos() here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    public Paypal readElemento(String id) {
        String sql = "SELECT p.id, p.monto, p.fecha, c.cuenta, c.correo FROM pagos p JOIN paypal c ON p.id = c.idpago;";
        Paypal paypal = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                paypal = new Paypal(
                String.valueOf(rs.getInt("p.id")), 
                rs.getDouble("p.monto"), 
                rs.getString("p.fecha"), 
                rs.getString("c.cuenta"), 
                rs.getString("c.correo")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paypal;
    }

    /**
     * @param id 
     * @param elemento 
     * @return
     */
    public String updateElemento(String id, Paypal elemento) {
        // TODO implement GestorElementoDAO.updateElemento() here
        return "";
    }

    /**
     * @param id 
     * @return
     */
    public Paypal deleteElemento(String id) {
        // TODO implement GestorElementoDAO.deleteElemento() here
        return null;
    }

}