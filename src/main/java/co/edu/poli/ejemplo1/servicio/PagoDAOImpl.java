package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Nequi;
import co.edu.poli.ejemplo1.modelo.Pago;
import co.edu.poli.ejemplo1.modelo.Paypal;

/**
 * 
 */
public class PagoDAOImpl implements GestorElementoDAO<Pago> {

    private Pago pago;
	private Connection connection;
    private PaypalDAOImpl paypal;
    private NequiDAOImpl nequi;

    public PagoDAOImpl() {
        try {
            connection = Singleton.getInstance().getConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener la instancia de Singleton: " + e.getMessage());
            // Maneja el error adecuadamente
        }
    }

    @Override
    public String createElemento(Pago elemento) {

        pago = elemento;
        if(this.readElemento(pago.getId()) == null){
            String sql = "INSERT INTO pago (id, monto, fecha) VALUES (?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(pago.getId()));
                pstmt.setDouble(2, pago.getMonto());
                pstmt.setString(3, pago.getFecha());
                pstmt.executeUpdate();

                //Creando los datos del pago si es comestible o electronico
                if (pago instanceof Paypal) {
                    paypal.createElemento((Paypal) elemento);
                }else if (pago instanceof Nequi) {
                    nequi.createElemento((Nequi) elemento);
                }else {
                    System.out.println("El pago no es Nequi ni PayPal");
                }
                return "Pago " + pago.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el pago";
            }
        }else{
            return "El pago " + this.readElemento(pago.getId()) + " ya existe, no se puede insertar";
        }
    }

    @Override
    public List<Pago> listAllElementos() {
        List<Pago> pagos = new ArrayList<>();
        String sql = "SELECT * FROM pago";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id"));
                double monto = rs.getDouble("precio");
                String fecha = rs.getString("descripcion");
                Pago pago = new Pago(id, monto, fecha); // Inicializa el objeto Pago con argumentos
                pagos.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagos;
    }

    @Override
    public Pago readElemento(String id) {
        String sql = "SELECT * FROM pago WHERE id = ?";
        Pago pago = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pago = new Pago(String.valueOf(rs.getInt("id")), 
                rs.getDouble("monto"),
                rs.getString("fecha")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pago;
    }

    @Override
    public String updateElemento(String id, Pago elemento) {
        pago = elemento;

        String sql = "UPDATE pago SET descripcion = ?, precio = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, pago.getMonto());
            pstmt.setString(2, pago.getFecha());
            pstmt.setInt(3, Integer.parseInt(id));
            pstmt.executeUpdate();
            
            //Insertando el tipo de pago
            
            return "Pago actualizado exitosamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el pago";
        }
    }

    @Override
    public Pago deleteElemento(String id) {
        String sql = "DELETE FROM pago WHERE id = ?";
        Pago pago = (Pago) readElemento(id);

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
            return pago;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}