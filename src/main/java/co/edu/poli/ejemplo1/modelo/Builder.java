package co.edu.poli.ejemplo1.modelo;

/**
 * 
 */
public interface ProveedorBuilder {

    /**
     * @param id 
     * @return
     */
    public ProveedorBuilder addId(String id);

    /**
     * @param nombre 
     * @return
     */
    public ProveedorBuilder addNombre(String nombre);

    /**
     * @param certificacion 
     * @return
     */
    public ProveedorBuilder addCertificacion(Certificacion certificacion);

    /**
     * @param politicaEntrega 
     * @return
     */
    public ProveedorBuilder addPoliticaEntrega(Proveedor.PoliticaEntrega politicaEntrega);

    /**
     * @param evaluacion 
     * @return
     */
    public ProveedorBuilder addEvaluacion(Evaluacion evaluacion);

}