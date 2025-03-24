package co.poli.edu.ejemplo1.modelo;

import java.io.*;
import java.util.*;

/**
 * 
 */
public interface ProveedorBuilder {

    /**
     * @param id 
     * @return
     */
    public Builder addId(String id);

    /**
     * @param nombre 
     * @return
     */
    public Builder addNombre(String nombre);

    /**
     * @param certificacion 
     * @return
     */
    public Builder addCertificacion(Certificacion certificacion);

    /**
     * @param politicaEntrega 
     * @return
     */
    public Builder addPoliticaEntrega(Proveedor.PoliticaEntrega politicaEntrega);

    /**
     * @param evaluacion 
     * @return
     */
    public Builder addEvaluacion(Evaluacion evaluacion);

}