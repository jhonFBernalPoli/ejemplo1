package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Comestible;
import co.edu.poli.ejemplo1.vista.Principal;

/**
 * 
 */
public class ComestibleDAOImpl implements GestorElementoDAO<Comestible> {

    private Comestible comestible;
    private ProductoDAOImpl pri = new ProductoDAOImpl();
    private Connection connection;

    public ComestibleDAOImpl() {
        try {
            connection = Singleton.getInstance().getConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener la instancia de Singleton: " + e.getMessage());
            // Maneja el error adecuadamente
        }
    }
    
    @Override
    public String createElemento(Comestible elemento) {
       
        comestible = elemento;

        /*
         * Validando si el producto comestible ya existe
         */
        if(pri.readElemento(comestible.getId()) == null){

            String sql = "INSERT INTO Comestible (fechaVencimiento, refrigerado, aporteCalorico, idProducto) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, comestible.getFechaVencimiento());
                pstmt.setBoolean(2, comestible.isRefrigerado());
                pstmt.setString(3, comestible.getAporteCalorico());
                pstmt.setInt(4, Integer.parseInt(comestible.getId()));
                pstmt.executeUpdate();
                return "Comestible " + comestible.getId() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el producto comestible";
            }
        }else{
            return "El producto comestible " + pri.readElemento(comestible.getId()).getDescripcion() + " ya existe, no se puede insertar";
        }
    }

    @Override
    public List<Comestible> listAllElementos() {
       
        List<Comestible> comestibles = new ArrayList<>();
        String sql = Principal.getProps("sql.select").replace("{elemento}", "comestible");

        // try (PreparedStatement pstmt = connection.prepareStatement(sql);
        //      ResultSet rs = pstmt.executeQuery()) {

        //     while (rs.next()) {
        //         String fechaVencimiento = rs.getString("fechaVencimiento");
        //         boolean refrigerado = rs.getBoolean("refrigerado");
        //         String aporteCalorico = rs.getString("aporteCalorico");
        //         String ididproducto = String.valueOf(rs.getInt("idproducto"));
        //         Comestible comestible = new Comestible(fechaVencimiento, refrigerado, aporteCalorico, ididproducto); 
        //         comestibles.add(comestible);
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        return comestibles;
    }

    @Override
    public Comestible readElemento(String id) {
        String sql = "SELECT p.id, p.descripcion, p.precio, c.fechavencimiento, c.refrigerado, c.aportecalorico FROM productos p JOIN comestibles c ON p.id = c.idproducto;";
        Comestible comestible = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                comestible = new Comestible(String.valueOf(rs.getInt("p.id")), 
                rs.getString("p.descripcion"), 
                rs.getInt("p.precio"), 
                rs.getString("c.fechavencimiento"), 
                rs.getBoolean("c.refrigerado"), 
                rs.getString("c.refrigerado")); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comestible;
    }

    @Override
    public String updateElemento(String id, Comestible elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateElemento'");
    }

    @Override
    public Comestible deleteElemento(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteElemento'");
    }
}