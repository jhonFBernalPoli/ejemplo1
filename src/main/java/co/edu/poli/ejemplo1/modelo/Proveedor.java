package co.edu.poli.ejemplo1.modelo;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Proveedor {

    /**
     * Default constructor
     */
    public Proveedor() {
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private Certificacion certificacion;

    /**
     * 
     */
    private Evaluacion evaluacion;

    /**
     * 
     */
    private Proveedor.PoliticaEntrega politicaEntrega;

    /**
     * @return
     */
    private Builder builder() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public class PoliticaEntrega {

        /**
         * Default constructor
         */
        public PoliticaEntrega() {
        }

        /**
         * 
         */
        private void descripcion;

    }

}