package co.poli.edu.ejemplo1.modelo;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Pedido {

    private String numero;
    private Cliente cliente;
    private Date fecha;
    private ArrayList<Producto> producto;
    
	public Pedido(String numero, Cliente cliente, Date fecha, ArrayList<Producto> producto) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.fecha = fecha;
		this.producto = producto;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}

}