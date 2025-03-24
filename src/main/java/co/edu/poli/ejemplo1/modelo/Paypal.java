package co.poli.edu.ejemplo1.modelo;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Paypal extends Pago implements PagoAdapter {

    /**
     * Default constructor
     */
    public Paypal() {
    }

    /**
     * 
     */
    private String cuenta;

    /**
     * 
     */
    private String correo;

    /**
     * @param monto
     */
    public void ProcessPayment(double monto) {
        // TODO implement PagoAdapter.ProcessPayment() here
    }

}