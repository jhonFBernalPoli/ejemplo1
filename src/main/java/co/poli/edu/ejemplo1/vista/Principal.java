package co.poli.edu.ejemplo1.vista;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import co.poli.edu.ejemplo1.modelo.Cliente;
import co.poli.edu.ejemplo1.modelo.Comestible;
import co.poli.edu.ejemplo1.modelo.Electronico;
import co.poli.edu.ejemplo1.modelo.Pedido;
import co.poli.edu.ejemplo1.modelo.Producto;
import co.poli.edu.ejemplo1.servicio.ClienteDAOImpl;
import co.poli.edu.ejemplo1.servicio.PedidoDAOImpl;
import co.poli.edu.ejemplo1.servicio.ProductoDAOImpl;

public class Principal {

	private static Properties properties = new Properties();
	static String respuesta = null;
	static ClienteDAOImpl cd = new ClienteDAOImpl();
	static ProductoDAOImpl pd = new ProductoDAOImpl();
	static PedidoDAOImpl ped = new PedidoDAOImpl();

	// Método estático para cargar las propiedades
    public static void cargarProperties() {
        try (InputStream input = Principal.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                Exception e = new Exception("Lo siento, no pude encontrar el archivo properties.");
				System.out.println(e);
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Método estático para obtener una propiedad
    public static String getProps(String key) {
        return properties.getProperty(key);
    }

	public static void main(String[] args) {
		
		/*
		* Clase para insertar datos por primera vez por si no hay
		*/
		
		Cliente ingeniero = new Cliente("001", "JhonF");
	
		Producto item1 = new  Electronico("0000001", "Tablet", 870000, false, "3 Voltios");
		Producto item2 = new Comestible("0000101", "Monster lata", 5800, "15 de Junio de 2025", true, "42 Calorias");
		Producto item3 = new Electronico("0000035", "Cargador Tipo C", 75000,  false, "3 Voltios");
		Producto item4 = new Comestible("0000117", "Donuts * 12 Unidades", 55000, "1 de marzo de 2025", true, "300 Calorias por unidad");

		Date fecha = new Date();
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(item1);
		listaProductos.add(item2);
		listaProductos.add(item3);
		listaProductos.add(item4);

		Pedido pedido = new Pedido("0000000001", ingeniero, fecha, listaProductos);
		System.out.println("Insertando datos si no existen:\n");

		//Paso 1 insertar cliente
		respuesta = cd.createElemento(ingeniero);
		System.out.println(respuesta);
		
		//Paso 2 Insertar productos
		for (int i = 0; i < listaProductos.size(); i++) {
            respuesta = pd.createElemento(listaProductos.get(i));
            System.out.println(respuesta);
        }

		//Paso 4 Insertar pedido
		respuesta = ped.createElemento(pedido);
		System.out.println(respuesta);

		//Paso 5 Listar productos por rango de precios
		listaProductos.clear();
		listaProductos = (ArrayList<Producto>) pd.FilterByPrecio(10000, 	900000);
		System.out.println("\nListado de Productos por rango de precio:");
		System.out.println("ID \t|Descripcion\t|Precio");
		System.out.println("--------|---------------|--------");
		for (int i = 0; i < listaProductos.size(); i++) {
			int ls = i + 1;
            System.out.println(ls +": \t " + listaProductos.get(i).getDescripcion() + ", \t " + listaProductos.get(i).getPrecio());
        }
	}
}
