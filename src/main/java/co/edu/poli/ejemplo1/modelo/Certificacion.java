package co.poli.edu.ejemplo1.modelo;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class Certificacion extends Proveedor implements ProveedorBuilder {

    /**
     * Default constructor
     */
    public Certificacion() {
    }

    /**
     * 
     */
    private String titulo;

    /**
     * 
     */
    private String entidad;

    /**
     * @param id 
     * @return
     */
    public Builder addId(String id) {
        // TODO implement ProveedorBuilder.addId() here
        return null;
    }

    /**
     * @param nombre 
     * @return
     */
    public Builder addNombre(String nombre) {
        // TODO implement ProveedorBuilder.addNombre() here
        return null;
    }

    /**
     * @param certificacion 
     * @return
     */
    public Builder addCertificacion(Certificacion certificacion) {
        // TODO implement ProveedorBuilder.addCertificacion() here
        return null;
    }

    /**
     * @param politicaEntrega 
     * @return
     */
    public Builder addPoliticaEntrega(Proveedor.PoliticaEntrega politicaEntrega) {
        // TODO implement ProveedorBuilder.addPoliticaEntrega() here
        return null;
    }

    /**
     * @param evaluacion 
     * @return
     */
    public Builder addEvaluacion(Evaluacion evaluacion) {
        // TODO implement ProveedorBuilder.addEvaluacion() here
        return null;
    }

}