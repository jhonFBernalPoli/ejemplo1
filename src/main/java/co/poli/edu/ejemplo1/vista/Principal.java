package co.poli.edu.ejemplo1.vista;

import java.util.ArrayList;
import java.util.Date;

import co.poli.edu.ejemplo1.modelo.Cliente;
import co.poli.edu.ejemplo1.modelo.Pedido;
import co.poli.edu.ejemplo1.modelo.Producto;
import co.poli.edu.ejemplo1.servicio.ClienteDAOImpl;
import co.poli.edu.ejemplo1.servicio.PedidoDAOImpl;
import co.poli.edu.ejemplo1.servicio.ProductoDAOImpl;

public class Principal {

	static String respuesta = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cliente ingeniero = new Cliente("001", "JhonF");
		Producto item1 = new Producto("0000001", "Memoria USB", 35000);
		Producto item2 = new Producto("0000101", "Disco SSD", 380000);
		Producto item3 = new Producto("0000035", "Cable HDMI", 15000);
		Date fecha = new Date();
		ArrayList<Producto> listaItems = new ArrayList<Producto>();
		listaItems.add(item1);
		listaItems.add(item2);
		listaItems.add(item3);
		Pedido pedido = new Pedido("0000000001", ingeniero, fecha, listaItems);
		
		//Paso 1 insertar cliente
		ClienteDAOImpl cd = new ClienteDAOImpl();
		respuesta = cd.createElemento(ingeniero);
		System.out.println(respuesta);
		
		//Paso 2 Insertar productos
		ProductoDAOImpl pd = new ProductoDAOImpl();
		for (int i = 0; i < listaItems.size(); i++) {
            respuesta = pd.createElemento(listaItems.get(i));
            System.out.println(respuesta);
        }

		//Paso 3 Insertar pedido
		PedidoDAOImpl ped = new PedidoDAOImpl();
		respuesta = ped.createElemento(pedido);
		System.out.println(respuesta);
	}
}
