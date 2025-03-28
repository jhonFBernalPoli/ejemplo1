package co.edu.poli.ejemplo1.servicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.poli.ejemplo1.modelo.Cliente;
import co.edu.poli.ejemplo1.modelo.Pedido;
import co.edu.poli.ejemplo1.modelo.Producto;

/**
 * 
 */
public class PedidoDAOImpl implements GestorElementoDAO<Pedido> {
    private Cliente cliente;
	private Pedido pedido;
    private Connection connection;

    public PedidoDAOImpl() {
        try {
            connection = Singleton.getInstance().getConnection();
        } catch (Exception e) {
            System.out.println("Error al obtener la instancia de Singleton: " + e.getMessage());
            // Maneja el error adecuadamente
        }
    }

    @Override
    public String createElemento(Pedido elemento) {
        
        pedido = elemento;
        
        ArrayList<Producto> prod = pedido.getProducto();
        PreparedStatement pstmt = null;

        if(this.readElemento(pedido.getNumero()) == null){
            String sql = "INSERT INTO pedido (numeropedido, fecha, idcliente) VALUES (?, ?, ?)";
            String sql2 = "INSERT INTO producto_pedido (numeropedido, idproducto) VALUES (?, ?)";

            //Insertando datos de pedido sin productos
            try { pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, pedido.getNumero());
                pstmt.setDate(2, new java.sql.Date(pedido.getFecha().getTime()));
                pstmt.setString(3, pedido.getCliente().getId());
                pstmt.executeUpdate();
                
                //Insertando relación entre pedidos y productos
                pstmt = connection.prepareStatement(sql2);
                pedido.getProducto();
                for (int i = 0; i < prod.size(); i++) {
                    pstmt.setString(1, pedido.getNumero());
                    pstmt.setString(2, prod.get(i).getId());
                    pstmt.executeUpdate();
                }
                return "Pedido " + pedido.getNumero() + " creado exitosamente";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error al crear el pedido";
            }
        }else{
            return "El pedido " + this.readElemento(pedido.getNumero()).getNumero() + " ya existe, no se puede insertar";
        }
    }

    @Override
    public List<Pedido> listAllElementos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String numero = rs.getString("numeropedido");
                Date fecha = rs.getDate("fecha");
                String clienteId = rs.getString("idcliente");

                // Obtener el Cliente por su ID
                ClienteDAOImpl ged = new ClienteDAOImpl();                
                cliente = ged.readElemento(clienteId);

                pedido = new Pedido(numero, cliente, fecha, new ArrayList<>()); // Inicializa el objeto Pedido con argumentos
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public Pedido readElemento(String numero) {
        String sql = "SELECT * FROM pedido WHERE numeropedido = ?";
        Pedido pedido = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Date fecha = rs.getDate("fecha");
                String clienteId = rs.getString("idcliente");

                // Aquí deberías tener una forma de obtener el objeto Cliente por su ID
                ClienteDAOImpl ged = new ClienteDAOImpl();                
                cliente = (Cliente) ged.readElemento(clienteId);

                pedido = new Pedido(rs.getString("numeropedido"), cliente, rs.getDate("fecha"), new ArrayList<>()); // Inicializa el objeto Pedido con argumentos
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public String updateElemento(String numero, Pedido elemento) {
        pedido = elemento;
        String sql = "UPDATE pedido SET fecha = ?, idcliente = ? WHERE numeropedido = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDate(1, (Date) pedido.getFecha());
            pstmt.setString(2, pedido.getCliente().getId());
            pstmt.setString(3, numero);
            pstmt.executeUpdate();
            return "Pedido actualizado exitosamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el pedido";
        }
    }

    @Override
    public Pedido deleteElemento(String numero) {
        String sql = "DELETE FROM pedido WHERE numeropedido = ?";
        pedido = readElemento(numero);

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, numero);
            pstmt.executeUpdate();
            return pedido;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}